package com.hadine;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BoradController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board() {
		List<Map<String, Object>> list = boardService.boardList();
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list", arr);
		return json.toString();
		
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam("bno") int bno) {
		System.out.println(bno);
		Map<String, Object> detail = boardService.detail(bno);
		JSONObject json = new JSONObject(detail);
		System.out.println(json.toString());
		
		return json.toString();
	}
	
}
