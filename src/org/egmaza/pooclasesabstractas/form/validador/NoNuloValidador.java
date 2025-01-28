package org.egmaza.pooclasesabstractas.form.validador;

public class NoNuloValidador extends Validador{
    protected String mensaje = "el campo no puede ser nulo";

    @Override
    public boolean esValido(String valor) {
        return (valor != null);
    }

    @Override
    public String getMensaje() {
        return mensaje;
    }

    @Override
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    

}
