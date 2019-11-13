<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="/common/admin/header.jsp" %>

    <div class="main-content-inner">
              <div class="row">
                <div class="col-md-8">
                  <div class="card">
                    <div class="card-header">
                      <h5 class="title">Search Building</h5>
                    </div>
                    <div class="card-body">
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
                                  <input type="checkbox" class="custom-control-input" id="TANG-TRET" name="example1">
                                  <label class="custom-control-label" for="TANG-TRET">TẦNG TRỆT</label>
                                </div>
                                <div class="custom-control custom-checkbox float-right">
                                  <input type="checkbox" class="custom-control-input" id="NGUYEN-CAN" name="example1">
                                  <label class="custom-control-label" for="NGUYEN-CAN">NGUYÊN CĂN</label>
                                </div>
                                <div class="custom-control custom-checkbox float-right">
                                  <input type="checkbox" class="custom-control-input" id="NOI-THAT" name="example1">
                                  <label class="custom-control-label" for="NOI-THAT">NỘI THẤT</label>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                         <button type="button" class="btn btn-primary float-right">Search</button>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
          </div>

                    <%@include file="/common/admin/footer.jsp" %>