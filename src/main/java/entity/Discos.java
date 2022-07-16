package entity;

public class Discos {
    private int idDiscos;
    private String nombre;
    private String autor;
    private int canciones;
    private double precio;
    private int stock;

    public Discos(int idDiscos, String nombre, String autor, int canciones, double precio, int stock) {
        this.idDiscos = idDiscos;
        this.nombre = nombre;
        this.autor = autor;
        this.canciones = canciones;
        this.precio = precio;
        this.stock = stock;
    }

    public Discos(String nombre, String autor, int canciones, double precio, int stock) {
        this.nombre = nombre;
        this.autor = autor;
        this.canciones = canciones;
        this.precio = precio;
        this.stock = stock;
    }

    public int getIdDiscos() {
        return idDiscos;
    }

    public void setIdDiscos(int idDiscos) {
        this.idDiscos = idDiscos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCanciones() {
        return canciones;
    }

    public void setCanciones(int canciones) {
        this.canciones = canciones;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Discos{" + "nombre=" + nombre + ", autor=" + autor + ", canciones=" + canciones + ", precio=" + precio + ", stock=" + stock + '}';
    }
 
}
