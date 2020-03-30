package com.yi.handler;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yi.DAO.MovieDAO;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;
import com.yi.mvc.CommandHandler;

public class DetailHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Connection conn = null;
		 int no = Integer.parseInt(req.getParameter("no"));
			
			try {
				
				conn = JDBCUtil.getConnection();
				MovieDAO dao = MovieDAO.getInstance();
				Movie movie = dao.selectMovieByNo(conn, no);  //프로덕트를 받음 
				//System.out.println(product);
				req.setAttribute("movie", movie); //넣어줌
				
				
				return "/WEB-INF/view/listDetail.jsp";
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
			finally {
				JDBCUtil.close(conn);
			}
			
			return null;
	}

}
