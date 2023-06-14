<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>main</title>
  </head>
  <body style="margin: 0">
    <div style="display: flex; flex-direction: column; width: 100vw">
      <div
        style="
          display: flex;
          flex-direction: row;
          justify-content: space-between;
          background-color: rgb(67, 70, 79);
          width: 100%;
          height: 72px;
        "
      >
        <div style="color: white; font-size: 30px; margin: 10px 24px">POS</div>
        <div style="display: flex; flex-direction: row; align-items: center">
          <div style="color: white; margin: 10px">관리자님 환영합니다.</div>
          <button
            type="button"
            name="logout"
            id="logout"
            onClick="location.href='./logout'"
            style="
              margin: 10px 24px;
              width: 100px;
              height: 50px;
              background-color: rgb(98, 172, 235);
              color: white;
              cursor: pointer;
            "
          >
            로그아웃
          </button>
        </div>
      </div>
      <div
        style="display: flex; flex-direction: row; height: 100%; width: 100%"
      >
        <div class="sidebar" style="height: 100%">
          <div
            style="
              background-color: rgb(244, 244, 244);
              width: 250px;
              height: 100%;
              border-right: 1px solid rgb(118, 118, 118);
            "
          >
            <div
              style="
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                color: rgb(118, 118, 118);
                width: 100%;
                height: 80px;
                border-bottom: 1px solid rgb(118, 118, 118);
                cursor: pointer;
                font-weight: bold;
                font-size: 25px;
              "
            >
              <a href="./order.jsp" style="text-decoration: none">판매</a>
            </div>
            <div
              href="./statistic.jsp"
              style="
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                color: rgb(118, 118, 118);
                width: auto;
                height: 80px;
                border-bottom: 1px solid rgb(118, 118, 118);
                cursor: pointer;
                font-weight: bold;
                font-size: 25px;
              "
            >
              <a href="./statistic.jsp" style="text-decoration: none">통계</a>
            </div>
            <div
              style="
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                color: rgb(118, 118, 118);
                width: 100%;
                height: 80px;
                border-bottom: 1px solid rgb(118, 118, 118);
                cursor: pointer;
                font-weight: bold;
                font-size: 25px;
              "
            >
              <a href="./inventory.jsp" style="text-decoration: none"
                >재고 관리</a
              >
            </div>
            <div
              style="
                display: flex;
                flex-direction: row;
                justify-content: center;
                align-items: center;
                color: rgb(118, 118, 118);
                width: 100%;
                height: 80px;
                border-bottom: 1px solid rgb(118, 118, 118);
                cursor: pointer;
                font-weight: bold;
                font-size: 25px;
              "
            >
              계정 관리
            </div>
          </div>
        </div>
        <div class="content">
          <jsp:include page="order.jsp" />
        </div>
      </div>
    </div>
  </body>
</html>
