/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.controller;

import cl.beans.ServicioBeanLocal;
import cl.entities.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 25597723-7
 */
@WebServlet(name = "ControladorCarro", urlPatterns = {"/ControladorCarro"})
public class ControladorCarro extends HttpServlet {

    @EJB
    private ServicioBeanLocal servicio;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String boton2 = request.getParameter("boton2");
        switch (boton2) {
            case "addcar":
                addcar(request, response);
                break;
              case "deletecar":
                deletecar(request, response);
                break;   
             case "compra":
                compra(request, response);
                break;   
        }
    }
    
    private void compra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           
        request.setAttribute("msg", "Compra Efectuada");
           response.sendRedirect("compraefectuada.jsp");
       }
    
    private void deletecar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String idProducto = request.getParameter("idProducto");
        Producto p = servicio.buscarProducto(Integer.parseInt(idProducto));
        ArrayList<Producto> carro = (ArrayList) request.getSession().getAttribute("carro");
        
        carro.remove(p);
          request.getSession().setAttribute("carro", carro);
         response.sendRedirect("carrito.jsp");
                
    }
    
    
    private void addcar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idProducto = request.getParameter("idProducto");
        Producto p = servicio.buscarProducto(Integer.parseInt(idProducto));
        ArrayList<Producto> carro = (ArrayList) request.getSession().getAttribute("carro");
        if (carro == null) {
            carro = new ArrayList<>();
        }
        if (!carro.contains(p)) {
            carro.add(p);
            request.getSession().setAttribute("carro", carro);
        }        
        response.sendRedirect("miscompras.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
