package org.egmaza.patrones.decorator;

import org.egmaza.patrones.decorator.decoradores.MayusculaDecorador;
import org.egmaza.patrones.decorator.decoradores.ReemplazarEspaciosDecorador;
import org.egmaza.patrones.decorator.decoradores.ReversaDecorador;
import org.egmaza.patrones.decorator.decoradores.SubrayadoDecorador;

public class EjemploDecorador {

    public static void main(String[] args) {

        Formateable texto = new Texto("Hola que tal Andrés");
        MayusculaDecorador mayuscula = new MayusculaDecorador(texto);
        ReversaDecorador reversa = new ReversaDecorador(mayuscula);
        SubrayadoDecorador subrayar = new SubrayadoDecorador(reversa);
        ReemplazarEspaciosDecorador reemplazar = new ReemplazarEspaciosDecorador(subrayar);

        System.out.println(reemplazar.darFormato());
    }
}