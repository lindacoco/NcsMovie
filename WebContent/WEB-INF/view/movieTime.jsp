
<style>
  h2{
    text-align: center;
  }
  div#timeTable{
    width:700px;
    margin:0 auto;
    
  }
  table{
   border-collapse: collapse;
   width:700px;
  }
  td{
   border:1px solid black;
   height: 30px;
  }
  td:first-child {
	text-align: center;
	font-weight: bold;
}
</style>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>

<div id="timeTable">
  <h2>상영시간표</h2>
<table>
<%--   <%
    for(int i=0; i<list.size(); i++ ){
    	MovieInfo movie = list.get(i);
    	out.println("<tr>");
    	out.println("<td>"+movie.getTitle()+"</td>");
    	out.println("<td>"+movie.getTime()+ "</td>");
    	out.println("</tr>");
    }

  %> --%>
  
  <c:forEach var="m" items="${list}">
     <tr><td>${m.title }</td>
         <td>${m.time }</td>
     </tr>
  
  </c:forEach>
  
  
</table>

</div>
<%
   pageContext.include("footer.jsp"); 
%>