<%@include file="/WEB-INF/paginas/core/cabecera.jsp"%>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
	<div class="container-fluid" ng-controller="cabeceraCtrl">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				
				<span class="sr-only"><spring:message code="cabecera.sr.navegacion"/></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">{{cabecera.titulo}} </a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="?locale=en"><spring:message code="cabecera.idioma.ingles"/></a></li>
				<li><a href="?locale=es"><spring:message code="cabecera.idioma.castellano"/></a></li>
				<li><a href="#"><spring:message code="cabecera.inicio"/></a></li>
				<li><a href="#"><spring:message code="cabecera.ayuda"/></a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="<spring:message code="cabecera.placeholder.buscar"/>">
			</form>
		</div>
	</div>
</div>