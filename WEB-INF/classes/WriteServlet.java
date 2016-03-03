import executer.*;
import bean.*;
import check.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class WriteServlet extends HttpServlet{
	
	WriteExecuter We=new WriteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		ContentBean CB=new ContentBean();
		

		String user_name = req.getParameter("user_name");
		String email_address = req.getParameter("email_address");
		String message = req.getParameter("message");
		String delete_key = req.getParameter("delete_key");
		String image = req.getParameter("image");
 
		
		if(name.length()==0){
			name="������";
		}
		
		//�o�C�g���𒴂��Ă��Ȃ����̃`�F�b�N-----------
		boolean isError = CheckBytes.check(name,text);
		if(isError){
			res.sendRedirect("/testbb/conbyteserror.html");
			return;
		}
		//-------------------------------------------
		
		
		CB.setThreadNo(threadNo);
		CB.setContentNo(contentNo);
		CB.setName(name);
		CB.setText(text);
		
		We.execute(CB);
		
		//�������񂾃X���b�h��\��----------------------------------------------------
		ReadExecuter RE=new ReadExecuter();
		ThreadBean tb = (ThreadBean) RE.execute(threadNo);
		
		req.setAttribute("tb",tb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/contents.jsp");
		dispatcher.forward(req,res);
		//-----------------------------------------------------------------------------
		
	}
}
