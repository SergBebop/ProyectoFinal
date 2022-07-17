<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="Discos">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Discos</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Autor</th>
                                <th>Canciones</th>
                                <th>Precio</th>
                                <th>Stock</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="disco" items="${pepe}" varStatus="status">
                                <tr>
                                    <td>${disco.idDiscos}</td>
                                    <td>${disco.nombre}</td>
                                    <td>${disco.autor}</td>
                                    <td>${disco.canciones}</td>
                                    <td><fmt:formatNumber value="${disco.precio}" type="currency"/></td>
                                    <td>${disco.stock}</td>
                                    <!-- COMPLETAR HREF CUANDO ESTE TERMINADO JSP EDITAR -->
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idDiscos=${disco.idDiscos}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de Discos</h3>
                        <h4 class="display-4">
                            ${cantidadDiscos}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Precio Total de Discos</h3>
                        <h4 class="display-4">
                            <fmt:formatNumber value="${precioTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/operaciones/agregarDiscos.jsp"/>