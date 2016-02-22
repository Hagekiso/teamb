package executer;

import java.util.ArrayList;
import bean.Bean;
import dba.Accessor;
import bean.ThreadBean;
import bean.ContentsBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import check.*;

public class ThReadExecuter extends Executer{
	
	public Object execute(Object s){
		
		//�֋X��
		String str = (String)s;
		
		//DB�ɐڑ�
		accessor.connect();
		
		//�Ăяo�����ɕԂ��R���N�V�����ɃA�N�Z�X���邽�߂̃I�u�W�F�N�g
		ThreadBean _tb = new ThreadBean();
		
		//�X���b�h�ꗗ���擾----------------------------------------------------------------------
		String sql = "SELECT * FROM THREAD ORDER BY TH_NO DESC";
		try{
			ResultSet rs = accessor.read(sql);
			
			while(rs.next()){
				
				//�R���N�V�����Ɋi�[����1�X���b�h���Ƃ̃I�u�W�F�N�g
				ThreadBean tb = new ThreadBean();
				
				tb.setThreadNo(rs.getInt(1));
				System.out.println(rs.getInt(1));
				/*String title = rs.getString(2);
					title = CheckReplace.check(title);
					tb.setTitle(title);*/
				tb.setTitle(rs.getString(2));
				System.out.println(rs.getString(2));
				tb.setCategory(rs.getString(3));
				System.out.println(rs.getString(3));
				tb.setCount(rs.getInt(4));
				System.out.println(rs.getInt(4));
				
				//�R���N�V������1�X���b�h���Ƃ̃I�u�W�F�N�g���i�[
				_tb.setThreadList(tb);
			}
		//----------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("�������FSQLException");
		}
		//DB����ؒf
		accessor.close();
		
		return _tb.getThreadList();
	}
	
}