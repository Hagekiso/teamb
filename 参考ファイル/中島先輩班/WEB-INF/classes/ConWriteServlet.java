import executer.*;
import bean.*;
import check.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConWriteServlet extends HttpServlet{
	
	WriteExecuter We=new WriteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		ContentsBean CB=new ContentsBean();
		
		int threadNo = Integer.parseInt( req.getParameter("threadNo") );
		int contentNo = Integer.parseInt( req.getParameter("contentNo") );
		String name=req.getParameter("name");
		String text=req.getParameter("text");
		
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
