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
            <div class="col-md-6">
                <div id="logbox">
                    <form id="signup" method="post" action="#">
                        <h1>Registrarse</h1>
                        <input name="nombre" type="text" placeholder="Nombres y apellidos" pattern="[a-zA-Z ]{2,48}" title="El nombre solo puede tener letras minusculas y mayusculas" autofocus="autofocus" required="required" class="input pass"/>
                        <input name="fechaNacimiento" type='text' id="fecha" class="input pass" placeholder="Fecha de nacimiento" required="required"/>    
                        <input name="DPI" type="text" pattern="[0-9]{13}" placeholder="DPI" title="Escriba los 13 digitos" required="required" class="input pass"/>
                        <input name="numero" type="text" pattern="[0-9]{8,12}" placeholder="Numero telefonico" title="Escriba solo numeros" required="required" class="input pass"/>
                        <input name="peso" type="text" pattern="[0-9]{1,4}" placeholder="Peso en kg" title="Escriba solo numeros" required="required" class="input pass"/>
                        <input name="sangre" type="text" pattern="[A,B,0,O,+,-]{2,3}" placeholder="Tipo de sangre. Ej: A+" title="Solo puede escribir A,B,0,+,-" required="required" class="input class">
                        <input name="correo" type="email" placeholder="Correo electronico" class="input pass" required="required"/>
                        <input name="password" type="password" placeholder="Contraseña" class="input pass" required="required"> 
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" style="margin-left: 40px" type="radio" name="sexo" value="masculino" required="required">
                            <label class="form-check-label">Masculino</label>
                            <input class="form-check-input" style="margin-left: 10px" type="radio" name="sexo" value="femenino" required="required">
                            <label class="form-check-label">Femenino</label>
                        </div>
                        <input type="submit" value="Registrarme" class="inputButton"/>
                        <div class="text-center">
                            already have an account? <a href="../index.jsp" id="login_id" class="text-light">Login</a>
                        </div>
                        <script>
                            $(document).ready(function () {
                                $('#fecha').datepicker();
                            });
                        </script>
                    </form>
                </div>
            </div>
        </div>
    </body>		
</html>

