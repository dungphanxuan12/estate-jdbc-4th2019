<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
      <footer class="footer">
        <div class="container-fluid">
          <nav>
            <ul>

            </ul>
          </nav>
          <div class="copyright" id="copyright">
            &copy;
            <script>
              document.getElementById('copyright').appendChild(document.createTextNode(new Date().getFullYear()))
            </script>,
            <a href="#" target="_blank"></a>Coded by REAL ESTATE
          </div>
        </div>
      </footer>
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="<c:url value='/template/admin/assets/js/core/jquery.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/core/popper.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/core/bootstrap.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/plugins/perfect-scrollbar.jquery.min.js'/>"></script>
  <script src="<c:url value='/template/admin/assets/js/plugins/bootstrap-notify.js'/>"></script>
  <script>
    $(document).ready(function () {
      // Javascript method's body can be found in assets/js/demos.js
      demo.initDashboardPageCharts();

    });
  </script>
</body>

</html>