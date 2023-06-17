<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>productStats</title>
  </head>
  <body style="margin: 0">
    <jsp:include page="menu.jsp" />
    <div style="display: flex; flex-direction: row; height: 100%; width: 100%">
      <div class="sidebar" style="height: 100%">
        <jsp:include page="sidemenu.jsp" />
      </div>
      <div class="content">
        <div style="height: 100%; width: 100%">
          <div
            style="
              display: flex;
              border-radius: 5px;
              background-color: rgb(248, 248, 248);
              padding: 15px;
              margin: 20px;
            "
          >
            <table style="height: 100%; width: 100%">
              <th style="width: 5%">No</th>
              <th style="width: 10%">상품 코드</th>
              <th style="width: 40%">상품명</th>
              <th style="width: 15%">단가</th>
              <th style="width: 10%">수량</th>
              <th style="width: 15%">합계</th>
              <c:forEachvar="statistics" items="${statistics}" varStatus="status"></c:forEach>
              <tr>
              <td>${status.index+1}</td>
              <td>${statistics.productId}</td>
              <td>${statistics.productName}</td>
              <td>${statistics.price}</td>
              <td>${statistics.count}</td>
              <td>${statistics.totalPrice}</td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>

