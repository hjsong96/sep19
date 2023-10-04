package com.hadine;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {

	List<Map<String, Object>> boardList(int pageNo);

	Map<String, Object> detail(int bno);

	int wirte(Map<String, Object> map);

	int delete(int bno);

	int update(Map<String, Object> map);

	List<Map<String, Object>> comment(int bno);

	int deletecomment(int cno);

	int writecomment(Map<String, String> map);

	int updatecomment(Map<String, Object> map);

	Map<String, Object> commentdetail(int cno);

	Map<String, Object> login(Map<String, Object> map);

}
