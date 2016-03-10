import executer.*;
import bean.*;
import check.*;

import java.util.ArrayList;

import java.io.IOException;
import java.io.File;
import java.awt.image.BufferedImage;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import javax.imageio.ImageIO;
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
		
		// ContentBean�Ɋi�[������̏���
		String user_name = req.getParameter("user_name");
		String email_address = req.getParameter("email_address");
		String message = req.getParameter("message");
		String delete_key = req.getParameter("delete_key");
		String image = "";
		Part part = req.getPart("image");
		
		try{
			String contentDisposition = part.getHeader("content-disposition");
			String contentType = part.getHeader("content-type");
			
			long size = part.getSize();
			System.out.println("�摜�T�C�Y�F"+size);
			
			/* �A�b�v���[�h�����t�@�C�����̎擾 */
			// �ϐ�contentDisposition����"filename="�ȍ~�𔲂��o��
			int filenamePosition = contentDisposition.indexOf("filename=");
			String filename = contentDisposition.substring(filenamePosition);
			// "filename="��"������
			filename = filename.replace("filename=", "");
			filename = filename.replace("\"", "");
			// ��΃p�X����t�@�C�����̂ݎ��o��
			filename = new File(filename).getName();
			
			if ((contentType.equals("image/jpeg"))
				|| (contentType.equals("image/pjpeg"))) {// JPEG�`���̃`�F�b�N
				// �摜�t�@�C�����w��p�X�ɕۑ�
				part.write("c:\\teamb\\images/" + filename);
				// �f�[�^�x�[�X�ɓ����u�摜�t�@�C���̖��O�v��ݒ�
				image = filename;
				// 117�s�ڂ���̃��\�b�h�ŃT���l�C�����쐬
				createThumbnail("c:\\teamb\\images/"+ filename,"c:\\teamb\\images\\small/" + filename, 120);
					
			}else if ((contentType.equals("image/png"))) {// PNG�`���̃`�F�b�N
				// �摜�t�@�C�����w��p�X�ɕۑ�
				part.write("c:\\teamb\\images/" + filename);
				// �f�[�^�x�[�X�ɓ����u�摜�t�@�C���̖��O�v��ݒ�
				image = filename;
				// 117�s�ڂ���̃��\�b�h�ŃT���l�C�����쐬
				createThumbnail("c:\\teamb\\images/"+ filename,"c:\\teamb\\images\\small/" + filename, 120);
					
			}else{
				System.out.println("�Ή��`���ł͂Ȃ��̂ŕۑ��s��");
			}
			
		}catch(NullPointerException e){
			System.out.println("�摜�Ȃ�");
		}
		
		if(user_name.length()==0){
			user_name="������";
		}
		if(delete_key.length()==0){
			delete_key=" ";
		}
		System.out.println(user_name+"����̓��e");//�e�X�g�p���b�Z�[�W
		//�o�C�g���𒴂��Ă��Ȃ����̃`�F�b�N-----------
		/*boolean isError = CheckBytes.check(name,text);
		if(isError){
			res.sendRedirect("/testbb/conbyteserror.html");
			return;
		}
		//-------------------------------------------
		*/
		// ContentBean�ɃR�����g�̏����i�[
		CB.setUser_name(user_name);
		CB.setEmail_address(email_address);
		CB.setMessage(message);
		CB.setDelete_key(delete_key);
		CB.setImage(image);
		// CheckReplace��check���\�b�h�ŁA�e�v�f����'������
		CheckReplace cr = new CheckReplace();
		CB = cr.check(CB);
		// WriteExecuter��execute���Ăяo���A�f���ɏ�������
		We.execute(CB);
		
		//�������񂾃X���b�h��\��----------------------------------------------------
		int postNo = 1;
		ArrayList al = (ArrayList) RE.execute(postNo);
		
		req.setAttribute("al",al);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/practice.jsp");
		dispatcher.forward(req,res);
		//-----------------------------------------------------------------------------
		
	}
	private void createThumbnail(String originFile, String thumbFile, int width) {
		try {
			// ���摜�̓ǂݍ���
			BufferedImage image = ImageIO.read(new File(originFile));
			// ���摜�̏����擾
			int originWidth = image.getWidth();
			int originHeight = image.getHeight();
			int type = image.getType();
			// �k���摜�̍������v�Z
			int height = originHeight * width / originWidth;
			
			//�k���摜�̍쐬
			BufferedImage smallImage = new BufferedImage(width, height, type);
			Graphics2D g2 = smallImage.createGraphics();
			
			// �`��A���S���Y���̐ݒ�(�i���D��A�A���`�G�C���A�XON)
			g2.setRenderingHint(RenderingHints.KEY_RENDERING,  RenderingHints.VALUE_RENDER_DEFAULT);
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON);

			// ���摜�̏k��&�ۑ�
			g2.drawImage(image, 0, 0, width, height, null);
			ImageIO.write(smallImage, "jpeg", new File(thumbFile));
		} catch (Exception e) {
			log("�摜�̏k���Ɏ��s: " + e);
		}
	}
}
