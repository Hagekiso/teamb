package executer;

import dba.Accessor;


public class ThDeleteExecuter extends Executer{
	
	
	public Object execute(Object tn){
		
		int threNo = (int)tn;
		
		Accessor accessor=new Accessor();
		accessor.connect();
		//�܂��X���b�h�̒��g���폜
		String sql1="DELETE contents WHERE th_no="+threNo;
		accessor.write(sql1);
		
		//���ɃX���b�h���폜
		String sql2="DELETE thread WHERE th_no="+threNo;
		accessor.write(sql2);
		
		accessor.commit();
		accessor.close();
		return "�X���b�h�폜�����I";
		}
}