package bean;

public class ContentsBean implements Bean{
	
	private int threadNo;
	private int contentNo;
	private String name;
	private String date;
	private String text;
	
	
//---------<Zb^[>-----------------------------------
	
	//XbhNO
	public void setThreadNo(int threadNo){
		this.threadNo = threadNo;
	}
	//RecNO
	public void setContentNo(int contentNo){
		this.contentNo = contentNo;	
	}
	//eÒ¼
	public void setName(String name){
		this.name = name;
	}
	//eú
	public void setDate(String date){
		this.date = date;
	}
	//eàe
	public void setText(String text){
		this.text = text;
	}

//----------------------------------------------------


//----------<Qb^[>----------------------------------

	//XbhNO
	public int getThreadNo(){
		return threadNo;
	}
	//RecNO
	public int getContentNo(){
		return contentNo;
	}
	//eÒ¼
	public String getName(){
		return name;
	}
	//eú
	public String getDate(){
		return date;
	}
	//eàe
	public String getText(){
		return text;
	}

//----------------------------------------------------

}