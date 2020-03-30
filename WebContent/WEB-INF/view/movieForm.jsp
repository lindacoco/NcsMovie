<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
   form{
     width:500px;
     margin:0 auto;
     padding:5px;
   }
   fieldset{
     padding:15px;
   }
 
</style>
<%
  pageContext.include("top.jsp");
%>
 <content>
   <form action="${pageContext.request.contextPath }/addMovie.do" method="post" enctype="multipart/form-data">
      <fieldset>
         <legend>영화정보</legend>

         <p>
           <label>제목 : </label>
           <input type="text" name="title" placeholder="영화이름">
         </p>
         <p>
           <label>상세 설명: </label><br>
           <textarea rows="10" cols="40" name="content" placeholder="영화 상세 설명"></textarea>
         </p>
         <p>
           <label>첨부이미지</label>
           <input type="file" name="file">
         </p>
         <p>
           <label>상영 시간 :</label>
           <input type="text" placeholder="경로" name="time">
         </p>
         <input type="submit" value="전송">
      </fieldset>
    </form>
 </content>
<%
   pageContext.include("footer.jsp"); 
%>