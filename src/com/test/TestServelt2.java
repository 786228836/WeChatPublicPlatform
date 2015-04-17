package com.test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class TestServelt2
 */
public class TestServelt2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServelt2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("application/json;charset=UTF-8");
	    String code = request.getParameter("code");
	    
	    
//	    PrintStream ps=new PrintStream("/opt/scf/logs/admin/1log.txt");  
//        System.setOut(ps);  
	
        
	    String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx8cc813db338acc33&secret=8c86bbf68906e0ddd6777e084c727d3e&code="+code+"&grant_type=authorization_code";
	    JSONObject  jsonObject = WeixinUtil.httpRequest(url, "GET", null);
	    PrintWriter out= response.getWriter();      
	    out.write(jsonObject.toString());
	    out.close();
	     
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
