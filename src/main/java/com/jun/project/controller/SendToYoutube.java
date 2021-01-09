package com.jun.project.controller;

import com.jun.project.process.TargetURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/youtube")
public class SendToYoutube {

    @Autowired
    private TargetURL targetURL;

    @GetMapping("/go")
    public String sendToYoutube() {
        return "redirect:" + targetURL.getUrl();
    }

    @GetMapping("/set")
    public String setURL() {
        return "/setURL.html";
    }

    @PostMapping("/set")
    public String ok(@RequestParam(value = "url") String url) {
        targetURL.setUrl(url);
        System.out.println(url);
        return "/ok.html";
    }
}
