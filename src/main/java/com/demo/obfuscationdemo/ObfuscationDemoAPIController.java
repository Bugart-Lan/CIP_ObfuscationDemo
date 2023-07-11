package com.demo.obfuscationdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ObfuscationDemoAPIController {

    @GetMapping("/json")
    public Map<String, String> getJSONObject() {
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        return map;
    }
}
