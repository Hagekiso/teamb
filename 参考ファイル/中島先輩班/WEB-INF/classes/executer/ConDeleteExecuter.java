package executer;

import dba.Accessor;
import bean.*;

public class ConDeleteExecuter extends Executer{
	
	
	public Object execute(Object cb){
		
		ContentsBean CB = (ContentsBean)cb;
		
		Accessor accessor=new Accessor();
		accessor.connect();
		//�܂��X���b�h�̒��g���폜
		String sql1="UPDATE contents SET con_name='�Ǘ���',con_text='�폜����܂���',con_date=SYSDATE WHERE con_no="+CB.getContentNo()+" AND th_no="+CB.getThreadNo();
		accessor.write(sql1);
		
		accessor.commit();
		accessor.close();
		return "�R���e���c���e���폜�����I";
		}
}