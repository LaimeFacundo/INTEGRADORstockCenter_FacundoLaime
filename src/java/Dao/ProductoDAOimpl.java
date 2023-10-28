
package Dao;

import Model.Producto;
import Util.DBConnection;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class ProductoDAOimpl implements ProductoDAO {

    
    
    private String sql = "";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    
    
    
    
    @Override
    public int save(Producto producto) {
        int row = 0; 
        connection = DBConnection.getConnection();
        sql = "insert into integradorcersostock (marca, productoNombre,precio, stock, vendido) values(?, ?, ?, ?, ?)";
        
       // insert into integradorcersostock (marca, productoNombre,precio, stock, vendido) values('pepsi', 'gaseosa', 10.2, 60, 10);
        try{
            preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1, producto.getId());
            preparedStatement.setString(1, producto.getMarca());
            preparedStatement.setString(2, producto.getProductoNombre());
            preparedStatement.setDouble(3 , producto.getPrecio());
            preparedStatement.setInt(4 , producto.getStock());
            preparedStatement.setInt(5 , producto.getVendido());
            row = preparedStatement.executeUpdate();
            System.out.println(producto);
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;  
 
    }

    @Override
    public int update(Producto producto) {
        
        
                int row = 0; 
sql = "UPDATE integradorcersostock SET marca = ?, productoNombre = ?, precio = ?, stock = ?, vendido = ? WHERE id = ?";
        connection = DBConnection.getConnection();
        try{
            preparedStatement = connection.prepareStatement(sql);
         
            preparedStatement.setString(1, producto.getMarca());
            preparedStatement.setString(2, producto.getProductoNombre());
            preparedStatement.setDouble(3 , producto.getPrecio());
            preparedStatement.setInt(4 , producto.getStock());
            preparedStatement.setInt(5 , producto.getVendido());
            preparedStatement.setInt(6, producto.getId());
            
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;  
    }

    @Override
    public int delete(int idProducto) {
        
        int row = 0; 
        sql = "DELETE FROM integradorcersostock WHERE id = ?";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, idProducto);
            
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return row;
        

    }

    @Override
    public List<Producto> getAll() {
        List<Producto> list = new ArrayList();
        sql = "SELECT * FROM integradorcersostock";
        connection = DBConnection.getConnection();
        
        try {
            preparedStatement = connection.prepareStatement(sql);
                    resultSet =  preparedStatement.executeQuery();  
                    
       
                    
                    while (resultSet.next()){
                        
                        Producto producto = new Producto();
                        producto.setId(resultSet.getInt(1));
                        producto.setMarca(resultSet.getString(2));
                        producto.setProductoNombre(resultSet.getString(3));
                        producto.setPrecio(resultSet.getDouble(4));
                        producto.setStock(resultSet.getInt(5));
                        producto.setVendido(resultSet.getInt(6));
                        list.add(producto);
                        
                    }
                    preparedStatement.close();
                    connection.close();
                     

        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
        return list;
        
        
    }

    @Override
    public Producto getById(int idProducto) {
        
        Producto producto = null;
        sql = "SELECT * FROM integradorcersostock WHERE id = ? ";
        connection = DBConnection.getConnection();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1 , idProducto);
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next() ){
                        producto = new Producto();
                        producto.setId(resultSet.getInt(1));
                        producto.setMarca(resultSet.getString(2));
                        producto.setProductoNombre(resultSet.getString(3));
                        producto.setPrecio(resultSet.getDouble(4));
                        producto.setStock(resultSet.getInt(5));
                        producto.setVendido(resultSet.getInt(6));
                        
            }
            preparedStatement.close() ;
            connection.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return producto;
    } 
    
}
