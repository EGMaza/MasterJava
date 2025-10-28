package org.egmaza.junit5app.ejemplos.models;

import org.egmaza.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuentaTest {

    Cuenta cuenta;
    private TestInfo testInfo = null;
    private TestReporter testReporter = null;

    @BeforeEach
    void initMetodoTest(TestInfo testInfo, TestReporter testReporter) {

        this.testInfo = testInfo;
        this.testReporter = testReporter;

        this.cuenta = new Cuenta("Andrés", new BigDecimal("1000.12345"));
        System.out.println("Iniciando el método");
        testReporter.publishEntry("Ejecutando: " + testInfo.getDisplayName() +
                " " + testInfo.getTestMethod().orElse(null).getName() +
                " con las etiquetas " + testInfo.getTags());
    }

    @AfterEach
    void tearDown() {
        System.out.println("Finalizando el método de prueba");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Finalizando el test");
    }

    @Tag("cuenta")
    @Nested
    @DisplayName("Probando atributos de la cuenta corriente")
    class CuentaTestNombreSaldo{
        @Test
        @DisplayName("el nombre!")
        void testNombreCuenta() {

            testReporter.publishEntry(testInfo.getTags().toString());

            if(testInfo.getTags().contains("cuenta")){
                testReporter.publishEntry("Hacer algo con la etiqueta cuenta");
            }
            String esperado = "Andrés";
            String actual = cuenta.getPersona();
            assertNotNull(actual, () -> "La cuenta no puede ser nula");
            assertEquals(esperado, actual, () -> "El nombre de la cuenta no es el que se esperaba: se esperaba " +
                    esperado + " pero se recibió " + actual);
            assertTrue(actual.equals("Andrés"), () -> "El nombre de cuentahabiente esperado debe ser igual al actual");
        }

        @Test
        @DisplayName("El saldo de la cuenta corriente, que no sea null, mayor que cero, valor esperado.")
        void testSaldoCuenta() {
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        @DisplayName("Testeando referencias que sean iguales con el método equals")
        void testReferenciaCuenta() {
            cuenta = new Cuenta("John Doe", new BigDecimal(8900.9997));
            Cuenta cuenta2 = new Cuenta("John Doe", new BigDecimal(8900.9997));
            //assertNotEquals(cuenta2, cuenta);
            assertEquals(cuenta2, cuenta);
        }
    }

    @Nested
    class CuentaOperacionesTest{
        @Tag("cuenta")
        @Test
        void testDebitoCuenta() {
            //cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Test
        void testCreditoCuenta() {
            //Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
            assertEquals("1100.12345", cuenta.getSaldo().toPlainString());
        }

        @Tag("cuenta")
        @Tag("banco")
        @Test
        void testTransferirDineroCuentas() {
            Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
            Cuenta cuenta2 = new Cuenta("Andres Smith", new BigDecimal("1500.8989"));

            Banco banco = new Banco();
            banco.setNombre("Banco del estado");
            banco.transferir(cuenta2, cuenta1, new BigDecimal(500));
            assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
            assertEquals("3000", cuenta1.getSaldo().toPlainString());
        }
    }

    @Test
    @Tag("cuenta")
    @Tag("error")
    void testDineroInsuficienteExceptionCuenta() {
        //Cuenta cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        Exception exception = assertThrows(DineroInsuficienteException.class, (() -> {
            cuenta.debito(new BigDecimal(1500));
        }));

        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    //@Disabled
    @Tag("cuenta")
    @Tag("banco")
    @DisplayName("Probando relaciones entre las cuentas y el banco con assertAll")
    void testRelacionBancoCuentas() {
        //fail();
        Cuenta cuenta1 = new Cuenta("John Doe", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Andres Smith", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta1);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta1, new BigDecimal(500));

        assertAll(() -> assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(), () -> "El valor del saldo de la cuenta2 no es el esperado."),
                () -> assertEquals("3000", cuenta1.getSaldo().toPlainString(), () -> "El valor del saldo de la cuenta1 no es el esperado."),
                () -> assertEquals(2, banco.getCuentas().size()),
                () -> assertEquals("Banco del Estado", cuenta1.getBanco().getNombre(), () -> "El banco no tiene las cuentas esperadas"),
                () -> assertEquals("Andres Smith", banco.getCuentas().stream()
                        .filter(c -> c.getPersona().equals("Andres Smith"))
                        .findFirst().get().getPersona()),
                () -> assertTrue(banco.getCuentas().stream()
                        .anyMatch(c -> c.getPersona().equals("John Doe"))));
    }

    @Nested
    class SistemaOperativotest {

        @Test
        @EnabledOnOs(OS.WINDOWS)
        void testSoloWindows() {

        }

        @Test
        @EnabledOnOs({OS.LINUX, OS.MAC})
        void testSoloMac() {

        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void testNoWindows() {

        }
    }

    @Nested
    class JavaVersionTest{

        @Test
        @EnabledOnJre(JRE.JAVA_8)
        void testSoloJdk8() {

        }

        @Test
        @EnabledOnJre(JRE.JAVA_15)
        void testSoloJdk15() {
        }

        @Test
        @DisabledOnJre(JRE.JAVA_15)
        void testNoJDK15() {
        }

    }

    @Nested
    class SystemPropertiesTest{
        @Test
        void imprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k, v) -> System.out.println(k + ": " + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "25")
        void testJavaVersion() {

        }

        @Test
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testSolo64() {

        }

        @Test
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*32.*")
        void testNo64() {

        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "egmaza")
        void testUserName(){

        }

        @Test
        @EnabledIfSystemProperty(named = "ENV", matches = "dev")
        void testDev(){

        }
    }

    @Nested
    class VariableAmbienteTest{
        @Test
        void imprimirVariablesAmbiente() {
            Map<String, String> getEnv = System.getenv();
            getEnv.forEach((k, v) -> System.out.println(k + " = " + v));
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "JAVA_HOME", matches = ".*jdk-25.*")
        void testJavaHome() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "8")
        void testProcesadores() {
        }

        @Test
        @EnabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "dev")
        void testEnvironment(){

        }

        @Test
        @DisabledIfEnvironmentVariable(named = "ENVIRONMENT", matches = "prod")
        void testEnvironmentProdDisabled(){

        }
    }

    @Test
    @DisplayName("Test Saldo Cuenta Dev")
    void testSaldoCuentaDev() {
        boolean esDev = "env".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        assertNotNull(cuenta.getSaldo());
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    @DisplayName("Test2 Saldo Cuenta Dev")
    void testSaldoCuentaDev2() {
        boolean esDev = "env".equals(System.getProperty("ENV"));
        assumingThat(esDev, () -> {
            System.out.println("Asumió");
            assertNotNull(cuenta.getSaldo());
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        });
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @DisplayName("Probando Debito Cuenta Repetir!!")
    @RepeatedTest(value = 5, name = "{displayName} - Repetición número {currentRepetition} de {totalRepetitions}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {
        if(info.getCurrentRepetition()==3){
            System.out.println("Estamos en la repetición " + info.getCurrentRepetition());
        }
        cuenta = new Cuenta("Andres", new BigDecimal("1000.12345"));
        cuenta.debito(new BigDecimal(100));
        System.out.println("repe");
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Tag("param")
    @Nested
    class PruebasParametrizadasTest {
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @ValueSource(strings = {"100", "200", "300", "500", "700", "1000.12345"})
        void testDebitoCuentaValueSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700", "6,1000.12345"})
        void testDebitoCuentaCsvSource(String index, String monto) {
            System.out.println(index + " -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvSource({"200,100,John,Andres", "250,200,Pepe,Pepe", "300,300,Maria,María", "510,500,Pepa,Pepa", "750,700,Lucas,Lucca", "1000.12345,1000.12345, Cata, Cata"})
        void testDebitoCuentaCsvSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(saldo + " -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);
            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado,actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data.scv")
        void testDebitoCuentaCsvFileSource(String monto) {
            System.out.println(" -> " + monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @CsvFileSource(resources = "/data2.scv")
        void testDebitoCuentaCsvFileSource2(String saldo, String monto, String esperado, String actual) {
            System.out.println(" -> " + monto);
            cuenta.setSaldo(new BigDecimal(saldo));
            cuenta.debito(new BigDecimal(monto));
            cuenta.setPersona(actual);

            assertNotNull(cuenta.getSaldo());
            assertNotNull(cuenta.getPersona());
            assertEquals(esperado,actual);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }
    }

    @Tag("param")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto) {
        System.out.println(" -> " + monto);
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    static List<String> montoList(){
        return Arrays.asList("100", "200", "300", "500", "700", "1000.12345");
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeoutTest{
        @Test
        @Timeout(1)
        void pruebaTimeout() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(1);
        }

        @Test
        @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
        void pruebaTimeout2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(900);
        }

        @Test
        void testTimeoutAssertion() {
            assertTimeout(Duration.ofSeconds(5), ()->{
                TimeUnit.MILLISECONDS.sleep(4000);
            });
        }
    }
}