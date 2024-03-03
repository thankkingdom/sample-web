package com.example.sampleweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import com.example.sampleweb.domain.entity.GreetingRequest;
import com.example.sampleweb.domain.util.JsonUtils;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView index(GreetingRequest params) {

        ModelAndView mav = new ModelAndView();
        mav.addObject("form", params);
        mav.addObject("checkbox1", createCheckboxItem());
        mav.setViewName("/greeting/index");
        return mav;
    }

    @PostMapping("/greeting")
    public ModelAndView greeting(GreetingRequest params, ModelAndView mav) {
        
        log.info(JsonUtils.encode(params));
        log.info(JsonUtils.encode(mav));
        mav.addObject("form", params);
        mav.addObject("checkbox1", createCheckboxItem());
        mav.setViewName("/greeting/index");
        return mav;
    }
    
    private Map<String, String> createCheckboxItem() {

        Map<String, String> m = new HashMap<>();
        m.put("1", "Hello!");
        m.put("2", "こんにちは！");
        m.put("3", "まいど！");
        return m;
    }
}
