<!DOCTYPE html>
<html>

    <head>
        <title>My Awesome Login Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="css/EstiloLogin.css">
        <script src="https://kit.fontawesome.com/44728a8b2d.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container h-100 justify-content-center">
            <div class="d-flex justify-content-center h-100">
                <div class="user_card">
                    <div class="d-flex justify-content-center">
                        <div class="brand_logo_container">
                            <img src="imagenes/login.jpg" class="brand_logo" alt="Logo">
                        </div>
                    </div>
                    <div class="d-flex justify-content-center form_container">
                        <%@page import="Controlador.ServletLog" %>
                        <form action="ServletLog" method="post">
                            <div class="input-group mb-3">
                                <div class="input-group-append">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" name="DPI" class="form-control input_user" placeholder="DPI" required="required">
                            </div>
                            <div class="input-group mb-2">
                                <div class="input-group-append">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" name="password" class="form-control input_pass" value="" placeholder="Contraseña" required=""required>
                            </div>
                            <div>
                                <select class="custom-select" name="rol">
                                    <option value="Paciente">Paciente</option>
                                    <option value="Medico">Medico</option>
                                    <option value="Administrador">Administrador</option>
                                </select>
                            </div>

                            <div class="d-flex justify-content-center mt-3 login_container">
                                <button type="submit" name="ingresar" class="btn login_btn">Ingresar!</button>
                            </div>
                        </form>
                    </div>

                    <div class="mt-4">
                        <div class="d-flex justify-content-center links">
                            No tienes una cuenta? <a href="jsp/registro.jsp" class="ml-2 text-light">Registrarse</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
