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
      <div
        style="display: flex; flex-direction: row; height: 100%; width: 100%"
      >
        <div class="sidebar" style="height: 100%">
        	<jsp:include page="sidemenu.jsp" />
        </div>
        <div class="content">
	    	<div
	        style="
	          display: flex;
	          justify-content: center;
	          align-items: center;
	          width: 100%;
	        "
	      >
	        <img
	          alt="Market_IMG"
	          src="img/market.png"
	          style="width: 200px; height: 180px; margin: 30px 70px 0px 30px"
	        />
	      </div>
        </div>
      </div>
    </div>
  </body>
</html>
