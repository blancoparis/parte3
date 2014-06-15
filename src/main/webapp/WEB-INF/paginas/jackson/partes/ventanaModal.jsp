<%@include file="/WEB-INF/paginas/core/cabecera.jsp"%>

<div class="modal-header">
	<h3 class="modal-title"><spring:message code="jackson.modal.titulo" /></h3>
</div>
<div class="modal-body" >
	<div role="form" class="form-horizontal">
		<div class="form-group">
			<label for="id" class="col-sm-2 control-label"><spring:message code="jackson.modal.id" /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="id" placeholder="El id"  ng-model="ficha.id"/>
			</div>
		</div>
		<div class="form-group">
			<label for="descripcion" class="col-sm-2 control-label"><spring:message code="jackson.modal.descripcion" /></label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="descripcion" placeholder="Descripcion" ng-model="ficha.descripcion"/>
			</div>
		</div>
	</div>
</div>
<div class="modal-footer">
	<button class="btn btn-primary" ng-click="ok()"><spring:message code="jackson.modal.ok" /></button>
	<button class="btn btn-warning" ng-click="cancelar()"><spring:message code="jackson.modal.cancelar" /></button>
</div>
