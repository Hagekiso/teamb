package bean;

import java.util.ArrayList;
	
public class ThreadBean implements Bean{
	
	private int threadNo;
	private String title;
	private String category;
	private int contentsCount;
	
	private ArrayList<ContentsBean> contentsList = new ArrayList<ContentsBean>();
	private ArrayList<ThreadBean> threadList = new ArrayList<ThreadBean>();


//-----------------<�Z�b�^�[>---------------------------------

	//�X���b�hNO
	public void setThreadNo(int threadNo){
		this.threadNo = threadNo;
	}
	//�X���b�h�^�C�g��
	public void setTitle(String title){
		this.title = title;
	}
	//�J�e�S��
	public void setCategory(String category){
		this.category = category;
	}
	//���e��
	public void setCount(int contentsCount){
		this.contentsCount = contentsCount;
	}
	//�X���b�h�̑S���f�[�^��ArrayList�ɃZ�b�g
	public void setContentsList(ContentsBean list){
		contentsList.add(list);
	}
	//�X���b�h�ꗗ��ArrayList�ɃZ�b�g
	public void setThreadList(ThreadBean list){
		threadList.add(list);
	}
//-----------------------------------------------------------

//-----------------<�Q�b�^�[>---------------------------------

	//�X���b�hNO
	public int getThreadNo(){
		return threadNo;
	}
	//�X���b�h�^�C�g��
	public String getTitle(){
		return title;
	}
	//�J�e�S��
	public String getCategory(){
		return category;
	}
	//���e��
	public int getContentsCount(){
		return contentsCount;
	}
	//�X���b�h�̑S���f�[�^��Ԃ�
	public ArrayList getContentsList(){
		return contentsList;
	}
	//�X���b�h�ꗗ��Ԃ�
	public ArrayList getThreadList(){
		return threadList;
	}
	
//-----------------------------------------------------------
}

