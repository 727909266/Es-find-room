package com.huhaoran.esproject.controller;

import com.huhaoran.esproject.vo.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.Math;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/get")
    @ResponseBody
    public ApiResponse get() {
        return ApiResponse.ofSuccess(null);
    }

}
