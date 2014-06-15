	// Definir la aplicacion
	var app = angular.module('jacksonApp', [ 'inicio.controlador',
			'comun.controlador' ]);

	app.constant("configuracionPagina", {
		titulo : 'Inicio',
		id : 1
	});

	var appJacksonControlador = angular.module('inicio.controlador', []);
	appJacksonControlador.controller('inicioCtrl', [ '$scope', '$http',
			'configuracionGeneral', function($scope, $http, conf) {
				console.log('Inicialización de la pagina' + conf.ctx);
			} ]);