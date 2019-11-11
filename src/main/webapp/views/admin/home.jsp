<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
      <div class="content">
        <div class="row">
          <div class="col-md-6">
            <div class="card  card-tasks">
              <div class="card-header ">
                <h5 class="card-category">List Buildings</h5>
                <h4 class="card-title">Buildings</h4>
              </div>
              <div class="card-body ">
                <div class="table-full-width table-responsive">
                  <table class="table">
                    <tbody>
                      <tr>
                        <td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input" type="checkbox" checked>
                              <span class="form-check-sign"></span>
                            </label>
                          </div>
                        </td>
                        <td class="text-left">Sign contract for "What are conference organizers afraid of?"</td>
                        <td class="td-actions text-right">
                          <button type="button" rel="tooltip" title=""
                            class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral"
                            data-original-title="Edit Task">
                            <i class="now-ui-icons ui-2_settings-90"></i>
                          </button>
                          <button type="button" rel="tooltip" title=""
                            class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral"
                            data-original-title="Remove">
                            <i class="now-ui-icons ui-1_simple-remove"></i>
                          </button>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input" type="checkbox">
                              <span class="form-check-sign"></span>
                            </label>
                          </div>
                        </td>
                        <td class="text-left">Lines From Great Russian Literature? Or E-mails From My Boss?</td>
                        <td class="td-actions text-right">
                          <button type="button" rel="tooltip" title=""
                            class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral"
                            data-original-title="Edit Task">
                            <i class="now-ui-icons ui-2_settings-90"></i>
                          </button>
                          <button type="button" rel="tooltip" title=""
                            class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral"
                            data-original-title="Remove">
                            <i class="now-ui-icons ui-1_simple-remove"></i>
                          </button>
                        </td>
                      </tr>
                      <tr>
                        <td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input" type="checkbox" checked>
                              <span class="form-check-sign"></span>
                            </label>
                          </div>
                        </td>
                        <td class="text-left">Flooded: One year later, assessing what was lost and what was found when a
                          ravaging rain swept through metro Detroit
                        </td>
                        <td class="td-actions text-right">
                          <button type="button" rel="tooltip" title=""
                            class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral"
                            data-original-title="Edit Task">
                            <i class="now-ui-icons ui-2_settings-90"></i>
                          </button>
                          <button type="button" rel="tooltip" title=""
                            class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral"
                            data-original-title="Remove">
                            <i class="now-ui-icons ui-1_simple-remove"></i>
                          </button>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
              <div class="card-footer ">
                <hr>
                <div class="stats">
                  <i class="now-ui-icons loader_refresh spin"></i> Updated 3 minutes ago
                </div>
              </div>
            </div>
          </div>
          <div class="col-md-6">
            <div class="card">
              <div class="card-header">
                <h5 class="card-category">Buildings</h5>
                <button class="btn btn-success" type="button" value="Add Building">
                  <a href="./create-building.html" style="color: white;">Add Building</a>
                </button>
                <h4 class="card-title">Lists Buildings</h4>
              </div>
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table">
                    <thead class=" text-primary">
                      <th>
                        id
                      </th>
                      <th>
                        Name
                      </th>
                      <th>
                        Ward
                      </th>
                      <th>
                        Street
                      </th>
                      <th>
                        
                        </th>
                      <th>

                      </th>
                      <th>

                      </th>
                    </thead>
                    <tbody>
                      <tr>
                        <td>
                          1
                        </td>
                        <td>
                          BITEXCO
                        </td>
                        <td>
                          Quáº­n 1
                        </td>
                        <td>
                          Tráº§n Duy HÆ°ng
                        </td>
                        <td>
                          <a href="./update-building.html" style="color: white;"><img
                              src="../assets/img/icons8-edit-64.png" class="card-img-top w-25" alt="update"></a>
                        </td>
                        <td>
                          <img src="../assets/img/icons8-delete-bin-64.png" class="card-img-top w-25" alt="delete">
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
<!-- footer -->
<%@include file="/common/admin/footer.jsp"%>