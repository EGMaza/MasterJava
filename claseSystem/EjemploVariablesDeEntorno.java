package claseSystem;

import java.util.Map;

public class EjemploVariablesDeEntorno {
    public static void main(String[] args) {
        Map<String, String> varEnv = System.getenv();
        //System.out.println("Variables de ambiente del sistema: " + varEnv);
        
        String username = System.getenv("USERNAME");
        System.out.println("Username = " + username);

        String javaHome = System.getenv("JAVA_HOME");
        System.out.println("javaHome = " + javaHome);

        String tempDir = System.getenv("TEMP");
        System.out.println("tempDir = " + tempDir);

        String Path = System.getenv("PATH");
        System.out.println("Path = " + Path);

        String Path2 = varEnv.get("Path");
        System.out.println("Path2 = " + Path2);

        String AppEnv = varEnv.get("APPLICATION_ENV");
        System.out.println("AppEnv = " + AppEnv);

        String varSaludo = varEnv.get("SALUDAR_HOLA");
        System.out.println("varSaludo = " + varSaludo);

        for(String llave:varEnv.keySet()){
            System.out.println("Variable " + llave + " = " + varEnv.get(llave));
        }
    }
}
