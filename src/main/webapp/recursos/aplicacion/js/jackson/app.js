	// Definir la aplicacion
	var app = angular.module('jacksonApp', [ 'jackson.controlador',
			'comun.controlador','ui.bootstrap' ]);

	app.constant("configuracionPagina", {
		titulo : 'jackson',
		id : 2
	});
	/**
	 * Controlador que se va a encargar de gestionar la ventana modal.
	 */
	var ModalInstanceCtrl = function ($scope,$http, $modalInstance,configuracionGeneral, ficha) {
		  $scope.ficha=ficha;
		  $scope.ok = function () {
		    var url=configuracionGeneral.ctx+'jackson/sumar/1';
			$http.post(url,$scope.ficha)
			.success(function (response){
				$scope.ficha=response;
			    $modalInstance.close($scope.ficha);
			});
		  };

		  $scope.cancelar = function () {
		    $modalInstance.dismiss('cancelar');
		  };
		};
	
	var appJacksonControlador = angular.module('jackson.controlador', []);
	appJacksonControlador.controller('jacksonCtrl', [ '$scope', '$http',
			'configuracionGeneral','$modal','$log', function($scope, $http, conf,$modal,$log) {
				console.log('Inicialización de la pagina' + conf.ctx);
				$scope.enlaces = [ {
					url : conf.ctx + 'jackson/json',
					texto : 'Json',
					descripcion : 'Recuperar un json.'
				}, {
					url : conf.ctx + 'jackson/xml',
					texto : 'XML',
					descripcion : 'Recuperar un xml.'
				} ];
				
				 $scope.ficha ={
					id:1
					,descripcion:'2'
				 };
				 $scope.abrir = function (size) {
				    var instanciaModal = $modal.open({
				      templateUrl: conf.ctx+'jackson/ventanaModal',
				      controller: ModalInstanceCtrl,
				      size: size,
				      resolve: {
				    	  ficha: function () {
				          return $scope.ficha;
				        }
				      }
				    });
				    instanciaModal.result.then(function (selectedItem) {
				      $scope.ficha=selectedItem;
				      $log.info('ok');
				    }, function (selectedItem) {
				      $log.info(selectedItem);
				    });
				  };
				  
			} ]);
	
	

	