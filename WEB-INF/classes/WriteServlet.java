import executer.*;
import bean.*;
//import check.*;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WriteServlet extends HttpServlet{
	ReadExecuter RE=new ReadExecuter();
	WriteExecuter We=new WriteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		System.out.println("���e");
		ContentBean CB=new ContentBean();
		

		String user_name = req.getParameter("user_name");
		String email_address = req.getParameter("email_address");
		String message = req.getParameter("message");
		String delete_key = req.getParameter("delete_key");
		String image = req.getParameter("image");
 
		
		if(user_name.length()==0){
			user_name="������";
		}
		if(delete_key.length()==0){
			delete_key=" ";
		}
		System.out.println(user_name+"����̓��e");
		//�o�C�g���𒴂��Ă��Ȃ����̃`�F�b�N-----------
		/*boolean isError = CheckBytes.check(name,text);
		if(isError){
			res.sendRedirect("/testbb/conbyteserror.html");
			return;
		}
		//-------------------------------------------
		*/
		
		CB.setUser_name(user_name);
		CB.setEmail_address(email_address);
		CB.setMessage(message);
		CB.setDelete_key(delete_key);
		CB.setImage(image);
		
		We.execute(CB);
		
		int postNo = -1;
		ArrayList al = (ArrayList) RE.execute(postNo);
		
		//CheckReplace cr = new CheckReplace();
		//tb = cr.check(tb);
		
		req.setAttribute("al",al);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/practice.jsp");
		dispatcher.forward(req,res);
		
		//�������񂾃X���b�h��\��----------------------------------------------------
		/*ReadExecuter RE=new ReadExecuter();
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/contents.jsp");
		dispatcher.forward(req,res);*/
		//-----------------------------------------------------------------------------
		
	}
}
