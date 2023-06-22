<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Menu</title>
</head>
<body>
<div class="container">
    <h1 class="encabezado">Menú Principal</h1>
</div>
<br/>
<div class="container">
    <form action="agregarInmueble" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Inmueble" class="boton">
        </div>
    </form>
    <br/>
    <form action="agregarVendedor" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Vendedor" class="boton">
        </div>
    </form>
    <br/>
    <form action="buscarInmueble" method="get">
        <div class="centrado">
            <input type="submit" value="Buscar Inmueble" class="boton">
        </div>
    </form>
</div>
</body>
</html>