package com.kh2mp.hashing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {
    @Autowired
    private HashService hashService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam("password") String password, @RequestParam("salt") String salt, Model model)
            throws Exception {
        String md5 = hashService.hash(password, "MD5", null);
        String md5_sha256 = hashService.hash(md5, "SHA-256", null);
        String md5_salt = hashService.hash(password, "MD5", salt);

        model.addAttribute("md5", md5);
        model.addAttribute("md5_sha256", md5_sha256);
        model.addAttribute("md5_salt", md5_salt);
        model.addAttribute("rawPassword", password);
        model.addAttribute("rawSalt", salt);
        return "index";
    }
}