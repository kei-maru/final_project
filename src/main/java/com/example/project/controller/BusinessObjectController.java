package com.example.project.controller;

import com.example.project.model.BusinessObject;
import com.example.project.service.BusinessObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BusinessObjectController {
    @Autowired
    private BusinessObjectService service;

    @GetMapping("/objects")
    public String list(Model model) {
        model.addAttribute("objects", service.findAll());
        return "objectList";
    }

    @GetMapping("/object/new")
    public String createForm(Model model) {
        model.addAttribute("object", new BusinessObject());
        return "objectForm";
    }

    @PostMapping("/object")
    public String save(@ModelAttribute BusinessObject obj) {
        service.save(obj);
        return "redirect:/objects";
    }

    @GetMapping("/object/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("object", service.findById(id));
        return "objectForm";
    }

    @PostMapping("/object/update")
    public String update(@ModelAttribute BusinessObject obj) {
        service.update(obj);
        return "redirect:/objects";
    }

    @GetMapping("/object/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/objects";
    }
}
