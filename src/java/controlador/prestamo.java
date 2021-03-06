/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cuota;
import modelo.Prestamo;
import modelo.Utilidades;

/**
 *
 * @author DAW212
 */
@WebServlet(name = "prestamo", urlPatterns = {"/prestamo"})
public class prestamo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        ArrayList<String> meses = Utilidades.getMeses();
        request.setAttribute("meses", meses);
        request.getRequestDispatcher("prestamo.jsp").forward(request, response);
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
        
        String nombre = request.getParameter("nombre");
        String cantidad = request.getParameter("cantidad");
        String interes = request.getParameter("interes");
        String tiempo = request.getParameter("tiempo");
        
        double cantParse, inteParse;
        int tiemParse = Integer.parseInt(tiempo);
        
        if(!cantidad.equals("")){
            cantParse = Double.parseDouble(cantidad);
        } 
        else {
            cantParse = 0;
        }
        
        if(!interes.equals("")) {
            inteParse = Double.parseDouble(interes);
        } 
        else {
            inteParse = 0;
        }
        
        Prestamo prestamo = new Prestamo(cantParse, inteParse, tiemParse);
        ArrayList <String> meses = Utilidades.getMeses();
        
        request.setAttribute("meses", meses);
        request.setAttribute("nombre", nombre);
        request.setAttribute("cantidad", nombre);
        request.setAttribute("totpres", prestamo);
       
        ArrayList<Cuota> cuotas = Utilidades.listCuotas(tiemParse, prestamo.getImportePrestamo());
        request.setAttribute("cuotas", cuotas);
        
        request.getRequestDispatcher("prestamo.jsp").forward(request, response);
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
