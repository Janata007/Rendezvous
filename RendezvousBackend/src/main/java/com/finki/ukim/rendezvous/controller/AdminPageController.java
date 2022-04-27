package com.finki.ukim.rendezvous.controller;

import com.finki.ukim.rendezvous.exceptions.UserNotFoundException;
import com.finki.ukim.rendezvous.model.Korisnik;
import com.finki.ukim.rendezvous.model.enums.AppUserRole;
import com.finki.ukim.rendezvous.service.KorisnikService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/adminPage")
public class AdminPageController {
    private final KorisnikService korisnikService;

    public AdminPageController(KorisnikService korisnikService) {
        this.korisnikService = korisnikService;
    }

    @GetMapping
    public String getAdminPage(Model model) {
        List<Korisnik> korisnici = this.korisnikService.findAll();
        model.addAttribute("korisnici", korisnici);
        model.addAttribute("bodyContent", "products");
        return "master-template";
    }

    @PostMapping("/delete/{id}")
    public String deleteKorisnik(@PathVariable long id) {
        this.korisnikService.deleteById(id);
        return "redirect:/adminPage";
    }
    @GetMapping("/addUser")
    public String goToAddKorisnik(){
        return "add-template";
    }

    @GetMapping("/chat")
    public String goToChat(){
        return "index";
    }

    @PostMapping("/add")
    public String saveUser(
        @RequestParam(required = false) Long id,
        @RequestParam String name,
        @RequestParam String surname,
        @RequestParam String username,
        @RequestParam String password) {
        if (id != null) {
            Korisnik k = this.korisnikService.findById(id).orElseThrow(() -> new UserNotFoundException(id));
            this.korisnikService.edit(id, k);
        } else {
            Korisnik k = new Korisnik(name, surname, username, password, AppUserRole.ADMIN);
            this.korisnikService.save(k);
        }
        return "redirect:/adminPage";
    }

}
