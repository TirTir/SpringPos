<%@ page contentType="text/html; charset=utf-8">
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>main</title>
  </head>
  <body style="margin: 0">
  	<jsp:include page="menu.jsp" />
      <div
        style="display: flex; flex-direction: row; height: 100%; width: 100%"
      >
        <div class="sidebar" style="height: 100%">
        	<jsp:include page="sidemenu.jsp" />
        </div>
        <div class="content">
          <jsp:include page="order.jsp" />
        </div>
      </div>
    </div>
  </body>
</html>
