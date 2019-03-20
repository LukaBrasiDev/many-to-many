package com.example.demolista.controller;

import com.example.demolista.form.CityForm;
import com.example.demolista.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    final CityService cityService;

    @Autowired
    public HomeController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("cities", cityService.getCities());
        model.addAttribute("codes", cityService.getCities());

        return "index";
    }


    @PostMapping("/")
    public String send(@ModelAttribute CityForm cityForm, Model model) {
        cityService.saveCity(cityForm);
        model.addAttribute("cities", cityService.getCities());

        return "index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id,
                       Model model) {
        model.addAttribute("city", cityService.getCityById(id));
        model.addAttribute("cityForm", new CityForm());
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String updateCity(
            @PathVariable Long id,
            @ModelAttribute CityForm cityForm, Model model) {
        cityService.updateCity(id, cityForm);
        model.addAttribute("city", cityService.getCityById(id));

        return "edit";

    }


}
