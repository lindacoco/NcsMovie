<style>
  h3{
    text-align: center;
  }
  div#list{
    width:85%;
    margin:0 auto;
    margin-top:10px;
  }
  .each{
    margin-right:10px;
    float: left;
    border: 1px solid gray;
    margin-bottom: 10px;
  }
  .each p{
    text-align: center;
    color: black;
    height: 30px;
    line-height: 30px;
  }
  .each a{
    text-decoration: none;
  }
  #aa {
    color:black;
    margin-left:80px;
  }
</style>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
  pageContext.include("top.jsp");
%>
<h3>리스트</h3>
<a href="${pageContext.request.contextPath }/addMovie.do" id="aa">상영영화 추가하기</a>
<div id="list">
<%-- <%
  if(list.size() ==0){
	  out.println("게시글이 없습니다");
  }
  for(int i=0; i<list.size(); i++){
	  MovieInfo movie = list.get(i);
  
     out.println("<div class='each'><a href='listDetail.jsp?index="+i+"'>"
     
    		 + "<img src='images/"+movie.getFile()+ "'>" 
    		 + "<p> "+ movie.getTitle() +"</p>" 
    		 + "</a></div>");
  }
%> --%>

    <c:if test="${list == null }">
       게시글이 없습니다.
    </c:if>
<c:forEach var="m" items="${list }" varStatus="status">

    <div class='each'>
    <a href='${pageContext.request.contextPath }/detail.do?no=${m.no}'>
    <img src='${pageContext.request.contextPath }/upload/${m.file}'>
    <p>${m.title }</p>
    </a></div>
</c:forEach>


</div>
<br>
<%
   pageContext.include("footer.jsp"); 
%>
