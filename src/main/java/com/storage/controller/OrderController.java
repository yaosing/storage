package com.storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.storage.annotation.RestApi;

@Controller
@RequestMapping("/order")
public class OrderController {

	@RestApi
	@RequestMapping("/test")
	public String test() throws Exception {
		return "ok";
	}
}
