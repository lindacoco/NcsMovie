package com.yi.handler;

import java.io.File;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yi.DAO.MovieDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;
import com.yi.mvc.CommandHandler;

public class AddFormHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
if(req.getMethod().equalsIgnoreCase("get")) {
			
			return "/WEB-INF/view/movieForm.jsp";
			
			
		}else if(req.getMethod().equalsIgnoreCase("post")) {
			
			//서버안에 파일 저장 공간이 있어야 한다 -바탕화면 c드라이버 공간을 지정해줘야한다 
			String uploadPath = req.getRealPath("upload"); //서버 루트 안에 업로드 폴더 절대경로를 반환해준다
			//폴더의 존재여부를 알아봐야한다
			File dir = new File(uploadPath);
			if(dir.exists() == false) { //저장공간이 없으면 폴더를 만들어야함
				dir.mkdir(); //폴더 만들어줌
			}
			//System.out.println(uploadPath);
			
			//있으면
			//System.out.println(uploadPath); //경로만들어지는가 확인 후 넘어간다 
			//파일을 저장해보자
			int size = 1024*1024*10; //업로드시 파일 크기 제한이 있기 때문에  10M까지만 1024 =1k *1024 =1m * 10 
			MultipartRequest multi = new MultipartRequest(
					                               req,  //매개변수는 내가 원하는 만큼
					                               uploadPath, //업로드 절대경로
			                                       size,
			                                       "UTF-8", //한글깨지지 말라는 것 
			                                       new DefaultFileRenamePolicy()); //파일이 중복되었을때 바뀔 수 있도록
			//기존에 같은 이름인 파일은 바껴서 들어가야한다 
			
			//--파일 업로드 완료된 것 그 다음 일은 db에 상품을 등록해야함 
			
			Connection conn = null;
			
			
			try {
				conn = JDBCUtil.getConnection();
				//productDAO만들어서 넣어줘야함 
				MovieDAO dao = MovieDAO.getInstance();
				Movie movie = new Movie(
						0, 
						multi.getParameter("title"), 
						multi.getParameter("content"), 
						multi.getFilesystemName("file"),
						multi.getParameter("time")) ;
				
				//화면은 리스트로 돌아감
				dao.insert(conn, movie);
		
				//return "/WEB-INF/view/product/listForm.jsp"; 이러면 그냥 jsp라서 디비 정보 안가져옴 
				//새로고침할때마다 추가 되는 문제 해결 
				res.sendRedirect(req.getContextPath()+"/list.do");
				return null;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
			
			
		}
		return null;
	}

}
