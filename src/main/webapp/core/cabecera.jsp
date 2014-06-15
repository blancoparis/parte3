<div class="navbar navbar-inverse navbar-fixed-top" role="navigation" >
	<div class="container-fluid" ng-controller="cabeceraCtrl">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">{{cabecera.titulo}} </a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="?locale=en">Ingles</a></li>
				<li><a href="?locale=es">Castellano</a></li>
				<li><a href="#">Inicio</a></li>
				<li><a href="#">Ayuda</a></li>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Buscar ...">
			</form>
		</div>
	</div>
</div>