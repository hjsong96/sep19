package com.hadine;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface BoardDAO {

	List<Map<String, Object>> boardList();

	Map<String, Object> detail(int bno);

	int wirte(Map<String, Object> map);

}
