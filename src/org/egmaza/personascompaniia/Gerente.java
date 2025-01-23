package org.egmaza.personascompaniia;

public class Gerente extends Empleado{
    private double presupuesto;

    

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion);
    }

    public Gerente(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion,
            double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
        .append("\npresupuesto: ")
        .append(this.getPresupuesto());
        return  sb.toString();
    }   
}