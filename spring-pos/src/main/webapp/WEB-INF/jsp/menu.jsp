<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>menu</title>
  </head>
  <body>
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
      <div 
      	style="color: white; font-size: 30px; margin: 10px 24px; cursor: pointer;"
        onClick="location.href='/main'"
      >POS</div>
      <div style="display: flex; flex-direction: row; align-items: center">
        <div style="color: white; margin: 10px">${user.userName}님 환영합니다.</div>
        <button
          type="button"
          name="logout"
          id="logout"
          onClick="onLogout()"
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
    <script>
    	var user = JSON.parse(localStorage.getItem("user")); //객체로 변환
    	
    	function onLogout() {
    		localStorage.removeItem("user");
    		location.href='/logout';
    	}
    </script>
  </body>
</html>
