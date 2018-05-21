package grapecity.controller;

import grapecity.model.msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hello on 2018/5/18.
 */
@Controller
public class index {

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @Autowired
    msg m;

    @PostMapping("/login")
    public String chat(@RequestParam("username") String username) {
       // System.out.println(username);
        m.username=username;
        return "redirect:/chat";
    }

    @GetMapping("/chat")
    public String chat(Model model)
    {
        model.addAttribute("username", m.username);
        return "/chat";
    }
}
