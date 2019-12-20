<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<c:url var="buildingAPI" value="/api-admin-building"/>
<c:url var="buildingURL" value="/admin-building"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="col"></div>
<div class="main-content-inner">
	<div class="card">
		<div class="card-header">
			<h5 class="title">add Building</h5>
		</div>
		<div class="card-body">
			<form id="edit-form">
				<div class="row">
					<div class="col-md-5 pr-1">
						<div class="form-group">
							<label>Tên tòa nhà</label> <input type="text"
								class="form-control" name="name" value="${buildingModel.name}"
								id="name">
						</div>
					</div>
					<div class="col-md-3 px-1">
						<div class="form-group">
							<label>Diện tích sàn</label> <input type="text"
								class="form-control d-inline" name="rentArea"
								value="${buildingModel.rentArea}" id="rentArea">
						</div>
					</div>
					<div class="col-sm-4 pl-1">
						<div class="form-group d-inline">
							<select class="custom-select">
								<option selected>Chọn Quận...</option>
								<c:forEach var="district" items="${districts}">
									<option name="ward" value="${district.key}"
										${district.key == buildingModel.district ? 'selected' : '' }>
										${district.value}</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6 pr-1">
						<div class="form-group d-inline">
							<label>Phường</label> <input type="text" class="form-control"
								name="ward" value="${buildingModel.ward}">
						</div>
					</div>
					<div class="col-md-6 pl-1">
						<div class="form-group">
							<label>Đường</label> <input type="text" class="form-control"
								name="street" value="${buildingModel.street}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Kết cấu</label> <input type="text" class="form-control"
								name="structure" value="${buildingModel.structure}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 pr-1">
						<div class="form-group">
							<label>Số tầng hầm</label> <input type="text"
								class="form-control" name="numberOfBasement"
								value="${buildingModel.numberOfBasement}">
						</div>
					</div>
					<div class="col-md-4 pl-1">
						<div class="form-group">
							<label>Giá thuê</label> <input type="text" class="form-control"
								name="costRent" value="${buildingModel.costRent}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 pr-1">
						<div class="form-group">
							<label>Giá dịch vụ</label> <input type="text"
								class="form-control" name="serviceCost"
								value="${buildingModel.serviceCost}">
						</div>
					</div>
					<div class="col-md-4 px-1">
						<div class="form-group">
							<label>Giá giữ ô tô</label> <input type="text"
								class="form-control" name="carCost"
								value="${buildingModel.buildingArea}">
						</div>
					</div>
					<div class="col-md-4 pl-1">
						<div class="form-group">
							<label>Giá giữ xe máy</label> <input type="text"
								class="form-control" name="motobikeCost"
								value="${buildingModel.motobikeCost}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 pr-1">
						<div class="form-group">
							<label>Phí ngoài giờ</label> <input type="text"
								class="form-control" name="overtimeCost"
								value="${buildingModel.overtimeCost}">
						</div>
					</div>
					<div class="col-md-4 px-1">
						<div class="form-group">
							<label>Giá điện</label> <input type="text" class="form-control"
								name="electricityCost" value="${buildingModel.electricityCost}">
						</div>
					</div>
					<div class="col-md-4 pl-1">
						<div class="form-group">
							<label>Đặt cọc</label> <input type="text" class="form-control"
								name="deposit" value="${buildingModel.deposit}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 pr-1">
						<div class="form-group">
							<label>Thanh toán</label> <input type="text" class="form-control"
								name="payment" value="${buildingModel.payment}">
						</div>
					</div>
					<div class="col-md-4 px-1">
						<div class="form-group">
							<label>Thời gian thuê</label> <input type="text"
								class="form-control" name="timeRent"
								value="${buildingModel.timeRent}">
						</div>
					</div>
					<div class="col-md-4 pl-1">
						<div class="form-group">
							<label>Tên quản lý</label> <input type="text"
								class="form-control" name="managerName"
								value="${buildingModel.managerName}">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Loại Tòa Nhà</label>
							<div class="form-group form-check-inline float-right">

								<c:forEach var="buildingType" items="${buildingTypes}">
									<div class="custom-control custom-checkbox float-right">
										<input type="checkbox" class="custom-control-input"
											id="${buildingType.key}" name="buildingTypes"
											value="${buildingType.key}"
											${fn:contains(fn:join(buildingModel.buildingTypes,','),buildingType.key)?'checked':''}>
										<label class="custom-control-label" for="${buildingType.key}">${buildingType.value}</label>
									</div>
								</c:forEach>

							</div>
						</div>
					</div>
				</div>
				<input type="hidden" name="id" value="${buildingModel.id}"
					id="buildingId" />
			</form>
			<c:if test="${empty buildingModel.id }">
				<button type="submit" class="btn btn-primary float-right"
					id="btn-add-or-update" name="action" value="ADD">ADD
					Building</button>
			</c:if>

			<c:if test="${not empty buildingModel.id }">
				<button type="submit" class="btn btn-primary float-right"
					id="btn-add-or-update" name="action" value="EDIT">Update
					Building</button>
			</c:if>

		</div>
	</div>
</div>
<script type="text/javascript">
	$('#btn-add-or-update').click(function() {

		var buildingId = $('#buildingId').val();

		var formData = $('#edit-form').serializeArray();

		var data = {};
		var buildingTypes = [];

		$.each(formData, function(index, val) {
			if (val.name === 'buildingTypes') {
				buildingTypes.push(val.value);
			} else {
				data[""+val.name+""] = val.value;
			}
		});

		data['buildingTypes'] = buildingTypes;

		if (buildingId === '') {
			addBuilding(data);
		} else {
			updateBuilding(data, buildingId);
		}

	});

	function addBuilding(data) {

		$.ajax({
			url : '${buildingAPI}',
			data : JSON.stringify(data),
			type : 'POST',
			contentType: 'application/json',
			dataType : 'json',
			error : function() {
				window.location.href="${buildingURL}?action=LIST&message=insert_success";
			},
			success : function(data) {
				window.location.href="${buildingURL}?action=EDIT&message=error_system/>";
			}
			
		});

	}

	function updateBuilding(data, buildingId) {

	}
</script>



















