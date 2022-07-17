<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discografia</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/382381b436.js" crossorigin="anonymous"></script>
    </head>
    <body>

        <jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"/>

        <form action = "${pageContext.request.contextPath}/servletControlador?accion=modificar&idDiscos=${disco.idDiscos}" method="POST" class="was-validated">
            <jsp:include page="/WEB-INF/paginas/comunes/editarNav.jsp"/>

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div clas="card">
                                <div class="card-header">
                                    <h4>Editar Disco</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Titulo</label>
                                        <input type="text" class="form-control" name="nombre" required="" value="${disco.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="autor">Autor</label>
                                        <input type="text" class="form-control" name="autor" value="${disco.autor}">
                                    </div>
                                    <div class="form-group">
                                        <label for="canciones">Canciones</label>
                                        <input type="number" class="form-control" name="canciones" required="" value="${disco.canciones}">
                                    </div>
                                    <div class="form-group">
                                        <label for="precio">Precio de Disco</label>
                                        <input type="currency" class="form-control" name="precio" required="" value="${disco.precio}">
                                    </div>
                                    <div class="form-group">
                                        <label for="stock">Stock</label>
                                        <input type="number" class="form-control" name="stock" required="" value="${disco.stock}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>


        <jsp:include page="/WEB-INF/paginas/comunes/pieDePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
