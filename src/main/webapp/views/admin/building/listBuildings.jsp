<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="buildingURL" value="/admin-building"/>
<c:url var="buildingAPI" value="/api-admin-building"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Page Content -->
<div class="row">
<div class="pos-f-t">
  <div class="collapse" id="navbarToggleExternalContent">
    <div class="bg-dark p-4">
     <!--  <h5 class="text-white h4">List Buildings</h5> -->
      <span class="text-muted"><a href="<c:url value="/admin-building?action=EDIT" />"><button type="button"
					class="btn btn-success">Add Building</button></a>
		</span>
		<span class="text-muted">
			<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#collapseExample"
						aria-expanded="false" aria-controls="collapseExample">
						Search
					</button>
		</span>
    </div>
  </div>
  <nav class="navbar navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
  </nav>
</div>
			
			
			
	<ul class="nav">
		<li class="nav-item">
			<div class="col-sm">
				<div class="collapse" id="collapseExample">

						<form action="/jdbc-basic-advance/admin-building?action=LIST" method="GET">
							<div class="col-xl">
								<div class="col-md-5 pr-1">
									<div class="form-group">
										<label>Tên tòa nhà</label> <input type="text" class="form-control" name="name">
									</div>
								</div>
								<div class="col-md-8 pr-1">
									<div class="input-group mb">
										<div class="input-group-prepend">
											<label class="input-group-text" for="quan">Options</label>
										</div>
										<select class="custom-select">
											<option selected>Chọn Quận...</option>
											<c:forEach var="district" items="${districts}">
												<option name="ward" value="${district.key}"> ${district.value}</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-sm">
								<div class="col-md-6 pl-1">
									<div class="form-group">
										<label>Đường</label> <input type="text" class="form-control" name="street">
									</div>
								</div>
							</div>
							<div class="col-md-4 pr-1">
								<div class="form-group">
									<label>Giá Thuê Từ</label> <input type="text" class="form-control"
										name="costRentFrom">
								</div>
							</div>
							<div class="col-md-4 px-1">
								<div class="form-group">
									<label>Giá Thuê Đến</label> <input type="text" class="form-control"
										name="costRentTo">
								</div>
							</div>
							<div class="col-md-4 pl-1">
								<div class="form-group">
									<label>Diện Tích Từ</label> <input type="text" class="form-control"
										name="rentAreaFrom">
								</div>
							</div>
							<div class="col-md-4 pr-1">
								<div class="form-group">
									<label>Diện Tích Đến</label> <input type="text" class="form-control"
										name="rentAreaTo">
								</div>
							</div>

							<div class="col-md-4 pr-1">
								<div class="form-group">
									<label>Số Tầng Hầm</label> <input type="text" class="form-control"
										name="numberOfBasement">
								</div>
							</div>

							<div class="col-md-12">
								<div class="form-group">
									<label>Loại Tòa Nhà</label>
									<div class="form-group form-check-inline float-right">

										<c:forEach var="buildingType" items="${buildingTypes}">
											<div class="custom-control custom-checkbox float-right">
											
												<input type="checkbox" class="custom-control-input"
													id="${buildingType.key}" name="buildingTypes"
													value="${buildingType.key}"
													${fn:contains(fn:join(buildingModel.buildingTypes, ','),buildingType.key) ? 'checked' : ''}>
												<label class="custom-control-label"
													for="${buildingType.key}">${buildingType.value}
												</label>
												
											</div>
											
										</c:forEach>
									</div>
								</div>
							</div>

							<button type="submit" class="btn btn-primary float-right" name="action"
								value="LIST">Search</button>
						</form>

					</div>
				</div>

		</li>
	</ul>



	<div class="table-responsive-lg border-bottom border-dark">
		<table class="table">
			<thead class="thead-dark">
				<th>
					<input type="checkbox" value="" id="checkbox-all">
				</th>
				<th>Tên Tòa Nhà</th>
				<th>Địa Chỉ</th>
				<th>Số Tầng Hầm</th>
				<th>Giá Thuê</th>
				<th>Diện Tích Thuê</th>
				<th>Loại Tòa Nhà</th>
				<th>Tên Quản Lý</th>
				<th>SĐT Quản Lý</th>
				<th>Actions</th>
				<th>						
					<button type="button" class="btn btn-success" id="btn-delete">
							<i class='fas fa-trash'style="color: red;"></i>
					</button>
				</th>
			</thead>
			<tbody>

				<c:forEach var="building" items="${buildingModel.getListResults()}">
					<tr>
						<td><input type="checkbox" value="${building.id}" id="checkbox-id-${building.id}"></td>
						<td>${building.name}</td>
						<td>${building.getAddress().toString()}</td>
						<td>${building.numberOfBasement}</td>
						<td>${building.costRent}</td>
						<td>${building.rentArea}</td>
						<td>${building.type}</td><!-- type null  -->
						<td>${building.managerName}</td>
						<td>${building.managerPhone}</td>
						<td class="border-left border-bottom"><a class="nav-link"
								href="<c:url value="/admin-building?action=EDIT&id=${building.id}" />"> 
								<i class='far fa-edit'style="color: green;"></i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- search begin -->
	<div class="col-sm"></div>
</div>
<!-- Page Content End-->
<script>
	$('#btn-delete').click(function() {
		var dataArray = $('tbody input[type=checkbox]:checked').map(function() {
			return $(this).val();
		}).get();
		var data = {};
		data['ids'] = dataArray;
		deleteBuilding(data);
	});

function deleteBuilding(data) {
	$.ajax({
		url : '${buildingAPI}',
		data : JSON.stringify(data),
		type : 'DELETE',
		contentType: 'application/json',
		dataType : 'json',
		error : function() {
			window.location.href="${buildingURL}?action=LIST&message=error_system";
		},
		success : function() {
			window.location.href="${buildingURL}?action=LIST&message=delete_success";
		}
		
	});

}



</script>