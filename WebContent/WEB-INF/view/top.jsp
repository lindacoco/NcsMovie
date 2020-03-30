<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   *{
     margin:0;
     padding:0;
   }
   #container{
     width:960px;
     margin:0 auto;
     margin-top:50px;
   }
   h1{
    height: 100px;
    text-align: center;
   }
   
   ul{
    list-style: none;
    width:100%;
    height:50px;
    background: pink;
 
   }
   li{
     float: left;
     width:25%;
     text-align: center;
   }
   li a{
    display: block;
    line-height: 50px;
    text-decoration: none;
    color:black;
   }
   
   #center{
    position: relative;
   }
   #center img{
    width:960px;
   }
   #center p{
    position: absolute;
    top:0;
    left:10px;
    color: white;
    font-size: large;
   }
   
   footer{
     clear: both;
     height: 30px;
     text-align: center;
     background: mistyrose;
     margin-top:20px;
   }
   content{
    width:960px;
    height: 500px;
   }
   #login{
     color:black;
     text-decoration: none;
     border:1px solid pink;
     padding:3px;
   }
   
</style>
</head>
<body>
   <div id="container">
     
     <header>
     <h1>대구 CGV</h1>
     <%
       String auth = (String) session.getAttribute("Auth");
     
       if(auth != null){
    	   out.println("<a href='movieLogout.jsp' name='login' id='login'>로그아웃</a>");
    	   out.println(auth+"님 반갑습니다");
       }else{
    	   out.print("<a href='movieLoginForm.jsp' name='login' id='login'>로그인</a>");
       }
     %>
    
     <ul>
        <li><a href="home.do">HOME</a></li>
        <li><a href="list.do">상영영화</a></li>
        <li><a href="timetable.do">상영시간표</a></li>
        <li><a href="movieBoardList.jsp">게시판</a></li>
     </ul>
   </header>