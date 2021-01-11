package com.jun.project.controller;

import com.jun.project.process.TargetURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/youtube")
public class SendToYoutube {

    @Autowired
    private TargetURL targetURL;

    @GetMapping("/go")
    public String sendToYoutube() {
        return "redirect:" + targetURL.getUrl();
    }

    @GetMapping("/conference")
    public String sendToYoutube2() {
        return "redirect:" + targetURL.getConferUrl();
    }

    @GetMapping("/set")
    public String setURL() {
        return "/setURL.html";
    }

    @PostMapping("/set")
    public String ok(@RequestParam(value = "url", required = false) String url,
                     @RequestParam(value = "conferUrl", required =false) String conferUrl) {
        if (!"".equals(url)) {
            System.out.println(url);
            targetURL.setUrl(url);
        }

        if (!"".equals(conferUrl)) {
            System.out.println(conferUrl);
            targetURL.setConferUrl(conferUrl);
        }
        return "redirect:/ok.html";
    }
}
