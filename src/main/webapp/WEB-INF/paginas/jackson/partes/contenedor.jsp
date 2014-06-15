<%@include file="/WEB-INF/paginas/core/cabecera.jsp"%>
<div ng-controller="jacksonCtrl"
	class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
	<h1 class="page-header"><spring:message code="jackson.cabecera"/></h1>
	<div class="row placeholders"></div>
	<h2 class="sub-header"><spring:message code="jackson.subcabecera"/></h2>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th class="col-md-2"><spring:message code="jackson.campo.enlace"/></th>
					<th class="col-md-10"><spring:message code="jackson.campo.descripcion"/></th>
				</tr>
			</thead>
			<tr ng-repeat="enlace in enlaces">
				<td><a class="btn btn-default" href="{{enlace.url}}"
					target="_black" role="button">{{enlace.texto}}</a></td>
				<td>{{enlace.descripcion}}</td>
			</tr>
		</table>
		<button class="btn btn-default" ng-click="abrir('lg')"><spring:message code="jackson.boton.formulariomodal"/></button>
	</div>
</div>