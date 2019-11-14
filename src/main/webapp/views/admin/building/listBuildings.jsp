<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-lg-12 text-center">
			<div class="table-responsive-sm">
				<table class="table table-hover table-dark">
					<thead>
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Tên Tòa Nhà</th>
							<th scope="col">edit</th>
							<th scope="col">delete</th>
						</tr>
					</thead>

					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td><a class="nav-link" href="<c:url value="/admin-building?action=EDIT" />"><i class='far fa-edit' style="color:green;"></i></a></td>
							<td><a class="nav-link" href="<c:url value="/admin-building?action=DELETE" />"><i class='fas fa-trash' style="color:red;"></i></a></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Jacob</td>
							<td><a class="nav-link" href="<c:url value="/admin-building?action=EDIT" />"><i class='far fa-edit' style="color:green;"></i></a></td>
							<td><a class="nav-link" href="<c:url value="/admin-building?action=DELETE" />"><i class='fas fa-trash' style="color:red;"></i></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!-- Page Content End-->
