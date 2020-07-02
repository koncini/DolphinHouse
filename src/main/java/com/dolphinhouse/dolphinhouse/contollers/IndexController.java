package com.dolphinhouse.dolphinhouse.contollers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Value("${text.indexcontroller.index.title}")
    private String indexText;

    @RequestMapping({"/index", "", "/"})
    public String index(Model model) {
        model.addAttribute("title", indexText);
        return "index";
    }

}
