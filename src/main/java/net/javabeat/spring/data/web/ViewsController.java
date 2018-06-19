package net.javabeat.spring.data.web;

import java.util.List;

import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import aspects.*;

@Controller
@RequestMapping
public class ViewsController {
    @RequestMapping(value="/index", method=RequestMethod.GET)
    public String home(){
        return "index";
    }

    @RequestMapping(value="/login", method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String register(){
        return "register";
    	
    }
    public @ResponseBody void test() {
    }
    
    @RequestMapping(value="/statistic", method=RequestMethod.GET)
    public String statistic(){
    	String json = new Gson().toJson(StatisticRepository.getList());
    	return json;
    	
    }
    
//    @RequestMapping(value="/register", method=RequestMethod.GET)
//    public ModelAndView company() {
//        return new ModelAndView("register");
//    }
}


