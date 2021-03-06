package com.hospital.controlador;

import com.hospital.objetos.Paciente;
import com.hospital.mysql.NuevoPacienteMysql;
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

@WebServlet(name = "ServletNuevoPaciente", urlPatterns = {"/ServletNuevoPaciente"})
public class ServletNuevoPaciente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Codigo = nuevoCodigo.getCodigo();
            String Nombre = request.getParameter("nombre");
            Date Nacimiento = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("fechaNacimiento").toString());
            String DPI = request.getParameter("DPI");
            String Telefono = request.getParameter("numero");
            Double Peso = Double.parseDouble(request.getParameter("peso"));
            String Sangre = request.getParameter("sangre");
            String Correo = request.getParameter("correo");
            String Password = request.getParameter("password");
            String Sexo = request.getParameter("sexo");

            Paciente paciente = new Paciente(Codigo, Nombre, Nacimiento, DPI, Telefono, Peso, Sangre, Correo, Sexo, Password);
            NuevoPacienteMysql pacienteMysql = new NuevoPacienteMysql();
            if (pacienteMysql.addPaciente(paciente)) {
                response.sendRedirect("index.jsp");
            }else
                response.sendRedirect("jsp/NuevoPaciente.jsp");
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
            Logger.getLogger(ServletNuevoPaciente.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletNuevoPaciente.class.getName()).log(Level.SEVERE, null, ex);
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
