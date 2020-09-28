<%@page import="com.hospital.objetos.Especialidad"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hospital.mysql.NuevaEspecialidadMysql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!Doctype html>
<html>
    <head>
        <link rel="stylesheet" href="//stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="../css/EstlosRegistro.css" rel="stylesheet">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
        
        <meta charset="UTF-8">
        <title>Registration Form</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container justify-content-center">
            <div id="logbox">
                <%@page import="com.hospital.controlador.ServletNuevoMedico"%>
                <form id="signup" method="post" action="../ServletNuevoMedico">
                    <h1 >Agregar Medico</h1>
                    <input name="nombre" type="text" placeholder="Nombres y apellidos" pattern="[a-zA-Z ]{2,48}" title="El nombre solo puede tener letras minusculas y mayusculas" autofocus="autofocus" required="required" class="input pass"/>
                    <input name="dpi" type="text" pattern="[0-9]{13}" placeholder="DPI" title="Escriba los 13 digitos" required="required" class="input pass"/>
                    <input name="telefono" type="text" pattern="[0-9]{8,12}" placeholder="Numero telefonico" title="Escriba solo numeros" required="required" class="input pass"/>
                    <input name="colegiado" type="text" pattern="[0-9 -]{2,20}" placeholder="Colegiado" required="required" class="input pass"/>
                    <input name="correo" type="email" placeholder="Correo electronico" class="input pass" required="required"/>
                    <input name="inicioTrabajo" type='text' id="fecha" class="input pass" placeholder="Fecha en la que inicia" required="required"/>    
                    <input name="password" type="password" placeholder="Contraseña" class="input pass" required="required"> 

                    <div  style="width: 240px; margin-left: 40px">
                        <select class="custom-select" name="especialidad">
                            <option value="especialidad">Especialidades</option>
                            <%
                                NuevaEspecialidadMysql espMysql = new NuevaEspecialidadMysql();
                                Especialidad especialidad;
                                String codigo;
                                for (int i = 0; i < espMysql.getEspecialidades().size(); i++) {
                                    especialidad = espMysql.getEspecialidades().get(i);
                                    codigo = especialidad.getCodigo();
                            %>
                            <option value=<%=codigo%>>
                                <%=especialidad.getNombre()%></p>
                            </option>
                            <% }%>
                        </select>
                    </div>

                    <p style="margin-left: 40px" class="d-inline">Hora de entrada:</p> <input type="time" name="horaInicio" class="input pass">
                    <p style="margin-left: 40px" class="d-inline">Hora de salida:</p> <input type="time" name="horaSalida"  class="input pass">
                    <input id="registrar" type="submit" value="Registrar" class="inputButton"/>

                    <div id="mensaje" class="alert alert-success">
                        <a href="#" class="close" data-dismiss="alert">&times;</a>
                        Registrado
                    </div>    
                </form>
            </div>
            <div  class="mx-auto" style="width: 200px;">
                <a class="btn btn-warning font-weight-bold collapsed" style="margin-top: 60px" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Crear Nueva Especializacion</a>
                <div class="collapse multi-collapse" id="multiCollapseExample1">
                    <%@page import="com.hospital.controlador.ServletNuevaEsp" %>
                    <form action="../ServletNuevaEsp" method="post">
                        <br>
                        <input name="nombre" type="text" placeholder="Nombre" pattern="[a-zA-Z ]{2,48}" title="El nombre solo puede tener letras minusculas y mayusculas" autofocus="autofocus" required="required" class="input pass"/>
                        <input name="costo" type="text" pattern="[0-9, .]{1,50}" placeholder="Costo" title="Solo escriba numeros" required="required" class="input pass"/>
                        <input type="submit" value="Registrar" class="inputButton"/>
                    </form>
                </div>
            </div>
        </div>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#registrar').click(function () {
                    $('#mensaje').show('fade');
                });
            });
        </script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>


    </body>		
</html>

