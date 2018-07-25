package pl.krzysiekstuglik.PhoneBook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.krzysiekstuglik.PhoneBook.models.forms.NumberForm;
import pl.krzysiekstuglik.PhoneBook.models.services.AuthServices;

@Controller
public class AuthController {

    final AuthServices authServices;

    @Autowired
    public AuthController(AuthServices authServices) {
        this.authServices = authServices;
    }

    @GetMapping("/addNumber")
    public String addNumber(Model model){
        model.addAttribute("numberForm", new NumberForm());
        return "addNumber";
    }

    @PostMapping("/addNumber")
    public String addNumber(@ModelAttribute("numberForm") NumberForm numberForm,
                            Model model){
        if (!authServices.tryToAddNumber(numberForm)){
            model.addAttribute("info", "Podany numer jest już w książce telefonicznej!!!");
            return "addNumber";
        }
        return "redirect:/";

    }

}