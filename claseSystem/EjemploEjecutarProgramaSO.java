package claseSystem;

import java.io.IOException;

public class EjemploEjecutarProgramaSO {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Process proceso;

        try{
            if(System.getProperty("os.name").toLowerCase().startsWith("windows")){
                proceso = rt.exec("notepad");
            }
            else if(System.getProperty("os.name").toLowerCase().startsWith("mac")){
                proceso = rt.exec("textedit");
            }
            else if(System.getProperty("os.name").toLowerCase().contains("nix")||
            System.getProperty("os.name").toLowerCase().contains("nux")){
                proceso = rt.exec("gedit");
            }
            else{
                proceso = rt.exec("gedit");
            }
            proceso.waitFor();
    }catch(IOException e){
        System.err.println("El comando es desconocido " + e.getMessage());
        System.exit(1);
    }catch(InterruptedException e){
        System.err.println("El comando es desconocido " + e.getMessage());
        System.exit(1);
    }

    System.out.println("Se ha cerrado el editor");
    //Nota: la clase Runtime también se puede ocupar para ejecutar comandos de la consola de comandos        
    //Comentario de prueba agregado desde otro usuario


    }
}
