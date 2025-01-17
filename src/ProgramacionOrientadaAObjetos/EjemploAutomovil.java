package ProgramacionOrientadaAObjetos;

import java.util.Date;

public class EjemploAutomovil {
    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {
        Automovil subaru = new Automovil("Subaru","Impreza");
        Motor motorSubaru = new Motor(2.0,TipoMotor.GASOLINA);
        subaru.setMotor(motorSubaru);
        subaru.setTanque(new Tanque());
        subaru.setColor(Color.BLANCO);

        Motor motorMazda = new Motor(3.0,TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda","BT-50",Color.ROJO,motorMazda);
        mazda.setTanque(new Tanque(45));
        
        Motor motorNissan = new Motor(4.0,TipoMotor.GASOLINA);
        Automovil nissan = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48));
        Automovil nissan2 = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48));

        Automovil auto = new Automovil();
        Date fecha = new Date();        
        
        System.out.println(auto.equals(fecha));
        System.out.println(auto.equals(nissan2));
        System.out.println("son iguales?: " + (nissan==nissan2));
        System.out.println("son iguales?: " + (nissan.equals(nissan2)));

     
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());

        System.out.println(nissan);
        System.out.println(nissan.toString());

        System.out.println(subaru.acelerar(3000));
        System.out.println(subaru.frenar());

        System.out.println(mazda.acelerarFrenar(6000));

        System.out.println("Automovil.getColorPatente() = " + Automovil.getColorPatente());
        System.out.println("Kilómetros por litro del auto " + subaru.getModelo()+ " : " + subaru.calcularConsumo(300, 0.6f));
        System.out.println("Kilómetros por litro del auto " + mazda.getModelo()+ " : " + mazda.calcularConsumo(300, 60));
        System.out.println("Kilómetros por litro del auto " + nissan.getModelo()+ " : " + nissan.calcularConsumo(300, 60));
    }
}
