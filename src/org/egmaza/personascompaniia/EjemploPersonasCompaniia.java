package org.egmaza.personascompaniia;

public class EjemploPersonasCompaniia {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Jose","Martinez","MADJ5678","Calle magnolias no. 25",5000);
        Gerente gerente = new Gerente("Miguel","Rodriguez","RODM1234","Avenida siempre viva no. 99",10000);
        Cliente cliente1 = new Cliente("Manuel","Hernandez","HEDM9012","Cerrada maracaibo no. 3");
        Cliente cliente2 = new Cliente("Samuel","Fernandez");

        gerente.setPresupuesto(12000);
        empleado.aumentarRemuneracion(15);
        gerente.aumentarRemuneracion(15);

        System.out.println(empleado + "\n");
        System.out.println(gerente + "\n");
        System.out.println(cliente1 + "\n");
        System.out.println(cliente2 + "\n");
    }
}