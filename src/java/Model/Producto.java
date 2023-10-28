
package Model;

/**
 *
 * @author estudiante
 */


public class Producto {
    
    private int id; 
    private String marca;
    private String productoNombre;
    private double precio;
    private int stock;
    private int vendido;

    public Producto() {
    }

    
    
    
    //CONSTRUCTO PARA BUSCAR O ACTUALIZAR
    public Producto(int id, String marca, String productoNombre, double precio, int stock, int vendido) {
        this.id = id;
        this.marca = marca;
        this.productoNombre = productoNombre;
        this.precio = precio;
        this.stock = stock;
        this.vendido = vendido;
    }

   
    //CONTRUCTOR PARA AGREGAR DATOS A LA BASE DE DATOS 
    public Producto(String marca, String productoNombre, double precio, int stock, int vendido) {
        this.marca = marca;
        this.productoNombre = productoNombre;
        this.precio = precio;
        this.stock = stock;
        this.vendido = vendido;
    }
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
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

    public int getVendido() {
        return vendido;
    }

    public void setVendido(int vendido) {
        this.vendido = vendido;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", marca=" + marca + ", productoNombre=" + productoNombre + ", precio=" + precio + ", stock=" + stock + ", vendido=" + vendido + '}';
    }

    
    
    
    
    
    
    
}
