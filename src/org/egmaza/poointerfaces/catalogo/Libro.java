package org.egmaza.poointerfaces.catalogo;

import java.util.Date;

public class Libro extends Producto implements ILibro{

    private Date fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;
    
    public Libro(int precio, Date fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }
    
    public double getPrecioVenta(){
        return precio;
    }

    @Override
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }

    @Override
    public String getAutor() {
        return this.autor;
    }

    @Override
    public String getTitulo() {
        return this.titulo;
    }

    @Override
    public String getEditorial() {
        return this.editorial;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString())
            .append("\nFecha de publicacion: ")
            .append(fechaPublicacion)
            .append("\nAutor: ")
            .append(autor)
            .append("\nTitulo: ")
            .append(titulo);
        return sb.toString();
    }
}