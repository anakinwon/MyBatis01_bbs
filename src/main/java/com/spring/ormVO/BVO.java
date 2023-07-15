package com.spring.ormVO;

public class BVO {
	private int bId;
	private String bName;
	private String bContent;
	
	// 기본 생성자
	public BVO(){
	}
	
	// 매개변수 생성자
	public BVO(int bId, String bName, String bContent){
		this.bId = bId;
		this.bName = bName;
		this.bContent = bContent;
	}
	
	//getter, setter
	public int getbId() {		return bId;	}
	public void setbId(int bId) {		this.bId = bId;	}
	public String getbName() {		return bName;	}
	public void setbName(String bName) {		this.bName = bName;	}
	public String getbContent() {		return bContent;	}
	public void setbContent(String bContent) {		this.bContent = bContent;	}
	
}
