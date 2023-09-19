package com.hadine;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public List<Map<String, Object>> boardList() {
		return boardDAO.boardList();
	}

	public Map<String, Object> detail(int bno) {
		return boardDAO.detail(bno);
	}

}
