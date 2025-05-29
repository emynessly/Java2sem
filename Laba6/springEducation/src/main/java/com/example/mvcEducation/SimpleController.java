package com.example.mvcEducation;

import com.example.springEducation.Bow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {
    @Autowired
    @Qualifier("bow")
    Bow bow;

    @GetMapping("/simple")
    public String showForm(Model model)
    {
        model.addAttribute("arrows", bow.getArrows());
        model.addAttribute("range", bow.getRange());
        model.addAttribute("damage", bow.getDamage());
        model.addAttribute("critdamage", bow.getCritdamage());
        return "simple";
    }
}