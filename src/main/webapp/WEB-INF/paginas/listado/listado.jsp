<%@include file="/WEB-INF/paginas/core/cabecera.jsp"%>
<html ng-app="listadoApp">
<head>
	<title>Listado</title>
	<jsp:include page="/WEB-INF/paginas/core/head.jsp"></jsp:include>
	<script type="text/javascript"	src="${contexto}recursos/aplicacion/js/listado/app.js"></script>
</head>

<body>
	<jsp:include page="/core/cabecera.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row">
			<jsp:include page="/core/menu.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/paginas/listado/partes/contenedor.jsp"></jsp:include>			
		</div>
	</div>
</body>
</html>