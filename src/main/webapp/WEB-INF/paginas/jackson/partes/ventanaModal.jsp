<%@include file="/WEB-INF/paginas/core/cabecera.jsp"%>

<div class="modal-header">
	<h3 class="modal-title">Formulario de envio</h3>
</div>
<div class="modal-body" >
	<div role="form" class="form-horizontal">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label">Id</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="id" placeholder="El id"  ng-model="ficha.id"/>
			</div>
		</div>
		<div class="form-group">
			<label for="descripcion" class="col-sm-2 control-label">Descripcion</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="descripcion" placeholder="Descripcion" ng-model="ficha.descripcion"/>
			</div>
		</div>
	</div>
</div>
<div class="modal-footer">
	<button class="btn btn-primary" ng-click="ok()">OK</button>
	<button class="btn btn-warning" ng-click="cancelar()">Cancel</button>
</div>
