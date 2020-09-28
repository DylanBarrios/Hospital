<%@page import="com.hospital.objetos.Examen"%>
<%@page import="com.hospital.mysql.NuevoExamenMysql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="//stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="../css/EstlosRegistro.css" rel="stylesheet">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

        <meta charset="UTF-8">
        <title>Agregar Laboratorista</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <div class="container justify-content-center">
            <div id="logbox">
                <%@page import="com.hospital.controlador.ServletNuevoLaboratoristas"%>
                <form id="signup" method="post" action="../ServletNuevoLaboratoristas">
                    <h1 >Agregar Laboratorista</h1>
                    <input name="nombre" type="text" placeholder="Nombres y apellidos" pattern="[a-zA-Z ]{2,48}" title="El nombre solo puede tener letras minusculas y mayusculas" autofocus="autofocus" required="required" class="input pass"/>
                    <input name="dpi" type="text" pattern="[0-9]{13}" placeholder="DPI" title="Escriba los 13 digitos" required="required" class="input pass"/>
                    <input name="telefono" type="text" pattern="[0-9]{8,12}" placeholder="Numero telefonico" title="Escriba solo numeros" required="required" class="input pass"/>
                    <input name="registro" type="text" pattern="[0-9 -]{2,20}" placeholder="Registro ante el Ministerio de Salud." required="required" class="input pass"/>
                    <input name="correo" type="email" placeholder="Correo electronico" class="input pass" required="required"/>
                    <input name="inicioTrabajo" type='text' id="fecha" class="input pass" placeholder="Fecha en la que inicia" required="required"/>    
                    <input name="password" type="password" placeholder="Contraseña" class="input pass" required="required"> 

                    <div  style="width: 240px; margin-left: 40px">
                        <p style="color: black"><b>Examen que realiza:</b><p>
                        <select class="custom-select" name="examenes">
                            <%
                                NuevoExamenMysql exMysql = new NuevoExamenMysql();
                                Examen examen;
                                String codigo;
                                for (int i = 0; i < exMysql.getExamenes().size(); i++) {
                                    examen = exMysql.getExamenes().get(i);
                                    codigo = examen.getCodigo();
                            %>
                            <option value=<%=codigo%>>
                                <%=examen.getNombre()%></p>
                            </option>
                            <% }%>
                        </select>
                    </div>

                    <input id="registrar" type="submit" value="Registrar" class="inputButton"/>

                </form>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>
