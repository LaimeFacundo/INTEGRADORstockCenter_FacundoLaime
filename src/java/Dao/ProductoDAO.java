
package Dao;

import Model.Producto;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface ProductoDAO {
    
    //GUARDAR PRODUCTO
    int save (Producto producto);
    
    //EDITAR PRODUCTO
    int update (Producto producto);
    
    //ELIMINAR PRODUCTO
    int delete (int idProducto);
    
    //OBTENER LISTA DE PRODUCTOS
    List<Producto> getAll(); 
    
    //OBTENER PRODUCTO POR ID
    Producto getById(int idProducto);
}
