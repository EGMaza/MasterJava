package org.egmaza.pooclasesabstractas.form;

import java.util.Arrays;
import java.util.List;

import org.egmaza.pooclasesabstractas.form.elementos.*;
import org.egmaza.pooclasesabstractas.form.elementos.select.Opcion;

public class EjemploForm {
    public static void main(String[] args) {

        InputForm username = new InputForm("username");
        InputForm password = new InputForm("clave", "password");
        InputForm email = new InputForm("email", "email");
        InputForm edad = new InputForm("edad", "number");
        
        TextAreaForm experiencia = new TextAreaForm("exp",5,9);

        SelectForm lenguaje = new SelectForm("Lenguaje");
        Opcion java = new Opcion("1","Java");
        lenguaje.addOpcion(java);
        lenguaje.addOpcion(new Opcion("2","Python").setSelected());
        lenguaje.addOpcion(new Opcion("3","JavaScript"));
        lenguaje.addOpcion(new Opcion("4","TypeScript"));
        lenguaje.addOpcion(new Opcion("5","PHP"));

        username.setValor("john.doe");
        password.setValor("a1b2c3");
        email.setValor("john.doe@correo.com");
        edad.setValor("28");
        experiencia.setValor("...más de 10 años de experiencia");

        List<ElementoForm> elementos = Arrays.asList(username,
        password,
        email,
        edad,
        experiencia,
        lenguaje);

        elementos.forEach(e -> {
            System.out.println(e.dibujarHtml());
            System.out.println("<br>");
        });

        ElementoForm saludar = new ElementoForm("saludo") {

            @Override
            public String dibujarHtml() {

                return "<input disabled name='" + this.nombre + "' value=\"" + this.valor + "\">";
            }  
        };
        System.out.println(saludar.dibujarHtml());
    }
}