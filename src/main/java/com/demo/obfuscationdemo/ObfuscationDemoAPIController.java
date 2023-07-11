package com.demo.obfuscationdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ObfuscationDemoAPIController {

    @Autowired
    protected UserRepository userRepository;
    @GetMapping("/json")
    public Map<String, String> getJSONObject() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        return map;
    }

    @PostMapping("/add_user")
    public String addNewUser(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "Saved";
    }

    @GetMapping("/all_user")
    public Iterable<User> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user.getName());
        }
        return users;
    }
}
