package com.hadine;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class BoradController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(@RequestParam(name = "pageNo", required = false, defaultValue = "1") int pageNo) {
		System.out.println(pageNo);
		List<Map<String, Object>> list = boardService.boardList(pageNo);
		System.out.println(list);
		JSONObject json = new JSONObject();
		JSONArray arr = new JSONArray(list);
		json.put("list", arr);
		json.put("pageNo", pageNo);
		json.put("totalcount", list.get(0).get("totalcount"));
		return json.toString();
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam(name="bno", required = true) int bno) {
		Map<String, Object> detail = boardService.detail(bno);
		List<Map<String, Object>> comment = boardService.comment(bno);
		//System.out.println(comment);
		JSONObject json = new JSONObject();
		json.put("detail", detail);
		json.put("comment", comment);
		
		return json.toString();
	}
	
	@PostMapping("/write")
	public String wirte(@RequestBody Map<String, Object> map) {
		int result = boardService.wirte(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@PostMapping("writecomment")
	public String writecomment(@RequestBody Map<String, String> map) {
		//System.out.println(map);
		int result = boardService.writecomment(map);
		//System.out.println(result);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	//2023-09-21 클라우드 응용 서비스 개발
	@PostMapping("/delete")
	public String delete(@RequestParam(name="bno", required = true) int bno) {
		//System.out.println(bno);
		int result = boardService.delete(bno);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@PostMapping("/deletecomment")
	public String deletecomment(@RequestParam(name="cno", required = true) int cno) {
		int result = boardService.deletecomment(cno);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	
	@PatchMapping("/update")
	public String update(@RequestBody Map<String, Object> map) {
		//System.out.println(map);
		int result = boardService.update(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
		
	}
	
	@PatchMapping("/updatecomment")
	public String updatecomment(@RequestBody Map<String, Object> map) {
		//System.out.println(map);
		int result = boardService.updatecomment(map);
		JSONObject json = new JSONObject();
		json.put("result", result);
		return json.toString();
	}
	
	@GetMapping("/commentdetail")
	public String commentdetail(@RequestParam(name="cno", required = true) int cno) {
		System.out.println(cno);
		Map<String, Object> comment = boardService.commentdetail(cno);
		JSONObject json = new JSONObject();
		json.put("comment", comment);
		return json.toString();
	}
	
}
