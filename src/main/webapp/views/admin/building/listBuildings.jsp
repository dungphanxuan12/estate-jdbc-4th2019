<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.laptrinhweb.dto.BuildingDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Page Content -->
					<h4 class="card-title">List Buildings</h4>
					<div class="table-responsive-lg border-bottom border-dark">
						<table class="table">
							<thead class="thead-dark">
								<th>Tên Tòa Nhà</th>
								<th>Địa Chỉ</th>
								<th>Giá Thuê</th>
								<th>Diện Tích Thuê</th>
								<th>Loại Tòa Nhà</th>
								<th>Tên Quản Lý</th>
								<th>SĐT Quản Lý</th>
								<th colspan="2" class="bg-primary text-center" >Actions</th>
							</thead>
							<tbody>
								
									<c:forEach var="building" items="${buildingModel.listResults}">
										<tr>
											<td>${building.name}</td>
											<td>${building.getAddress().toString()}</td>
											<td>${building.costRent}</td>
											<td>${building.rentArea}</td>
											<td>${building.type}</td>
											<td>${building.managerName}</td>
											<td>${building.managerPhone}</td>
											<td class="border-left border-bottom border-primary"><a class="nav-link"
												href="<c:url value="/admin-building?action=EDIT" />">
												<i class='far fa-edit' style="color: green;"></i></a>
											</td>
											<td class="border-right border-bottom border-primary"><a class="nav-link"
												href="<c:url value="/admin-building?action=DELETE" />"><i
													class='fas fa-trash' style="color: red;"></i></a>
											</td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
					<!-- search begin -->
					<div class="search">
						                      <form>
                        <div class="row">
                          <div class="col-md-5 pr-1">
                            <div class="form-group">
                              <label>Tên tòa nhà</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-3 px-1">
                            <div class="form-group">
                              <label>Diện tích sàn</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 pl-1">
                            <div class="form-group">
                              <label for="exampleInputEmail1">Quận hiện có</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-6 pr-1">
                            <div class="form-group">
                              <label>Phường</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-6 pl-1">
                            <div class="form-group">
                              <label>Đường</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-12">
                            <div class="form-group">
                              <label>Kết cấu</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-4 pr-1">
                            <div class="form-group">
                              <label>Số tầng hầm</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 px-1">
                            <div class="form-group">
                              <label>Diện tích</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 pl-1">
                            <div class="form-group">
                              <label>Giá thuê</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-4 pr-1">
                            <div class="form-group">
                              <label>Giá dịch vụ</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 px-1">
                            <div class="form-group">
                              <label>Giá giữ ô tô</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 pl-1">
                            <div class="form-group">
                              <label>Giá giữ xe máy</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-4 pr-1">
                            <div class="form-group">
                              <label>Phí ngoài giờ</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 px-1">
                            <div class="form-group">
                              <label>Giá điện</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 pl-1">
                            <div class="form-group">
                              <label>Đặt cọc</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-4 pr-1">
                            <div class="form-group">
                              <label>Thanh toán</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 px-1">
                            <div class="form-group">
                              <label>Thời gian thuê</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 pl-1">
                            <div class="form-group">
                              <label>Tên quản lý</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-4 pr-1">
                            <div class="form-group">
                              <label>Điện thoại quản lý</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 px-1">
                            <div class="form-group">
                              <label>Thời gian thuê</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                          <div class="col-md-4 pl-1">
                            <div class="form-group">
                              <label>Tên quản lý</label>
                              <input type="text" class="form-control">
                            </div>
                          </div>
                        </div>
                        <div class="row">
                          <div class="col-md-12">
                            <div class="form-group">
                              <label>Loại Tòa Nhà</label>
                              <div class="form-group form-check-inline float-right">
                                <div class="custom-control custom-checkbox float-right">
                                  <input type="checkbox" class="custom-control-input" id="TANG-TRET" name="TANG_TRET" value="TANG_TRET">
                                  <label class="custom-control-label" for="TANG-TRET">TẦNG TRỆT</label>
                                </div>
                                <div class="custom-control custom-checkbox float-right">
                                  <input type="checkbox" class="custom-control-input" id="NGUYEN-CAN" name="NGUYEN_CAN" value="NGUYEN_CAN">
                                  <label class="custom-control-label" for="NGUYEN-CAN">NGUYÊN CĂN</label>
                                </div>
                                <div class="custom-control custom-checkbox float-right">
                                  <input type="checkbox" class="custom-control-input" id="NOI-THAT" name="NOI_THAT" value="NOI_THAT">
                                  <label class="custom-control-label" for="NOI-THAT">NỘI THẤT</label>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                         <button type="button" class="btn btn-primary float-right">Search</button>
                      </form>
					</div>
<!-- Page Content End-->
