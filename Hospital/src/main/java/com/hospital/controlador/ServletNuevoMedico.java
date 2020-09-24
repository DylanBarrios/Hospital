package com.hospital.controlador;

import com.hospital.medico.Medico;
import com.hospital.mysql.NuevoMedicoMysql;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            out.println("Putos");
            String codigo = nuevoCodigo();
            String nombre = request.getParameter("nombre");
            String dpi = request.getParameter("dpi");
            String telefono = request.getParameter("telefono");
            String colegiado = request.getParameter("colegiado");
            String correo = request.getParameter("correo");
            String password = request.getParameter("password");
            String especialidad = request.getParameter("especialidad");
            String horaInicio = request.getParameter("horaInicio");
            String horaSalida = request.getParameter("horaSalida");
            Date inicioTrabajo = new SimpleDateFormat("MM/dd/YYYY").parse(request.getParameter("inicioTrabajo"));
            
            Medico medico = new Medico(nombre, dpi, codigo, password, telefono, colegiado, correo, horaInicio, horaSalida, especialidad, inicioTrabajo);
            NuevoMedicoMysql medicoMysql = new NuevoMedicoMysql();
            if(medicoMysql.addMedico(medico)){
                response.sendRedirect("jsp/NuevoMedico.jsp");
            }
        }
    }

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
