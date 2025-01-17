package ProgramacionOrientadaAObjetos;

class Automovil {

    private String fabricante;
    private String modelo;
    private Color color = Color.GRIS_OSCURO;
    private Motor motor;
    private Tanque tanque;
    private int id;
    private TipoAutomovil tipo;
    private Persona conductor;
    private Rueda[] ruedas;
    private int indiceRuedas = 0;

    private static int capacidadTanqueEstatico = 30;
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
        this.ruedas = new Rueda[5];
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

    public Automovil(String fabricante, String modelo, Color color, Motor motor) {
        this(fabricante,modelo,color);
        this.motor = motor;
    }

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanque) {
        this(fabricante,modelo,color,motor);
        this.tanque = tanque;
    }

    

    public Automovil(String fabricante, String modelo, Color color, Motor motor, Tanque tanque, Persona conductor,
            Rueda[] ruedas) {
        this(fabricante,modelo,color,motor,tanque);
        this.conductor = conductor;
        this.ruedas = ruedas;
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

    public static void setCapacidadTanqueEstatico(int capacidadTanqueEstatico) {
        Automovil.capacidadTanqueEstatico = capacidadTanqueEstatico;
    }

    public static int getCapacidadTanqueEstatico() {
        return capacidadTanqueEstatico;
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

    public void setMotor(Motor motor){
        this.motor = motor;
    }

    public Motor getMotor(){
        return this.motor;
    }

    public void setTanque(Tanque tanque){
        this.tanque = tanque;
    }

    public Tanque getTanque(){
        if(this.tanque==null){
            this.tanque = new Tanque();
        }

        return this.tanque;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTipo(TipoAutomovil tipo) {
        this.tipo = tipo;
    }

    public TipoAutomovil getTipo() {
        return tipo;
    }

    public void setConductor(Persona conductor) {
        this.conductor = conductor;
    }

    public Persona getConductor() {
        return conductor;
    }

    public void setRuedas(Rueda[] ruedas) {
        this.ruedas = ruedas;
    }

    public Rueda[] getRuedas() {
        return ruedas;
    }

    public Automovil addRueda(Rueda rueda){
        if(indiceRuedas<this.ruedas.length){
            this.ruedas[indiceRuedas++] = rueda;
        }
        return this;
    }

    public String verDetalle(){
        String detalle = "\nId: " + this.id + 
        "\nFabricante: " + this.fabricante + 
        "\nModelo: " + this.modelo;
        
        if(this.getTipo()!=null){
            detalle+= "\nTipo = " + this.getTipo().getDescripcion();
        }
        
        detalle+="\nColor: " + this.color;
        if(this.getMotor()!=null){
            detalle += "\nCilindrada: " + this.motor.getCilindrada();
        }
        
        detalle+= "\nPatenteColor: " +  colorPatente;
        if(getConductor()!=null){
            detalle += "\nConductor del automóvil: " + this.getConductor();
        }
        
        if(getRuedas()!=null){
            detalle += "\nRuedas del automóvil:";
            for(Rueda r:this.getRuedas()){
                detalle+= "\n" + r. getFabricante() +" Aro: "+ r.getAro() +" Ancho: "+ r.getAncho();
            }
        }

        return detalle;
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

    public float calcularConsumo(int km, float porcentajeGasolina){
        return km/(getTanque().getCapacidad()*porcentajeGasolina);
    }

    public float calcularConsumo(int km, int porcentajeGasolina){
        return km/(getTanque().getCapacidad()*(porcentajeGasolina/100f));
    }

    public static float calcularConsumoEstatico(int km, int porcentajeGasolina){
        return km/(Automovil.capacidadTanqueEstatico*(porcentajeGasolina/100f));
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
