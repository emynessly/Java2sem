package com.example.mvcEducation;

import com.example.DAO.WeaponDAO;
import com.example.springEducation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/weapons")
public class WeaponController {
    private final WeaponDAO weaponDAO;

    @Autowired
    public WeaponController(WeaponDAO weaponDAO) {
        this.weaponDAO = weaponDAO;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("weapons", weaponDAO.index());
        return "weapons/index";
    }

    @GetMapping("/{name}")
    public String show(@PathVariable("name") String name, Model model)
    {
        model.addAttribute("weapon", weaponDAO.show(name));
        return "weapons/show";
    }

    @GetMapping("/axe")
    public String getAxeForm(Model model)
    {
        model.addAttribute("axe", new Axe());
        return "axe/form";
    }
    @PostMapping("/axe")
    public String create(@ModelAttribute("axe") Axe axe)
    {
        weaponDAO.save(axe);
        return "redirect:/weapons";
    }

    @GetMapping("/bow")
    public String getBowForm(Model model)
    {
        model.addAttribute("bow", new Bow());
        return "bow/form";
    }
    @PostMapping("/bow")
    public String create(@ModelAttribute("bow") Bow bow)
    {
        weaponDAO.save(bow);
        return "redirect:/weapons";
    }

    @GetMapping("/pickaxe")
    public String getPickaxeForm(Model model)
    {
        model.addAttribute("pickaxe", new Pickaxe());
        return "pickaxe/form";
    }
    @PostMapping("/pickaxe")
    public String create(@ModelAttribute("pickaxe") Pickaxe pickaxe)
    {
        weaponDAO.save(pickaxe);
        return "redirect:/weapons";
    }

    @GetMapping("/sword")
    public String getSwordForm(Model model)
    {
        model.addAttribute("sword", new Sword());
        return "sword/form";
    }
    @PostMapping("/sword")
    public String create(@ModelAttribute("sword") Sword sword)
    {
        weaponDAO.save(sword);
        return "redirect:/weapons";
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String name)
    {
        Weapon tmp = weaponDAO.getObject(name);
        if (tmp != null)
            weaponDAO.remove(tmp);
        return "redirect:/weapons";
    }

    @GetMapping("/update/{name}")
    public String getUpdateForm(@PathVariable("name") String name, Model model)
    {
        Weapon tmp = weaponDAO.getObject(name);
        if (tmp != null) {
            switch (tmp) {
                case Axe axe -> {
                    model.addAttribute("axe", tmp);
                    return "axe/updateForm";
                }
                case Bow bow -> {
                    model.addAttribute("bow", tmp);
                    return "bow/updateForm";
                }
                case Pickaxe pickaxe -> {
                    model.addAttribute("pickaxe", tmp);
                    return "pickaxe/updateForm";
                }
                case Sword sword -> {
                    model.addAttribute("sword", tmp);
                    return "pickaxe/updateForm";
                }
                default -> {
                }
            }
        }
        return "redirect:/weapons";
    }

    @PatchMapping("/update/axe/{name}")
    public String updateAxe(
                @PathVariable String name,
                @ModelAttribute Axe weapon){        // Используем конкретный класс
        Weapon tmp = weaponDAO.getObject(name);
        weaponDAO.update(tmp, weapon);
        return "redirect:/weapons";
    }
    @PatchMapping("/update/bow/{name}")
    public String updateBow(
            @PathVariable String name,
            @ModelAttribute Bow weapon) {
        Weapon tmp = weaponDAO.getObject(name);
        weaponDAO.update(tmp, weapon);
        return "redirect:/weapons";
    }
    @PatchMapping("/update/pickaxe/{name}")
    public String updatePickaxe(
            @PathVariable String name,
            @ModelAttribute Pickaxe weapon) {
        Weapon tmp = weaponDAO.getObject(name);
        weaponDAO.update(tmp, weapon);
        return "redirect:/weapons";
    }
    @PatchMapping("/update/sword/{name}")
    public String updateSword(
            @PathVariable String name,
            @ModelAttribute Sword weapon) {
        Weapon tmp = weaponDAO.getObject(name);
        weaponDAO.update(tmp, weapon);
        return "redirect:/weapons";
    }
}