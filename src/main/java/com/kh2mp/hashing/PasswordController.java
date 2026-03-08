package com.kh2mp.hashing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {
    @Autowired private HashService hashService;

    @GetMapping("/")
    public String index() { return "index"; }

    @PostMapping("/calculate")
    public String calculate(@RequestParam String password, @RequestParam String salt, Model model) throws Exception {
        model.addAttribute("md5", hashService.hash(password, "MD5", null));
        model.addAttribute("sha256", hashService.hash(password, "SHA-256", salt));
        return "index";
    }
}