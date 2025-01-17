package ProgramacionOrientadaAObjetos;

public class EjemploAutomovilStatic {
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


        Motor motorNissan = new Motor(4.0,TipoMotor.GASOLINA);
        Automovil nissan = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48));
        Automovil nissan2 = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48));
        nissan.setTipo(TipoAutomovil.PICKUP);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        
        Automovil.setColorPatente(Color.NARANJA);
        
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());

        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("kilometros por litros = " + Automovil.calcularConsumoEstatico(300, 60));
        System.out.println("Velocidad máxima en carretera: " + Automovil.VELOCIDAD_MAX_CARRETERA);
        System.out.println("Velocidad máxima en ciudad: " + Automovil.VELOCIDAD_MAX_CIUDAD);

        TipoAutomovil tipoSubaru = subaru.getTipo();
        System.out.println("Tipo subaru = " + tipoSubaru.getNombre());
        System.out.println("Tipo desc. subaru = " + tipoSubaru.getDescripcion());

    }

}
