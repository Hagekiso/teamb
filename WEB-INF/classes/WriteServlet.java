import executer.*;
import bean.*;
import check.*;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		Part part = req.getPart("image");
		
		String contentDisposition = part.getHeader("content-disposition");
		String contentType = part.getHeader("content-type");
		
		long size = 0;
		
		try{
			size = part.getSize();
			// upload�t�H���_�̐�΃p�X�𒲂ׂ�
		String path = getServletContext().getRealPath("upload");

		/* �A�b�v���[�h�����t�@�C�����̎擾 */
		// �ϐ�contentDisposition����"filename="�ȍ~�𔲂��o��
		int filenamePosition = contentDisposition.indexOf("filename=");
		String filename = contentDisposition.substring(filenamePosition);
		// "filename="��"������
		filename = filename.replace("filename=", "");
		filename = filename.replace("\"", "");
		// ��΃p�X����t�@�C�����̂ݎ��o��
		filename = new File(filename).getName();

		boolean isJpegFile = false;
		// JPEG�`���̃`�F�b�N
		if ((contentType.equals("image/jpeg"))
				|| (contentType.equals("image/pjpeg"))) {
			// �摜�t�@�C����path+filename�Ƃ��ĕۑ�
			part.write(path + "/" + filename);
			isJpegFile = true;
			
			// �T���l�[���摜�̍쐬
			createThumbnail(path + "/" + filename, path + "/small/" + filename, 120);
		}

		}catch(NullPointerException e){System.out.println("�摜�Ȃ�");}
		System.out.println(size+"byte");

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
		
		CheckReplace cr = new CheckReplace();
		CB = cr.check(CB);
		
		We.execute(CB);
		
		int postNo = -1;
		ArrayList al = (ArrayList) RE.execute(postNo);
		
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
