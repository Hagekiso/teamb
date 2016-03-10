import executer.*;

import bean.*;
import check.*;

import java.util.ArrayList;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteServlet extends HttpServlet{
	DeleteExecuter DE=new DeleteExecuter();
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)
	throws IOException,ServletException{		
		req.setCharacterEncoding("Windows-31J");
		
		String p = req.getParameter("post_number");
		String d = req.getParameter("delete_key");
		if(d.length()==0){
			d=" ";
		}
		
		DeleteBean db = new DeleteBean();
		//DeleteBean�Ɋe���͍��ڂ���
		try{
			db.setPost_number(Integer.parseInt(p));
		}catch(NumberFormatException e){
			db.setPost_number(0);
		}
		db.setDelete_key(d);
		//�폜�p�X�� ' �� '' �ɕϊ�����
		CheckReplace cr = new CheckReplace();
		db = cr.check(db);
		//DeleteExecuter��execute���Ăяo���A�R�����g�̍폜�����݂�B���ʂ�Boolean�ŕԂ����
		Boolean b = (Boolean) DE.execute(db);
		
		String result;
		if(b){
			result="�������܂����B";
		}else{
			result="���s���܂����B";
		}
		System.out.println(result);//�e�X�g�p���b�Z�[�W
		
		req.setAttribute("result",result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/delete.jsp");
		dispatcher.forward(req,res);
		
	}
}