<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <div style="display: flex; flex-direction: row; height: 100%; width: 100%">
      <div class="sidebar" style="height: 100%">
        <jsp:include page="sidemenu.jsp" />
      </div>
      <div class="content">
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
              <th style="width: 5%">No</th>
              <th style="width: 40%">유저 이름</th>
              <th style="width: 15%">아이디</th>
              <th style="width: 10%">직책</th>
              <c:forEach var="user" items="${users}" varStatus="status"></c:forEach>
	          <tr class="click">
	            <td>${status.index+1}</td>
	            <td id="${user.userName}">${user.userName}</td>
	            <td>${user.userId}</td>
	            <td>${user.position}</td>
	          </tr>
            </table>
          </div>
          <div
            style="
              display: flex;
              flex-direction: column;
              align-items: center;
              border-radius: 5px;
              background-color: rgb(248, 248, 248);
              margin: 20px;
              justify-content: center;
              height: 300px;
            "
          >
            <form action="main/setting" method="post"
            	style="display: flex; flex-direction: column; margin: 20px">
              <input type="text" name="userName" value="${userName}"
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
              /><button type="submit" value="${userName}"
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
                검색하기</button
              ><button type="button" onclick="onDelete()"
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
                삭제하기
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
    <script>
	  var userName;
	  $(".click").bind("click", function () {
	    var userName = $(this).closest("tr").prevAll().length;
	    console.log(userName);
	  });
	  function onDelete() {
	    location.href = "./${user.userName}";
	  }
  </script>
  </body>
</html>
