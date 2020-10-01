package com.hospital.controlador;

import com.hospital.mysql.NuevaConsultaMysql;
import com.hospital.mysql.VerificarUsuario;
import com.hospital.objetos.ConsultaMedica;
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
import javax.swing.JOptionPane;

@WebServlet(name = "ServletNuevaConsulta", urlPatterns = {"/ServletNuevaConsulta"})
public class ServletNuevaConsulta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Codigo = nuevoCodigo.getCodigo();
            String Paciente = VerificarUsuario.getCodigoUsuario();
            String Medico = request.getParameter("CodMedico");
            String Especialidad = request.getParameter("CodEsp");
            String Hora = request.getParameter("hora");
            Date fecha = new SimpleDateFormat("yyyy/MM/dd").parse(request.getParameter("fecha"));
            
            ConsultaMedica consulta = new ConsultaMedica(Codigo, Paciente, Medico, Especialidad, Hora, fecha);
            NuevaConsultaMysql consultaMysql = new NuevaConsultaMysql();
            if(consultaMysql.addConsulta(consulta)){
                response.sendRedirect("jsp/PaginaPaciente.jsp");
            }
            else{
                response.sendRedirect("jsp/PacienteNuevaConsulta.jsp");
            }
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(ServletNuevaConsulta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ServletNuevaConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
