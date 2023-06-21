<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>Login</title>
  </head>
  <body style="margin:0">
    <div>
      <div
        style="
          display: flex;
          flex-direction: row;
          background-color: rgb(67, 70, 79);
          width: 100%;
          height: 72px;
        "
      >
        <div style="color: white; font-size: 30px; margin: 10px 24px">POS</div>
      </div>
      <div
        style="
          display: flex;
          flex-direction: row;
          justify-content: center;
          align-items: center;
          margin-top: 100px;
          height: 100%;
          width: 100%;
        "
      >
        <img
          alt="Market_IMG"
          src="/img/market.png"
          style="width: 300px; height: 280px; margin: 30px 70px 0px 30px"
        />
        <form action="/login" method="post" 
          style="
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: 20px;
          "
        >
          <input
            type="text"
            name="userId"
            id="userId"
            value="${userAuthRequest.userId}"
            placeholder="userId"
            style="
              height: 30px;
              width: 300px;
              background-color: rgb(224, 226, 223);
              border: white;
              margin: 5px;
              border-radius: 5px;
              padding: 5px;
            "
          /><input
            type="password"
            name="password"
            id="password"
            value="${userAuthRequest.password}"
            placeholder="password"
            style="
              height: 30px;
              width: 300px;
              margin: 5px;
              background-color: rgb(224, 226, 223);
              border: white;
              border-radius: 5px;
              padding: 5px;
            "
          /><button
            type="submit"
            name="login"
            id="login"
            value="UserAuthRequest"
            style="
              height: 30px;
              width: 300px;
              cursor: pointer;
              background-color: rgb(98, 172, 235);
              color: white;
              border: none;
              padding: 5px;
              margin: 5px;
              border-radius: 5px;
            "
              >
            로그인</button
          ><button type="button"
            onclick="location.href='/join'"
            style="
              height: 30px;
              width: 300px;
              margin: 5px;
              cursor: pointer;
              background-color: rgb(98, 172, 235);
              color: white;
              padding: 5px;
              border: none;
              border-radius: 5px;
            "
          >회원가입
          </button>
        </form>
      </div>
    </div>
    <script>
    function handleLoginFailure() {
    	 var message = "${message}";
         if (message && message !== "") {
             alert(message);
         }
    }
  </script>
  </body>
</html>

