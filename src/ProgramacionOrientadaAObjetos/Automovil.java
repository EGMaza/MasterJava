package ProgramacionOrientadaAObjetos;

class Automovil {

    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS_OSCURO;
    private double cilindrada;
    private int capacidadEstanque = 40;
    private int id;

    private static int capacidadEstanqueEstatico = 30;
    private static Color colorPatente = Color.NARANJA;
    private static int ultimoId;

    public static final Integer VELOCIDAD_MAX_CARRETERA = 120;
    public static final int VELOCIDAD_MAX_CIUDAD = 60;
    public static final String COLOR_ROJO = "rojo";
    public static final String COLOR_AMARILLO = "amarillo";
    public static final String COLOR_AZUL = "azul";
    public static final String COLOR_BLANCO = "blanco";
    public static final String COLOR_GRIS = "gris oscuro";

    public Automovil(){
        this.id = ++ultimoId;
    }

    public Automovil(String fabricante, String modelo){
        this();
        this.fabricante = fabricante;
        this.modelo = modelo;
    }

    public Automovil(String fabricante, String modelo, Color color){
        this(fabricante,modelo);
        this.color = color;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada) {
        this(fabricante,modelo,color);
        this.cilindrada = cilindrada;
    }

    public Automovil(String fabricante, String modelo, Color color, double cilindrada, int capacidadEstanque) {
        this(fabricante,modelo,color,cilindrada);
        this.capacidadEstanque = capacidadEstanque;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public String getFabricante(){
        return this.fabricante;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getModelo(){
        return this.modelo;
    }

    public static void setCapacidadEstanqueEstatico(int capacidadEstanqueEstatico) {
        Automovil.capacidadEstanqueEstatico = capacidadEstanqueEstatico;
    }

    public static int getCapacidadEstanqueEstatico() {
        return capacidadEstanqueEstatico;
    }

    public static void setColorPatente(Color colorPatente){
        Automovil.colorPatente = colorPatente;
    }

    public static Color getColorPatente() {
        return colorPatente;
    }

    public void setColor(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void setCilindrada(double cilindrada){
        this.cilindrada = cilindrada;
    }

    public double getCilindrada(){
        return this.cilindrada;
    }

    public void setCapacidadEstanque(int capacidadEstanque){
        this.capacidadEstanque = capacidadEstanque;
    }

    public int getCapacidadEstanque(){
        return this.capacidadEstanque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String verDetalle(){
        return "\nId: " + this.id + "\nFabricante: " + this.fabricante + "\nModelo: " +
         this.modelo + "\nColor: " + this.color + "\nCilindrada: " + this.cilindrada +
         "\npatenteColor: " +  colorPatente;
    }

    public String acelerar(int rpm){
        return "el auto " + this.fabricante + " está acelerando a " + rpm + " rpm";
    }

    public String frenar(){
        return this.fabricante + " " + this.modelo + " frenando...";
    }

    public String acelerarFrenar(int rpm){
        String acelerar = this.acelerar(rpm);
        String frenar = this.frenar();
        return acelerar + "\n" + frenar;
    }

    public float calcularConsumo(int km, float porcentajeBencina){
        return km/(capacidadEstanque*porcentajeBencina);
    }

    public float calcularConsumo(int km, int porcentajeBencina){
        return km/(capacidadEstanque*(porcentajeBencina/100f));
    }

    public static float calcularConsumoEstatico(int km, int porcentajeBencina){
        return km/(Automovil.capacidadEstanqueEstatico*(porcentajeBencina/100f));
    }    

    @Override
    public boolean equals(Object obj) {
            if(!(obj instanceof Automovil)){
                return false;
            }
            if(this==obj){
                return true;
            }
            Automovil a = (Automovil)obj;
            return (this.getFabricante()!=null && this.getModelo()!=null && this.fabricante.equals(a.getFabricante()) && this.modelo.equals(a.getModelo()));
    }

    @Override
    public String toString() {
        return this.fabricante + " " + this.modelo;
    }

    
    
    
}
