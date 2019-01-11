package io.biuteifo.web.controller.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.biuteifo.web.controller.CommonController;
import io.biuteifo.web.dto.RequestData;
import io.biuteifo.web.dto.ResponseData;

/**
 * RESTful 接口示例
 * 
 * @author <a href="mailto:632635114@qq.com">luojun</a>
 * @date 2019年1月11日
 * @version 0.0.1
 */
@Controller
@RequestMapping("/page")
public class PageDemoController extends CommonController {

	/** http://localhost:8081/page/get/Demo */
	@GetMapping(value = "/get/{name}")
	public String get(@PathVariable("name") String name, Model model) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		model.addAllAttributes(data);
		return "demo/getPage";
	}

	/** http://localhost:8081/page/getPrm/Demo?value=hahha */
	@GetMapping(value = "/getPrm/{name}")
	public String get(@PathVariable("name") String name, @RequestParam("value") String value, Model model) {
		Map<String, String> data = new HashMap<String, String>();
		data.put("name", name);
		data.put("value", value);
		model.addAllAttributes(data);
		return "demo/getPage";
	}

	/**
	 * http://localhost:8081/page/post/Demo<br>
	 * {"id":"125"}
	 */
	@PostMapping(value = "/post/{name}")
	@ResponseBody
	public ResponseData post(@PathVariable("name") String name, @RequestBody Map<String, String> body) {
		try {
			body.put("name", name);
			RequestData.notNull(body, "id");
			return new ResponseData(body);
		} catch (Exception e) {
			return new ResponseData(500, e.getMessage());
		}
	}

	/**
	 * http://localhost:8081/page/post/Demo<br>
	 * {"id":"125"}
	 */
	@PostMapping(value = "/postDto/{name}")
	@ResponseBody
	public ResponseData post(@PathVariable("name") String name, @RequestBody RequestData requestData) {
		try {
			Map<String, String> map = new HashMap<String, String>();
			RequestData.notNull(requestData, "id", "pathName");
			map.put("id", requestData.getId());
			map.put("pathName", name);
			map.put("name", requestData.getName());
			map.put("startDate", requestData.getStartDate());
			map.put("endData", requestData.getEndData());
			map.put("pageIndex", requestData.getPageIndex());
			map.put("pageSize", requestData.getPageSize());
			return new ResponseData(map);
		} catch (Exception e) {
			return new ResponseData(500, e.getMessage());
		}
	}
}