	// Definir la aplicacion
	var app = angular.module('listadoApp', [ 'listado.controlador',
			'comun.controlador' ]);

	app.constant("configuracionPagina", {
		titulo : 'Listado',
		id : 3
	});

	var appListadoControlador = angular.module('listado.controlador', []);
	appListadoControlador.controller('listadoCtrl', [ '$scope', '$http',
			'configuracionGeneral', function($scope, $http, conf) {
				console.log('Inicialización de la pagina' + conf.ctx);
			} ]);