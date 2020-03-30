<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
      Connection conn = null;
    
    
    try{
      String jdbcDriver = "jdbc:apache:commons:dbcp:jhs_movie";
      conn = DriverManager.getConnection(jdbcDriver);
      
      if(conn != null){
    	  out.println("jhs_movie 커넥션 풀에 연결되었습니다");
      }else{
    	  out.println("실패");
      }
    }finally{
    	if(conn != null){
    		conn.close();
    	}
    	
    }
    
      
    %>
</body>
</html>