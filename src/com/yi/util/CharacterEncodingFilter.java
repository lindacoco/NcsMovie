package com.yi.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override //이부분만 신경쓰면 됨 어떤 커맨드를 이 필터를 거쳐가도록 한다고 하면 무조건 이걸 거쳐가야함 
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)  //다음필터 f1, f2, f3.. 다음 필터를 의미하는 것 
			throws IOException, ServletException {
         req.setCharacterEncoding("utf-8"); //따로 각각 처리 하지 않아도 됨 
         chain.doFilter(req, res); //다음 파일에도 리퀘스트와 리스판스를 넘겨주겠다 
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
