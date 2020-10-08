<%@page import="java.util.ArrayList"%>
<%@page import="com.hospital.mysql.VerificarHorariosMedico"%>
<%@page import="com.hospital.objetos.Medico"%>
<%@page import="com.hospital.mysql.NuevoMedicoMysql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="//stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="../css/EstlosRegistro.css" rel="stylesheet">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css">

        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>
        <script src="//ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.min.js"></script>
        <script src="//stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

        <style>
            .oculta{
                display: none;
            }
            .resaltar{
                background-color: red;
            }
        </style>


        <meta charset="UTF-8">
        <title>Nueva consukta</title>
    </head>
    <body>
        <div class="container justify-content-center">
            <div id="logbox">
                <%@page import="com.hospital.controlador.ServletNuevaConsulta"%>
                <form id="signup" method="post" action="../ServletNuevaConsulta">
                    <h1 >Agendar Cita</h1>
                    <p style="margin-left: 40px" class="d-inline">Fecha para la cita:</p> 
                    <div class='input-group date' id='datetimepicker1' style="width: 245px; margin-left: 37px">
                        <input type='text' class="form-control" name="fecha"/>
                        <span class="input-group-addon"></span>
                    </div>
                    <br>
                    <a class="btn btn-warning font-weight-bold collapsed" style="margin-left: 40px" data-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Mostrar Medicos</a>
                    <div  style="margin: 20px" class="collapse multi-collapse" id="multiCollapseExample1">
                        <input type="text" name="busquedaNombre" placeholder="Busqueda Por Nombre" id="nombre" class="form-control"/>
                        <table cellspacing="4" cellpadding="5" border="1" id="tabla" class="table table-bordered input_pass">
                            <thead>
                                <tr class="bg-secondary text-white font-weight-bold">
                                    <td align="center">Nombre</td>
                                    <td align="center">Colegiado</td>
                                    <td align="center">Correo</td>
                                    <td align="center">Hora entrada</td>
                                    <td align="center">Hora salida</td>
                                    <td align="center">Especialidad</td>
                                </tr>

                            </thead>
                            <tbody>
                                <%
                                    NuevoMedicoMysql medicoMysql = new NuevoMedicoMysql();
                                    Medico medico;
                                    String NombreEsp;
                                     ArrayList<Medico> arrayMedicos = medicoMysql.getMedicos();
                                    for (int i = 0; i < arrayMedicos.size(); i++) {
                                        medico = arrayMedicos.get(i);
                                %>
                                <tr class="bg-warning">
                                    <td align="center"><%=medico.getNombre()%>,<p><%=medico.getCodigo()%></p></td>
                                    <td align="center"><%=medico.getColegiado()%></td>
                                    <td align="center"><%=medico.getCorreo()%></td>
                                    <td align="center"><%=medico.getHoraEntrada()%></td>
                                    <td align="center"><%=medico.getHoraSalida()%></td>
                                    <td class="text-center">
                                        <a class="btn btn-info collapsed" style="margin-left: 40px" data-toggle="collapse" href="#<%=medico.getCodigo()%>" role="button" aria-expanded="false" aria-controls="horas">Seleccionar Medico</a>                                    
                                        <div  style="margin: 20px" class="collapse multi-collapse" id="<%=medico.getCodigo()%>">
                                            <table cellspacing="4" cellpadding="5" border="1" id="tabla" class="table table-bordered input_pass">
                                                <thead>
                                                    <tr class="bg-secondary text-white">
                                                        <td align="center">Horario Ocupado:</td>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                </tbody>
                                            </table>
                                        </div>
                                    </td>
                                </tr>
                                <% }%>
                            <tbody>    
                        </table>
                    </div>
                    <br><br>
                    <p style="margin-left: 40px" class="d-inline">Hora para la cita:</p> 
                    <input name="hora" type="text" pattern="[0-9]{1,2}" placeholder="Escriba solo la hora EJ: 5, 7, 9" title="Escriba solo numeros" required="required" class="input pass"/>
                    <input id="registrar" type="submit" value="Registrar" class="inputButton"/>
                    <input name="CodMedico" type="text" id="CodMedico" class="invisible"></input>
                    <input name="CodEsp" type="text" id="CodEsp" class="invisible"></input>
                </form>
            </div>
        </div>

        <script>
            $('.table tbody').on('click', '.btn', function () {
                var currow = $(this).closest('tr');
                var medico = currow.find('td:eq(0)').text();
                var esp = currow.find('td:eq(5)').text();
                var codMedico = medico.split(",");
                var codEsp = esp.split(",");
                document.getElementById('CodMedico').value = codMedico[1];
                document.getElementById('CodEsp').value = codEsp[1];
            });
        </script>
        <script>
            $(document).ready(function () {
                var contenido_fila;
                var coincidencias;
                var exp;
                $('#nombre').keyup(function () {
                    if ($(this).val().length >= 1)
                        filtrar($(this).val());
                    else
                        mostrar();
                });

                function filtrar(cadena) {
                    $('#tabla tbody tr').each(function () {
                        $(this).removeClass('oculta');
                        contenido_fila = $(this).find('td:eq(0)').html();
                        exp = new RegExp(cadena, 'gi');                             //Se obtiene una expresion regular para verificar coicidencias 
                        coincidencias = contenido_fila.match(exp);                  //almacena los array encontrados
                        if (coincidencias !== null) {
                            $(this).addClass('resaltar');
                        } else {
                            $(this).addClass('oculta');
                        }
                    });
                }

                //Muestra las fils de la tabla si no hay busqueda
                function mostrar() {
                    $('#tabla tr').each(function () {
                        $(this).removeClass('oculta');
                    });
                }

            });
        </script>
        <script>
            $(document).ready(function () {
                $('#datetimepicker1').datepicker({
                    format: 'yyyy/mm/dd'
                });
            });
        </script>
    </body>
</html>
