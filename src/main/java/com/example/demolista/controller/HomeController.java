package com.example.demolista.controller;

import com.example.demolista.form.CityForm;
import com.example.demolista.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    final CityService cityService;

    @Autowired
    public HomeController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("codes", cityService.getCities());

        return "index";
    }


    @PostMapping("/")
    public String  send(@ModelAttribute CityForm cityForm, Model model){
       cityService.saveCity(cityForm);
        model.addAttribute("cities", cityService.getCities());

        return "index";
    }



}
