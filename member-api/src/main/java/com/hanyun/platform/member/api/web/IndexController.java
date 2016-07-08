package com.hanyun.platform.member.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hanyun.platform.member.api.domain.UserInfo;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
	
	@RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
		System.out.println("=======================================");
        UserInfo user=new UserInfo("wxId", "15237571216", "xiaoming", 0);
        return new ModelAndView("welcome","user",user);
    }
	
	@RequestMapping(value = "/hello")
    public String hello() {
        System.out.println("--------------------------------------");
        return "hello";
    }
	
	@RequestMapping(value = "/jsonString", method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
    public UserInfo json(@RequestParam("param")String param) {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++" + param );
        return new UserInfo("wxId", "15237571216", "xiaoming", 0);
    }
	
	

}
