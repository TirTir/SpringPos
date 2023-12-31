<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel ="stylesheet" href ="/css/table.Styled.css" />
    <title>inventory</title>
  </head>
  <body style="margin: 0">
      <div
        style="display: flex; flex-direction: column; height: 100vh; width: 100vw"
      >
    	<jsp:include page="menu.jsp" />
    	<div style="display: flex; flex-direction: row; height: 100%; width: 100%;">
        <div class="sidebar" style="height: 100%">
        	<jsp:include page="sidemenu.jsp" />
        </div>
      <div class="content" style="height: 100%; width: 100%">
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
            <th style="width: 15%">상품 코드</th>
            <th style="width: 30%">상품명</th>
            <th style="width: 15%">단가</th>
            <th style="width: 10%">수량</th>
            <th style="width: 15%">입고 날짜</th>
            <c:forEach var="product" items="${product}" varStatus="status">
            <tr>
              <td>${product.productId}</td>
              <td>${product.productName}</td>
              <td>${product.price}</td>
              <td>${product.totalCount}</td>
              <td>${product.storeDateTime}</td>
            </tr>
          </c:forEach>
          </table>
        </div>
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
        height: 80%;
      "
    >
        <form
            style="
                display: flex;	
                flex-direction: column;
                align-items: center;
                margin: 10px 20px;
              "
        >
          <input
	        type="text"
	        id="search"
	        name="productName"
	        value="${productName}"
            placeholder="Search"
            style="
              height: 30px;
              width: 300px;
              background-color: rgb(224, 226, 223);
              border: white;
              border-radius: 5px;
              margin: 5px;
              padding: 5px;
            "
          /><button onClick="onSearch()"
            style="
              height: 50px;
              width: 300px;
              cursor: pointer;
              background-color: rgb(166, 190, 54);
              font-weight: bold;
              font-size: 30px;
              color: rgb(70, 91, 72);
              border-radius: 5px;
              border: none;
              margin: 5px;
              padding: 5px;
            "
          >
            검색하기
          </button>
        </form>
        
        <form action="/inventory/regist" method="post"
             style="
                  display: flex;
                  flex-direction: column;
                  align-items: center;
                  margin: 10px 20px;
          "
        >
          <input
            type="text"
	        name="productName"
	        value="${productRegisterRequest.productName}"
            placeholder="상품명"
            style="
              height: 30px;
              width: 300px;
              background-color: rgb(224, 226, 223);
              border: white;
              border-radius: 5px;
              margin: 5px;
              padding: 5px;
            "
          /><input
            type="text"
	        name="price"
	        value="${productRegisterRequest.price}"
            placeholder="가격"
            style="
              height: 30px;
              width: 300px;
              background-color: rgb(224, 226, 223);
              border: white;
              border-radius: 5px;
              margin: 5px;
              padding: 5px;
            "
          /><input
          type="text"
	        name="count"
	        value="${productRegisterRequest.count}"
            placeholder="수량"
            style="
              height: 30px;
              width: 300px;
              background-color: rgb(224, 226, 223);
              border: white;
              border-radius: 5px;
              margin: 5px;
              padding: 5px;
            "
          /><button type="submit" value="${productRegisterRequest}"
            style="
              height: 50px;
              width: 300px;
              cursor: pointer;
              background-color: rgb(244, 130, 34);
              font-weight: bold;
              font-size: 30px;
              color: rgb(99, 69, 59);
              border-radius: 5px;
              border: none;
              margin: 5px;
              padding: 5px;
            "
          >
            상품 추가
          </button>
        </form>
      </div>
    </div>
    </div>
    <script>		    
	    function onSearch() {
	    	var productName = document.getElementById('search').value;
	    	location.href = './search/' + productName;
	    	}
	    
	    function handleFailure() {
	    	 var message = "${message}";
	         if (message && message !== "") {
	             alert(message);
	         }
	    }
	  </script>
  </body>
</html>
