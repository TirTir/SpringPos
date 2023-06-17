<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>inventory</title>
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
        <th style="width: 15%">상품 코드</th>
        <th style="width: 30%">상품명</th>
        <th style="width: 15%">단가</th>
        <th style="width: 10%">수량</th>
        <th style="width: 15%">입고 날짜</th>
        <c:forEachvar="order" items="${orders}" varStatus="status"></c:forEach>
      
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
        height: 80%;
      "
    >
      <div
        style="
          display: flex;
          flex-direction: column;
          margin: 10px 20px;
          align-items: center;
        "
      >
        <input
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
        /><button
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
      </div>
      <div
        style="
          display: flex;
          flex-direction: column;
          margin: 10px 30px;
          align-items: center;
        "
      >
        <input
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
        /><button
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
      </div>
    </div>
  </body>
</html>
