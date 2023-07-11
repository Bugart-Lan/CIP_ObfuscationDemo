package com.demo.obfuscationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ObfuscationDemoViewController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
        model.addAttribute("greeting", greeting);
        return "result";
    }
    @PostMapping("/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
//        user.setId(20);
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }
}
