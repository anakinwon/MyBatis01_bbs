package com.spring.ormDAO;

import java.util.ArrayList;

import com.spring.ormVO.BVO;

public interface BDAO {
	// 회원 목록 조회하기
	public ArrayList<BVO> list();

	// 회원 저장하기
	public void writeOk(String bname, String bContent);

	// 회원 삭제하기
	public void delete(String bId);
}
