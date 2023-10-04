package com.hadine;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	public List<Map<String, Object>> boardList(int pageNo) {
		pageNo = (pageNo - 1) * 10;
		return boardDAO.boardList(pageNo);
	}

	public Map<String, Object> detail(int bno) {
		return boardDAO.detail(bno);
	}

	public int wirte(Map<String, Object> map) {
		map.put("bip", "172.30.1.1");
		map.put("m_id", "timolover");
		return boardDAO.wirte(map);
	}

	public int delete(int bno) {
		return boardDAO.delete(bno);
	}

	public int update(Map<String, Object> map) {
		return boardDAO.update(map);
	}

	public List<Map<String, Object>> comment(int bno) {
		return boardDAO.comment(bno);
	}

	public int deletecomment(int cno) {
		return boardDAO.deletecomment(cno);
	}

	public int writecomment(Map<String, String> map) {
		map.put("m_id", "timolover");
		return boardDAO.writecomment(map);
	}

	public int updatecomment(Map<String, Object> map) {
		return boardDAO.updatecomment(map);
	}

	public Map<String, Object> commentdetail(int cno) {
		return boardDAO.commentdetail(cno);
	}

	public Map<String, Object> login(Map<String, Object> map) {
		return boardDAO.login(map);
	}

}
