package executer;

import java.util.ArrayList;
import dba.Accessor;
import bean.ContentBean;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadExecuter extends Executer{
	
	public Object execute(Object o){
		
		Integer i = (Integer)o;
		
		//DB�ɐڑ�
		accessor.connect();
		
		ArrayList<ContentBean> al = new ArrayList<ContentBean>();
		int count = 0;
		//�R�����g�ꗗ���擾----------------------------------------------------------------------
		String sql = "SELECT * FROM Contents ORDER BY post_number DESC";
		try{
			ResultSet rs = accessor.read(sql);
			
			while(rs.next()){
				//�R���N�V�����Ɋi�[����1�R�����g���Ƃ̃I�u�W�F�N�g
				ContentBean tb = new ContentBean();
				
				tb.setPost_number(rs.getInt(1));
				System.out.print(rs.getInt(1));
				tb.setUser_name(rs.getString("User_name"));
				System.out.println(rs.getString("User_name"));
				tb.setEmail_address(rs.getString("Email_address"));
				//System.out.println(rs.getString("Email_address"));
				tb.setMessage(rs.getString(4));
				//System.out.println(rs.getString(4));
				tb.setDelete_flag(rs.getBoolean("Delete_flag"));
				//System.out.println(rs.getBoolean("Delete_flag"));
				tb.setImage(rs.getString("Image"));
				//System.out.println(rs.getString("Image"));
				tb.setDate(rs.getString("Post_date"));
				System.out.println(rs.getString("Post_date"));
				//�폜����Ă��Ȃ��R�����g�Ȃ�A�\�������R�����g�̐������Z
				if(!rs.getBoolean("Delete_flag")){
					count++;
				}
				//�R���N�V������1�R�����g���Ƃ̃I�u�W�F�N�g���i�[
				//�i�w�肳�ꂽ�͈͂̂P�O���̃R�����g�̂݁j
				if(count <= i*10 && count >= i*10 - 9){
					al.add(tb);
				}
			}
		//----------------------------------------------------------------------------------------------------
		
		}catch(SQLException e){
			System.out.println("�������FSQLException");
			System.out.println(e.getErrorCode());
		}
		//DB����ؒf
		accessor.close();
		
		return al;
	}
	
}