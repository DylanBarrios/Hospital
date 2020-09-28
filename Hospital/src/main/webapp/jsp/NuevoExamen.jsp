<!doctype html>
<html lang="es">
    <head>
        <link rel="stylesheet" href="//stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <link href="../css/EstlosRegistro.css" rel="stylesheet">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Agregar Examen</title>
    </head>
    <body>

        <div class="container justify-content-center">
            <div class="col-md-6">
                <div id="logbox">
                    <%@page import="com.hospital.controlador.ServletNuevoExamenE" %>
                    <form id="signup" method="post" action="../ServletNuevoExamenE">
                        <h1>Registrarse</h1>
                        <input name="nombre" type="text" placeholder="Nombre del examen" pattern="[a-zA-Z, 0-9 ]{2,48}" title="Solo escriba letras y numeros" autofocus="autofocus" required="required" class="input pass"/>
                        <input name="costo" type='text' placeholder="Costo" class="input pass" pattern="[0-9.]{1,48}" title="Solo escriba numeros"  required="required"/>    
                        <textarea name="descripcion" class="input pass" placeholder="Descripcion del nuevo examen"></textarea>
                        <div style="margin-left: 40px;  border:  4px dashed white; width: 240px" >
                            <p style="text-align: center"><b>¿Se requiere orden medica?</b></p>
                            <input type="radio"  name="ordenMedica" value="si" style="margin-left: 80px" required="required">Si
                            <input type="radio" name="ordenMedica" value="no" style="margin-left: 10px">No
                        </div><br>
                        <div style="margin-left: 35px; border:  4px dashed white; width: 240px" >
                            <p style="text-align: center"><b>¿Que tipo de documento debe ser el informe?</b></p>
                            <input type="radio" name="informe" value="img" style="margin-left: 60px" required="required">Imagen
                            <input type="radio" name="informe" value="pdf" style="margin-left: 10px">PDF<br>
                        </div>
                        <input type="submit" value="Crear Nuevo Examen" class="inputButton"/>
                    </form>
                </div>
            </div>
        </div>


        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>