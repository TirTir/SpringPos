@ -1,181 +0,0 @@
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Order</title>
  </head>
  <body>
  <jsp:include page="main.jsp" />	
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
          <th style="width: 40%">상품명</th>
          <th style="width: 15%">단가</th>
          <th style="width: 10%">수량</th>
          <th style="width: 10%">비고</th>
          <c:forEach var="order" items="${orders}" varStatus="status">
          <tr>
            <td>${status.index+1}</td>
            <td>${order.productName}</td>
            <td>${order.price}</td>
            <td>${order.quantity}</td>
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
        "
      >
        <form action="order" style="display: flex; flex-direction: column">
          <input type="text" name="productName" id="productName" value="${OrderedRequest.productName}"
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
          />
        </div>
        <div
          style="
            display: flex;
            flex-direction: column;
            justify-content: center;
            height: 100px;
            width: 300px;
            background-color: rgb(217, 217, 217);
            border-radius: 5px;
            margin: 5px;
            padding: 5px;
          "
        >
          <div style="padding: 10px">받을 금액 :</div>
          <div
            style="
              display: flex;
              align-items: center;
              font-size: 30px;
              margin: 10px;
            "
          >
          	${order.productName}원
          </div>
        </div>
        <div style="display: flex; flex-direction: column; margin: 20px">
          <div>
            <button type="button" value="${OrderedRequest}"
              style="
                height: 50px;
                width: 150px;
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
              담기</button
            ><button
              style="
                height: 50px;
                width: 150px;
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
              반품
            </button>
          </div>
          <button
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
            결제하기</button
          ><button
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
            판매 내역
          </button>
        </div>
      </div>
    </div>
  </body>
</html>
