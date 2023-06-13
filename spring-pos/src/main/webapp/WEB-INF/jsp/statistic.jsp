<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Statistic</title>
  </head>
  <body style="width: 100%">
  <jsp:include page="main.jsp" />
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
  </body>
</html>
