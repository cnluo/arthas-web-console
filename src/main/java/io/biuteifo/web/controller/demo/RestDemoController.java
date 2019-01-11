package io.biuteifo.web.controller.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.biuteifo.web.controller.CommonController;
import io.biuteifo.web.dto.ResponseData;

/**
 * 页面控制 示例
 * 
 * @author <a href="mailto:632635114@qq.com">luojun</a>
 * @date 2019年1月11日
 * @version 0.0.1
 */
@RestController
@RequestMapping("/rest")
public class RestDemoController extends CommonController {

	/** http://localhost:8081/rest/get/%E5%BC%A0%E4%B8%89 */
	@GetMapping(value = "/get/{path}")
	@ResponseBody
	public ResponseData get(@PathVariable("path") String path) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("path", path);
		return new ResponseData(data);
	}

	/** http://localhost:8081/rest/getReqPrm/%E5%BC%A0%E4%B8%89?name=%E7%BD%91%E5%90%A7 */
	@GetMapping(value = "/getReqPrm/{path}")
	@ResponseBody
	public ResponseData getReqPrm(@PathVariable("path") String path, @RequestParam("name") String name) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("path", path);
		data.put("name", name);
		return new ResponseData(data);
	}

	/** http://localhost:8081/rest/post/1?name=asd */
	@PostMapping(value = "/post/{path}")
	@ResponseBody
	public ResponseData post(@PathVariable("path") String path, @RequestParam("name") String name) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("path", path);
		data.put("name", name);
		return new ResponseData(data);
	}

	/**
	 * http://localhost:8081/rest/postBody/1 <br>
	 * {"name":"aaa"}
	 */
	@PostMapping(value = "/postBody/{path}")
	@ResponseBody
	public ResponseData postBody(@PathVariable("path") String path, @RequestBody Map<?, ?> body) {
		return new ResponseData("1".equals(path) ? 500 : 200, path, body);
	}
}