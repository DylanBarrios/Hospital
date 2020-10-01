package com.hospital.controlador;

import com.hospital.objetos.Medico;
import com.hospital.mysql.NuevoMedicoMysql;
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

@WebServlet(name = "ServletNuevoMedico", urlPatterns = {"/ServletNuevoMedico"})
public class ServletNuevoMedico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Servlet nuevo at " + request.getContextPath() + "</h1>");
            String codigo = nuevoCodigo.getCodigo();
            String nombre = request.getParameter("nombre");
            String dpi = request.getParameter("dpi");
            String telefono = request.getParameter("telefono");
            String colegiado = request.getParameter("colegiado");
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            String especialidad = request.getParameter("especialidad");
            String horaInicio = request.getParameter("horaInicio");
            String horaSalida = request.getParameter("horaSalida");
            Date inicioTrabajo = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("inicioTrabajo"));
            
            Medico medico = new Medico(nombre, dpi, codigo, password, telefono, colegiado, correo, horaInicio, horaSalida, especialidad, inicioTrabajo);
            NuevoMedicoMysql medicoMysql = new NuevoMedicoMysql();
            if(medicoMysql.addMedico(medico)){
                response.sendRedirect("jsp/PaginaPrincipal.jsp");
            }else
                response.sendRedirect("jsp/NuevoMedico.jsp");
            

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
            Logger.getLogger(ServletNuevoMedico.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletNuevoMedico.class.getName()).log(Level.SEVERE, null, ex);
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
