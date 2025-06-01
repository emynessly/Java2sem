package com.example.mvcEducation;

import com.example.springEducation.Bow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/calc")
    public String calculations(Model model,
                             @RequestParam("arrows") String arrows,
                             @RequestParam("damage") String damage){
        int Arrows = Integer.valueOf(arrows);
        int Damage = Integer.valueOf(damage);
        int CritDamage = Damage * 2;
        int TotalDMG = Damage * Arrows;
        int TotalCritDMG = CritDamage * Arrows;

        model.addAttribute("Arrows", Arrows);
        model.addAttribute("Damage", Damage);
        model.addAttribute("CritDamage", CritDamage);
        model.addAttribute("TotalDMG", TotalDMG);
        model.addAttribute("TotalCritDMG", TotalCritDMG);

        return "calc";
    }
}