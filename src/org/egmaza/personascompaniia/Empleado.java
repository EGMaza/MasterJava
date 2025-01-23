package org.egmaza.personascompaniia;

public class Empleado extends Persona{
    private double remuneracion;
    private int empleadoId;

    private static int iDEmpleados;

    public Empleado(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = ++iDEmpleados;
    }
    public double getRemuneracion() {
        return remuneracion;
    }
    public int getEmpleadoId() {
        return empleadoId;
    }

    public void aumentarRemuneracion(int porcentaje){
        remuneracion += (remuneracion*porcentaje/100);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nsueldo: ")
            .append(this.getRemuneracion())
            .append("\nID de empleado: ")
            .append(this.getEmpleadoId());
        return sb.toString();
    }
}