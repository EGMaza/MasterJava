package org.egmaza.personascompaniia;

public class Persona {
    private String nombre;
    private String apellido;
    private String numeroFiscal;
    private String direccion;

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Persona(String nombre, String apellido, String numeroFiscal) {
        this(nombre, apellido);
        this.numeroFiscal = numeroFiscal;
    }

    public Persona(String nombre, String apellido, String numeroFiscal, String direccion) {
        this(nombre,apellido,numeroFiscal);
        this.direccion = direccion;
    }


    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getNumeroFiscal() {
        return numeroFiscal;
    }
    public String getDireccion() {
        return direccion;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("nombre: ")
            .append(this.getNombre())
            .append("\napellido: ")
            .append(this.getApellido());

        if(this.numeroFiscal!=null){
            sb.append("\nnumero fiscal: ").append(this.getNumeroFiscal());
        }
        else{
            sb.append("\nnumero fiscal: no especificado");
        }
        if(this.direccion!=null){
            sb.append("\ndireccion: ").append(this.getDireccion());
        }
        else{
            sb.append("\ndirección: no especificada");
        }

        return sb.toString();
    }
}