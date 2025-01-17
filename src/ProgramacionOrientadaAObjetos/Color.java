package ProgramacionOrientadaAObjetos;

public enum Color {
    ROJO("rojo"),
    AMARILLO("amarillo"),
    AZUL("azul"),
    BLANCO("blanco"),
    GRIS_OSCURO("gris oscuro"),
    NARANJA("naranja");

    private final String color;

    private Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return this.color;
    }
    
    
}
