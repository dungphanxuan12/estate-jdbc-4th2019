<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Page Content -->
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<h4 class="card-title">List Buildings</h4>
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<table class="table">
							<thead class=" text-primary">
								<th>ID</th>
								<th>Name</th>
								<th>ward</th>
								<th>Street</th>
								<th>Number of Basement</th>
								<th class="text-right">Edit</th>
								<th class="text-right">Delete</th>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Niger</td>
									<td>Niger</td>
									<td>Niger</td>
									<td>Oud-Turnhout</td>
									<td class="text-right"><a class="nav-link"
										href="<c:url value="/admin-building?action=EDIT" />">
										<i class='far fa-edit' style="color: green;"></i></a>
									</td>
									<td class="text-right"><a class="nav-link"
										href="<c:url value="/admin-building?action=DELETE" />"><i
											class='fas fa-trash' style="color: red;"></i></a>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Page Content End-->
