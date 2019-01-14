package io.biuteifo.web.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.biuteifo.web.controller.CommonController;
import io.biuteifo.web.dto.user.LoginInfoDTO;

@Controller
@RequestMapping("/user")
public class UserController extends CommonController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@PostMapping("/login")
	public String login(LoginInfoDTO requestData) {
		logger.debug("登录请求：{}", requestData);
		if ("admin".equals(requestData.getUserName())) {
			return "index";
		}
		return "redirect:/page/login.html";
	}

	@GetMapping("index")
	public String index() {
		return "index";
	}
}
