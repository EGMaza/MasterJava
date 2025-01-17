package ProgramacionOrientadaAObjetos;

import java.util.Arrays;

public class EjemploAutomovilArreglo {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Luci", "Martínez");
        Automovil subaru = new Automovil("Subaru","Impreza");
        Motor motorSubaru = new Motor(2.0,TipoMotor.GASOLINA);
        subaru.setMotor(motorSubaru);
        subaru.setTanque(new Tanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);

        Motor motorMazda = new Motor(3.0,TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda","BT-50",Color.ROJO,motorMazda);
        Persona conductorMazda = new Persona("Pato", "Rodriguez");
        mazda.setTanque(new Tanque(50));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(conductorMazda);

        Motor motorNissan = new Motor(4.0,TipoMotor.GASOLINA);
        Persona conductorNissan1 = new Persona("Bea", "González");
        Automovil nissan = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48));
        nissan.setConductor(conductorNissan1);
        nissan.setTipo(TipoAutomovil.PICKUP);
        
        Persona conductorSuzuki = new Persona("Lalo", "Mena");
        Automovil suzuki = new Automovil("Suzuki","Vitara",Color.GRIS_OSCURO,new Motor(16,TipoMotor.GASOLINA),new Tanque(48));
        suzuki.setConductor(conductorSuzuki);
        suzuki.setTipo(TipoAutomovil.SUV);
        
        Automovil.setColorPatente(Color.NARANJA);

        Persona conductorAudi = new Persona("Jano", "Perez");
        Automovil audi = new Automovil("Audi","A3");
        audi.setConductor(conductorAudi);

        Automovil[] autos = new Automovil[5];
        autos[0] = subaru;
        autos[1] = mazda;
        autos[2] = nissan;
        autos[3] = suzuki;
        autos[4] = audi;

        Arrays.sort(autos);
        for(int i=0;i<autos.length;i++){
            System.out.println(autos[i]);
        }


    }
}