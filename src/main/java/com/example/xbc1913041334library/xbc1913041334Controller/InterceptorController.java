package com.example.xbc1913041334library.xbc1913041334Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/interceptor")
public class InterceptorController {
	@RequestMapping("/start")
    public String start() {
    	System.out.println("执行处理器逻辑");
    	return "welcome.jsp";
    }
}
