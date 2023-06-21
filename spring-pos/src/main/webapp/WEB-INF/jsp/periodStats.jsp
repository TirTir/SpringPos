<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/css/table.Styled.css" />
    <title>period</title>
  </head>
  <body style="margin: 0">
    <div
      style="display: flex; flex-direction: column; height: 100vh; width: 100vw"
    >
      <jsp:include page="menu.jsp" />
      <div
        style="display: flex; flex-direction: row; height: 100%; width: 100%"
      >
        <div class="sidebar" style="height: 100%">
          <jsp:include page="sidemenu.jsp" />
        </div>
        <div class="content" style="height: 100%; width: 100%">
          <div
            style="
              display: flex;
              flex-direction: row;
              width: 100%;
              align-items: center;
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
                <th style="width: 20%">날짜</th>
                <th style="width: 10%">건</th>
                <th style="width: 10%">매출</th>
                <c:forEach var="statistic" items="${statistic}"></c:forEach>
                <tr>
                  <td>${statistic.orderDateTime}</td>
                  <td>${statistic.totalNumber}</td>
                  <td>${statistic.tatalPrice}</td>
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
                height: 500px;
              "
            >
              <div style="display: flex; flex-direction: column; margin: 20px">
                <button
                  type="button"
                  onclick="onPeriod('monthly')"
                  style="
                    height: 100px;
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
                  월별 집계</button
                ><button
                  type="button"
                  onclick="onPeriod('weekly')"
                  style="
                    height: 100px;
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
                  주간 집계</button
                ><button
                  type="button"
                  onclick="onPeriod('daily')"
                  style="
                    height: 100px;
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
                  일별 집계
                </button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
      function onPeriod(period) {
        location.href = "./" + period;
      }
    </script>
  </body>
</html>

