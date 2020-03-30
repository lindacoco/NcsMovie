package com.yi.mvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUsingURI extends HttpServlet { //메인으로 역할을 한다
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		//map만들기 - command와 class가 담기게 처리됨
		String configFile = getInitParameter("configFile"); //properies 파일 위치 
		Properties prop = new Properties(); // 자바유틸걸로
		String configFilePath = getServletContext().getRealPath(configFile); //절대경로
		try(FileReader fis = new FileReader(configFilePath)){ //properties 파일을 담음
	              prop.load(fis);
			}catch(IOException e) {
				throw new ServletException(e);
		}
		
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()) {
			String command = (String) keyIter.next(); //첫번째 넥스트엔 simple.do
			String handlerClassName = prop.getProperty(command);  //com.yi.handler.SimpleHandler
			// 스트링을 클래스화 해야하는작업 
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = 
						 (CommandHandler) handlerClass.newInstance();  //클래스화 공통인 commandHandler로 인스턴스화
				commandHandlerMap.put(command, handlerInstance);
			}catch(Exception e) {
				throw new ServletException(e);
			}
		}
		
		
		super.init();
		
		
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String command = request.getRequestURI();
		if(command.indexOf(request.getContextPath())==0) {
			command = command.substring(request.getContextPath().length());
			
		}
		
		CommandHandler handler = commandHandlerMap.get(command);
		if(handler == null) {
			handler = new NullHandler();
		}
	
	 String viewPage = null;
	 
	 try {
		 viewPage = handler.process(request, response);
		 
		 
	 }catch(Exception e) {
		 e.printStackTrace();
		 throw new ServletException();
	 }
	 
	 if(viewPage != null) {
		 RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	     dispatcher.forward(request, response);	 
	 }
	}

}
