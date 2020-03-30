package com.yi.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yi.jdbc.DBCPInit;
import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;

public class MovieDAOTest {
	Connection conn = null;
	MovieDAO dao = null;

	@Before
	public void setUp() throws Exception {
	try {	DBCPInit dbcpInit = new DBCPInit();
		dbcpInit.init(); //서버를 따로 생성 
		conn = JDBCUtil.getConnection();
		dao = MovieDAO.getInstance();
	} catch (Exception e) {
		e.printStackTrace();
	}
		
	}

	@After
	public void tearDown() throws Exception {
		
		 JDBCUtil.close(conn); 
	}

	@Test
	public void testInsert() throws SQLException {
		Movie movie = new Movie(3, "coconut", "코코넛맛설명", "아무거나" ,  new Date().toString());
		dao.insert(conn, movie);
	}

	@Test
	public void testList() throws SQLException {
		List<Movie> list = dao.list(conn);
		for(Movie movie : list) {
			System.out.println(movie);
		}
	}

	@Test
	public void testSelectMovieByNo() throws SQLException {
		Movie movie = new Movie();
		dao.selectMovieByNo(conn, 1);
	}

}
