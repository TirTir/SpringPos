<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Statistic</title>
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
            align-items: center;
            width: 100%;
          "
        >
          <div
            style="
              display: flex;
              flex-direction: row;
              justify-content: center;
              align-items: center;
              height: 85%;
              border-radius: 5px;
              background-color: rgb(248, 248, 248);
              padding: 15px;
              margin: 20px;
            "
          >
            <button
              type="button"
              onclick="location.href='./period'"
              style="
                height: 200px;
                width: 450px;
                cursor: pointer;
                background-color: rgb(244, 130, 34);
                font-size: 40px;
                font-weight: bold;
                color: rgb(99, 69, 59);
                border-radius: 5px;
                border: none;
                margin: 5px;
                padding: 5px;
              "
            >
              기간별 분석</button
            ><button
              type="button"
              onclick="location.href='./product'"
              style="
                height: 200px;
                width: 450px;
                cursor: pointer;
                background-color: rgb(244, 130, 34);
                font-size: 40px;
                font-weight: bold;
                color: rgb(99, 69, 59);
                border-radius: 5px;
                border: none;
                margin: 5px;
                padding: 5px;
              "
            >
              상품별 분석
            </button>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>
