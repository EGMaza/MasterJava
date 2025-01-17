package ProgramacionOrientadaAObjetos;

public class EjemploAutomovilEnum {
    public static void main(String[] args) {

        Automovil.setCapacidadTanqueEstatico(45);

        Automovil subaru = new Automovil("Subaru","Impreza");
        Motor motorSubaru = new Motor(2.0,TipoMotor.GASOLINA);
        subaru.setMotor(motorSubaru);
        subaru.setTanque(new Tanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);

        Motor motorMazda = new Motor(3.0,TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda","BT-50",Color.ROJO,motorMazda);
        mazda.setTanque(new Tanque(45));
        mazda.setTipo(TipoAutomovil.PICKUP);
        System.out.println("mazda.fabricante = " + mazda.getFabricante());
        //Automovil.setColorPatente(Color.NARANJA);
        //System.out.println(subaru.verDetalle());
        //System.out.println(mazda.verDetalle());

        TipoAutomovil tipo = subaru.getTipo();
        tipo = mazda.getTipo();
        System.out.println("Tipo subaru = " + tipo.getNombre());
        System.out.println("Tipo desc. subaru = " + tipo.getDescripcion());

        switch (tipo) {
            case CONVERTIBLE:
                System.out.println("El automovil es deportivo y descapotable de dos puertas");
            break;

            case COUPE:
                System.out.println("Es un automóvil de dos puertas y típicamente deportivo");
            break;

            case FURGON:
                System.out.println("Es un automóvil utilitario de transporte, de empresas");
            break;

            case HATCHBACK:
                System.out.println("Es un automóvil mediano compacto, aspecto deportivo");
            break;
            
            case PICKUP:
                System.out.println("Es un automóvil de doble cabina o camioneta");
            break;

            case SEDAN:
                System.out.println("Es un automóvil mediano");
            break;

            case STATION_WAGON:
                System.out.println("Es un automóvil mas grande, con maleta grande");
            break;
        }

        TipoAutomovil[] tipos = TipoAutomovil.values();

        for(TipoAutomovil ta:tipos){
            System.out.print(ta + " => " + ta.name() + 
            ", " + ta.getNombre() +
            ", " + ta.getDescripcion() +
            ", " + ta.getNumeroPuertas());

            System.out.println();
        }
    }
}
