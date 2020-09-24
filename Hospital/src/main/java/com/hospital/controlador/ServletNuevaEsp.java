package com.hospital.controlador;

import com.hospital.medico.Especialidad;
import com.hospital.mysql.NuevaEspecialidadMysql;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletNuevaEsp", urlPatterns = {"/ServletNuevaEsp"})
public class ServletNuevaEsp extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String cod = nuevoCodigo();
            String nombre = request.getParameter("nombre");
            double costo = Double.parseDouble(request.getParameter("costo"));

            Especialidad esp = new Especialidad(cod, nombre, costo);
            NuevaEspecialidadMysql espMysql = new NuevaEspecialidadMysql();
            if(espMysql.addEspecialidad(esp)){
                out.print("registrado");
                response.sendRedirect("jsp/NuevoMedico.jsp");
            }
        }
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

    public String nuevoCodigo() {
        String codigo = "";
        int valorDado = 0;
        String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (int i = 0; i < 4; i++) {
            valorDado = (int) Math.floor(Math.random() * letras.length);
            codigo += letras[valorDado];
        }
        codigo += "-";
        for (int i = 0; i < 4; i++) {
            valorDado = (int) Math.floor(Math.random() * 9);
            codigo += valorDado;
        }

        return codigo;
    }

}
