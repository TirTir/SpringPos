<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Ordered</title>
  </head>
  <body>
  <div
  style="
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    width: 100%;
  "
    >
	  <div
	    style="
	      display: flex;
	      width: 800px;
	      height: 85%;
	      border-radius: 5px;
	      background-color: rgb(248, 248, 248);
	      padding: 15px;
	      margin: 20px;
	    "
	  >
	    <table style="height: 100%; width: 100%">
	      <th style="width: 15%">주문번호</th>
	      <th style="width: 40%">거래 시간</th>
	      <th style="width: 20%">금액</th>
	      <c:forEach var="order" items="${orders}" varStatus="status"></c:forEach>
	      <tr>
	        <td id="${order.orderId}" value="${order}">${order.orderId}</td>
	        <td>${order.orderDateTime}</td>
	        <td>${order.totalPrice}</td>
	      </tr>
	    </table>
	  </div>
	  <div
	    style="
	      display: flex;
	      flex-direction: column;
	      align-items: center;
	      justify-content: center;
	      border-radius: 5px;
	      background-color: rgb(248, 248, 248);
	      margin: 20px;
	    "
	  >
	    <form action="main/inventory/ordered/search" method="post"
	    	style="display: flex; flex-direction: column; margin: 20px">
	      <input 
		    type="text"
		    name="orderId"
		    value="${orderId}"
	        placeholder="주문번호"
	        style="
	          height: 30px;
	          width: 300px;
	          background-color: rgb(224, 226, 223);
	          border: white;
	          border-radius: 5px;
	          margin: 5px;
	          padding: 5px;
	        "
	      /><button type="submit" value="orderId"
	        style="
	          height: 50px;
	          width: 300px;
	          cursor: pointer;
	          background-color: rgb(166, 190, 54);
	          font-size: 30px;
	          font-weight: bold;
	          color: rgb(70, 91, 72);
	          border-radius: 5px;
	          border: none;
	          margin: 5px;
	          padding: 5px;
	        "
	      >
	        검색
	      </button>
	      <div
	        style="
	          display: flex;
	          flex-direction: column;
	          justify-content: center;
	          height: 100px;
	          width: 300px;
	          background-color: rgb(217, 217, 217);
	          border-radius: 5px;
	          margin: 30px 5px;
	          padding: 5px;
	        "
	      >
	        <div style="padding: 10px">받은 금액 :</div>
	        <div id="price"
	          style="
	            display: flex;
	            align-items: center;
	            font-size: 30px;
	            margin: 10px;
	          "
	        >
	          원
	        </div>
	      </div>
	      <button type="button"
	    	onclick="location.href='../inventory/oredred'"
	        style="
	          height: 50px;
	          width: 300px;
	          cursor: pointer;
	          background-color: rgb(244, 130, 34);
	          font-size: 30px;
	          font-weight: bold;
	          color: rgb(99, 69, 59);
	          border-radius: 5px;
	          border: none;
	          margin: 5px;
	          padding: 5px;
	        "
	      >
	        환불</button
	      ><button type="button" 
	      	onclick="javascript:onDelete()"
	        style="
	          height: 50px;
	          width: 300px;
	          cursor: pointer;
	          background-color: rgb(244, 130, 34);
	          font-size: 30px;
	          font-weight: bold;
	          color: rgb(99, 69, 59);
	          border-radius: 5px;
	          border: none;
	          margin: 5px;
	          padding: 5px;
	        "
	      >
	        돌아가기
	      </button>
	    </div>
	  </div>
	</div>
	<script>
		var trNum = 0;
		var price=0;
		$(".click").bind("click", function () {
		  var trNum = $(this).closest("tr").prevAll().length;
		  price = document.getElementById("price") + "원";
		  price.innerHTML = price;
		});
		function onDelete() {
		    location.href = "./delete/${trNum}";
		  }
	</script>
	</body>
</html>
