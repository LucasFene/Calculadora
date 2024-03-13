package com.lucas.calculadora.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {

	@GetMapping("/")
	public ModelAndView calculator() {
		ModelAndView mvc = new ModelAndView();
		mvc.setViewName("calculadora");
		return mvc;
	}
	
	
    @PostMapping("/calculadora")
    public String converterTemperatura(@RequestParam("num1") double num1,
                                     @RequestParam("sinal") String sinal,
                                     @RequestParam("para") String para,
                                     Model model) {
        double result = 0.0;
        
        if (sinal.equals("Kelvin") && para.equals("Celsius")) {
            result = num1 - 273.15;
        } 
        else if (para.equals("Kelvin") && sinal.equals("Celsius")) {
            result = num1 + 273.15;
        } 
        
        else if (para.equals("Fahrenheit") && sinal.equals("Celsius")) {
            result = (num1 * 9/5) + 32;
        } 
        
        else if (sinal.equals("Fahrenheit") && para.equals("Celsius")) {
            result = (num1 - 32) * 5/9;
        } 
        
        else if (para.equals("Kelvin") && sinal.equals("Fahrenheit")) {
            result = (num1 - 32) * 5/9 + 273.15;
        } 
        
        else if (sinal.equals("Kelvin") && para.equals("Fahrenheit")) {
            result = (num1 - 273.15) * 9/5 + 32;
        } else {
           
            model.addAttribute("result", "Unidades de temperatura inválidas");
            return "calculadora";
            
        }

        model.addAttribute("result", result);
        return "calculadora";
    }
}
