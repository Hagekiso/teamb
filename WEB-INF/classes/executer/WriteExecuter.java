package executer;

import java.util.ArrayList;
import bean.*;
import dba.Accessor;
//import bean.ThreadBean;
import bean.ContentBean;
//���Ԃ���������check�N���X�����
// import check.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WriteExecuter extends Executer{
	
	public Object execute(Object bean){
		accessor.connect();
		
		ContentBean cb = (ContentBean)bean;
		
		//�V���O���N�H�[�g�u��
		//cb = CheckReplace.check(cb);
		
		String sql = "INSERT INTO Contents( post_number, user_name, email_address, message, delete_key,delete_flag,image,post_date) VALUES(";
		//sql = sql.concat("1, 0, '"+cb.getName()+"', SYSDATE, '"+cb.getText()+"' )");
		
		//Contents�\�ɓ��e���C���T�[�g�BCON_NO�i�R���e���c�̒ʂ��ԍ��j�͂��̃X���b�h�̃R���e���c��+1���i�[�B
		sql = sql.concat("postno.nextval,"+cb.getUser_name()+","+cb.getEmail_address()+","+cb.getMessage()+","+cb.getDelete_key()+","+cb.getDelete_flag()+","+cb.getImage()+", SYSDATE, )");
		accessor.write(sql);

		//Thread�\��TH_CON_COUNT�i���̃X���b�h�̃R���e���c���j��+1���ăA�b�v�f�[�g�B
		//sql = "UPDATE thread SET th_con_count = (SELECT th_con_count+1 FROM thread WHERE th_no = "+cb.getThreadNo()+") WHERE th_no = "+cb.getThreadNo();
		//accessor.write(sql);
		
		accessor.close();
		
		String str = "�������ݐ���";
		return str;
		
	}
}