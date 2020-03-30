package com.yi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yi.jdbc.JDBCUtil;
import com.yi.model.Movie;


public class MovieDAO {
   private final static MovieDAO dao = new MovieDAO();
   
   public static MovieDAO getInstance() {
		return dao;
	}
	
	private MovieDAO() {}
	
 
	public void insert(Connection conn, Movie movie) throws SQLException{
		PreparedStatement pstmt = null;
		
		
		try {
			String sql="insert into movie values (?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, movie.getNo());
			pstmt.setString(2, movie.getTitle());
			pstmt.setString(3, movie.getContent());
			pstmt.setString(4, movie.getFile());
			pstmt.setString(5, movie.getTime());

			
			pstmt.executeUpdate();
		}finally {
			JDBCUtil.close(conn);
		}

	}
	
	public List<Movie> list(Connection conn) throws SQLException{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql ="select * from movie";
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			List<Movie> list = new ArrayList<>();
			
			while(rs.next()) {
				Movie p = new Movie(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4),
						rs.getString(5));
				
				list.add(p);
				
			}
			return list;
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(conn);
		}
		
		
		
	}
	
	public Movie selectMovieByNo(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql="select * from movie where no=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				Movie movie = new Movie(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5));
				
				return movie;
			}
		
			
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(conn);
		}
		
		return null;
	}
	
	public int upadte(Connection conn, Movie movie) throws SQLException {
    	PreparedStatement pstmt = null;
    	
    	try {
    		String sql = "update movie set title=?, content=?, file=?, time=? where no=?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, movie.getTitle());
    		pstmt.setString(2, movie.getContent());
    		pstmt.setString(3, movie.getFile());
    		pstmt.setString(4, movie.getTime());
    		pstmt.setInt(5, movie.getNo());
    		return pstmt.executeUpdate();
    	}catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtil.close(pstmt);
		}
		return 0;
    	
    }
	
	public void deleteArticle(Connection conn, int no) throws SQLException {
		PreparedStatement pstmt = null;
		try {
			String sql = "delete from movie where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		} finally {
			JDBCUtil.close(pstmt);
		}
	}
	
	
}
