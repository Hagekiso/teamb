package executer;

import check.*;

import java.util.ArrayList;
import bean.Bean;
import dba.Accessor;
import bean.ThreadBean;
import bean.ContentsBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ThWriteExecuter extends Executer{
	
	public Object execute(Object bean){
		accessor.connect();
		
		int ThCount=0;

		String sql = "SELECT MAX( TH_NO ) FROM THREAD";
		
		try{
			ResultSet rs = accessor.read(sql);
			
			rs.next();
			ThCount = rs.getInt(1)+1;
		}
		catch(SQLException e){
			System.out.println("���ꂽ�āFSQLException");
		}
		
		ThreadBean tb = (ThreadBean)bean;
		
		//�V���O���N�H�[�g�u��
		tb = CheckReplace.check(tb);
		
		sql = "INSERT INTO Thread( TH_NO, TH_TITLE, TH_CATEGORY, TH_CON_COUNT) VALUES(";
		//sql = sql.concat("1, "�X���b�h�̃^�C�g��", '"+cb.getName()+"', SYSDATE, '"+cb.getText()+"' )");
		
		//Thread�\�ɓ��e���C���T�[�g�B
		sql = sql.concat(ThCount+",'"+tb.getTitle()+"','"+tb.getCategory()+"','"+0+"')");
		accessor.write(sql);

		//��L�̃X���b�h�ɏ��o�Z����B
		/* sql = "INSERT Contents (TH_NO,CON_NO,CON_NAME,CON_DATE,CON_TEXT) VALUES(";
		sql = sql.concat(ThCount+",1,'"+cb.getName()+"',sysdate,'"+cb.getText()+"')");
		accessor.write(sql);
		*/	
	
		accessor.close();
		
		return ThCount;
		
	}
}