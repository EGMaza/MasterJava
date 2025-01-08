package claseSystem;

import java.io.FileInputStream;
import java.util.Properties;

public class EjemploAsignarPropiedadesDeSistema {
    public static void main(String[] args){
        try{
            FileInputStream archivo = new FileInputStream("claseSystem/configEjemploPropDeSistema.properties");
            Properties p = new Properties(System.getProperties()); 
            p.load(archivo);
            p.setProperty("mi.propiedad.personalizada", "Valor personalizado en el objeto properties");
            System.setProperties(p);
            //System.getProperties().list(System.out);
            Properties ps = new Properties(System.getProperties()); 
            System.out.println("p.getProperty(...) = " + ps.getProperty("mi.propiedad.personalizada"));
            System.out.println(System.getProperty("config.autor.nombre"));
            System.out.println(System.getProperty("config.texto.ambiente"));
            System.out.println(System.getProperty("config.autor.email"));
        }catch(Exception e){
            System.out.println("no existe el archivo = " + e);
        }
        //Nota: las propiedades personalizadas solo viven mientras el programa está en ejecución



    }
}
