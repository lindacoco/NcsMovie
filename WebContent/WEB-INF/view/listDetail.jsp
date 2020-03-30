<style>
  div.detail{
     width:400px;
     margin:0 auto;
  }
  div.detail img{
    display: inline;
    float: left;
    margin: 15px;
  }
  p.ud{
    text-decoration: underline;
  }
</style>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 
<%
  pageContext.include("top.jsp");
%>
  <div class="detail">
    <img src='${pageContext.request.contextPath }/upload/${movie.file}'>
    <h2>${movie.title}</h2>
      <p class="ud">줄거리</p>
      <p>
       ${movie.content}
      </p>

  </div>
<%
   pageContext.include("footer.jsp"); 
%>