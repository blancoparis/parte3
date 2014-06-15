<%@include file="/WEB-INF/paginas/core/cabecera.jsp"%>
<div class="col-sm-3 col-md-2 sidebar" >
			<ul class="nav nav-sidebar" ng-controller="menuCtrl">
				<li ng-class="{active:opcion.activo}" ng-repeat="opcion in menu.opciones"> <a href="{{opcion.url}}">{{opcion.opcion}}</a> </li>
			</ul>
</div>