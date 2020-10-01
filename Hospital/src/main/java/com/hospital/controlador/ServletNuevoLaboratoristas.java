package com.hospital.controlador;

import com.hospital.mysql.NuevoLaboratoristaMysql;
import com.hospital.objetos.Laboratorista;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletNuevoLaboratoristas", urlPatterns = {"/ServletNuevoLaboratoristas"})
public class ServletNuevoLaboratoristas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Servlet nuevo at " + request.getContextPath() + "</h1>");
            String codigo = nuevoCodigo.getCodigo();
            String nombre = request.getParameter("nombre");
            String dpi = request.getParameter("dpi");
            String telefono = request.getParameter("telefono");
            String registro = request.getParameter("registro");
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            String examen = request.getParameter("examenes");
            Date inicioTrabajo = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("inicioTrabajo"));

            Laboratorista lab = new Laboratorista(codigo, nombre, dpi, telefono, registro, correo, password, examen, inicioTrabajo);
            NuevoLaboratoristaMysql labMysql = new NuevoLaboratoristaMysql();
            if (labMysql.addLaboratorista(lab)) {
                response.sendRedirect("jsp/PaginaPrincipal.jsp");
            }else
                response.sendRedirect("jsp/NuevoLaboratorista.jsp");

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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletNuevoLaboratoristas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletNuevoLaboratoristas.class.getName()).log(Level.SEVERE, null, ex);
        }
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
