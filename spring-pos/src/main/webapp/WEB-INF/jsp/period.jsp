<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>period</title>
  </head>
  <body
    style="
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      width: 100%;
    "
  >
  <jsp:include page="main.jsp" />
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
        <th style="width: 40%">상품명</th>
        <th style="width: 15%">합계</th>
        <tr>
          <td>1</td>
          <td>파이썬</td>
          <td>1,250</td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr>
          <td></td>
          <td></td>
          <td></td>
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
  </body>
</html>
