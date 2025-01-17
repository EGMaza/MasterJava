package ProgramacionOrientadaAObjetos;

public class EjemploAutomovilRelacionesObjetos {
    public static void main(String[] args) {

        Persona conductorSubaru = new Persona("Luci", "Martínez");
        Automovil subaru = new Automovil("Subaru","Impreza");
        Motor motorSubaru = new Motor(2.0,TipoMotor.GASOLINA);
        subaru.setMotor(motorSubaru);
        subaru.setTanque(new Tanque());
        subaru.setColor(Color.BLANCO);
        subaru.setTipo(TipoAutomovil.HATCHBACK);
        subaru.setConductor(conductorSubaru);
        Rueda[] ruedasSubaru = new Rueda[5];
        for(int i=0;i<ruedasSubaru.length;i++){
            subaru.addRueda(new Rueda("Yokohama", 16, 7.5));
        }
        //subaru.setRuedas(ruedasSubaru);

        Motor motorMazda = new Motor(3.0,TipoMotor.DIESEL);
        Automovil mazda = new Automovil("Mazda","BT-50",Color.ROJO,motorMazda);
        Persona conductorMazda = new Persona("Pato", "Rodriguez");
        mazda.setTanque(new Tanque(50));
        mazda.setTipo(TipoAutomovil.PICKUP);
        mazda.setConductor(conductorMazda);
        Rueda[] ruedasMazda = new Rueda[5];
        for(int i=0;i<ruedasMazda.length;i++){
            mazda.addRueda(new Rueda("Michelin", 18, 10.5));
        }

        //mazda.setRuedas(ruedasMazda);

        Rueda[] ruedasNissan = new Rueda[5];
        for(int i=0;i<ruedasNissan.length;i++){
            ruedasNissan[i] = new Rueda("Pirelli",20,11.5);
        }

        Motor motorNissan = new Motor(4.0,TipoMotor.GASOLINA);
        Persona conductorNissan1 = new Persona("Bea", "González");
        Automovil nissan = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48),conductorNissan1,ruedasNissan);
        
        Rueda[] ruedasNissan2 = new Rueda[5];
        for(int i=0;i<ruedasNissan2.length;i++){
            ruedasNissan2[i] = new Rueda("Pirelli",21,11.5);
        }
        
        Persona conductorNissan2 = new Persona("Lalo", "Mena");
        Automovil nissan2 = new Automovil("Nissan","Navara",Color.GRIS_OSCURO,motorNissan,new Tanque(48),conductorNissan2,ruedasNissan2);
        nissan.setTipo(TipoAutomovil.PICKUP);
        nissan2.setTipo(TipoAutomovil.PICKUP);
        
        Automovil.setColorPatente(Color.NARANJA);
        
        System.out.println(subaru.verDetalle());
        System.out.println(mazda.verDetalle());
        System.out.println(nissan.verDetalle());
        System.out.println(nissan2.verDetalle());
/*
        System.out.println("Conductor Subaru: " + subaru.getConductor());
        System.out.println("Ruedas subaru: ");
        for(Rueda r:subaru.getRuedas()){
            System.out.println(r. getFabricante() +" Aro: "+ r.getAro() +" Ancho: "+ r.getAncho());
        }*/
    }
}
