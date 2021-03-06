import executer.*;

import bean.*;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ReadServlet extends HttpServlet{
	ReadExecuter RE=new ReadExecuter();
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		int postNo;
		String StrPNo = req.getParameter("thread");
		//postNoには、threadパラメータが空なら1を入れる
		if (StrPNo == null || StrPNo.length() == 0){
			postNo = 1;
		}else{
			try{
				postNo = Integer.parseInt(StrPNo);
			}catch (NumberFormatException e){
				postNo = 1;
			}
		}
		
		ArrayList al = (ArrayList) RE.execute(postNo);
		
		//CheckReplace cr = new CheckReplace();
		//cb = cr.check(cb);
		try{
		
		ContentBean tester = (ContentBean)al.get(1);//テスト用のログ出力
		System.out.println(tester.getUser_name());//テスト用のログ出力

		}catch(IndexOutOfBoundsException e){};
		
		req.setAttribute("al",al);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req,res);
		
	}
}