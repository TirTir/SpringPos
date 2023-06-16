<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <title>sidemenu</title>
  </head>
  <body>
    <div
      style="
        background-color: rgb(244, 244, 244);
        width: 250px;
        height: 100%;
        border-right: 1px solid rgb(118, 118, 118);
      "
    >
      <div
        onclick="location.href='/order'"
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
        판매
      </div>
      <div
        onclick="location.href='/statistic'"
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
        통계
      </div>
      <div
        onclick="location.href='/inventory'"
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
        재고 관리
      </div>
      <div
        onclick="location.href='/setting'"
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
  </body>
</html>
