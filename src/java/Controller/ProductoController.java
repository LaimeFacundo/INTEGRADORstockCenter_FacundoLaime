/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller;

import Dao.ProductoDAO;
import Dao.ProductoDAOimpl;
import Model.Producto;
import Util.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
@WebServlet(name = "ProductoController", urlPatterns = {"/ProductoController"})
public class ProductoController extends HttpServlet {

ProductoDAO productoDao = new ProductoDAOimpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   
        
        
        String accion = request.getParameter("accion");
        
        if(accion == null || accion.isEmpty()){
                //ir a la lista
                listarProducto(request,response);
            }else{
            
            switch(accion){
                
                case "nuevo": 
                    nuevoProducto(request, response);
                    
                    break;
                    
                    case "actualizar": 
                    actualizarProducto(request, response);
                    
                    break;
                    case "eliminar": 
                    eliminarProducto(request, response);
                    
                    break;
                    
                    
                    
                    
                default: 
                    throw new AssertionError();
                
            }
            
        }
  
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        Producto producto = null; 
        String id = request.getParameter("id");
        String marca = request.getParameter("marca");
        String productoNombre = request.getParameter("productoNombre");
        double precio = Double.parseDouble(request.getParameter("precio"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        int vendido = Integer.parseInt(request.getParameter("vendido"));
        
        
        if(id == null || id.isEmpty() ){
                //insert
                producto = new Producto( marca , productoNombre , precio , stock , vendido );
                System.out.println(producto);
                productoDao.save(producto);
                listarProducto(request,response);
                
            }else{
            producto = new Producto(Integer.parseInt(id), marca , productoNombre, precio, stock , vendido);
            productoDao.update(producto);
            listarProducto(request, response);

        }
        
        
        
    }
    
    
    
    
//.......................................................................................................................
    
    
    
    
    private void listarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Producto> list = new ArrayList<>();
        list = productoDao.getAll();
        System.out.println(list);
        request.setAttribute("list", list);
      request.getRequestDispatcher("list.jsp").forward(request , response);
    }

    private void nuevoProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("formulario.jsp");
    }

    private void actualizarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Producto producto;
        int id = Integer.parseInt(request.getParameter("id"));
        producto = productoDao.getById(id);
        request.setAttribute("producto", producto);
                request.getRequestDispatcher("formulario.jsp").forward(request, response);

        
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                Producto producto;

        int id = Integer.parseInt(request.getParameter("id"));
        productoDao.delete(id);
        listarProducto(request , response);
        
        
                        request.getRequestDispatcher("formulario.jsp").forward(request, response);

    }
    

 
}
 