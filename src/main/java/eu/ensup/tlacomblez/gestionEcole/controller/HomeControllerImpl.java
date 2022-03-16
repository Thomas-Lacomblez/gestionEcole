package eu.ensup.tlacomblez.gestionEcole.controller;



import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import eu.ensup.tlacomblez.gestionEcole.domain.Directeur;
import eu.ensup.tlacomblez.gestionEcole.domain.Etudiant;
import eu.ensup.tlacomblez.gestionEcole.service.DirecteurService;
import eu.ensup.tlacomblez.gestionEcole.service.EtudiantService;
import lombok.extern.slf4j.Slf4j;



@Controller
@Slf4j
public class HomeControllerImpl implements HomeController {

    @Autowired
    DirecteurService directeurService;
    @Autowired
    EtudiantService etudiantService;

    @Override
    @GetMapping("/")
    public String viewHome() {
        return "home";
    }

    @Override
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/creationEtudiant")
    public String creationEtudiant(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "creationEtudiant";
    }
    @PostMapping("/perfom_creationEtudiant")
    public String creationEtudiantPost(@ModelAttribute Etudiant etudiant, Model model){
        etudiantService.creerEtudiant(etudiant);
        return "/etudiants";
    }
    /* */
    @GetMapping("/addDirecteurtmp")
    public String addDirecteurtmp() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode("123");
        Directeur directeur = new Directeur("Lacomblez", "Thomas", "Lacomblez.thomas@gmail.com", encodedPassword , "1 Sq. Benjamin Franklin, 78180", "0634779411", LocalDate.of(1999, 8, 22));
        
        directeurService.createDirecteur(directeur);
        log.info("Directeur créer ! ");
        return "home";
    }/**/
    /* */
    @GetMapping("/addEtudianttmp")
    public String addEtudianttmp() {
        Etudiant etudiant = new Etudiant("Lacomblez", "Thomas", "Lacomblez.thomas@gmail.com" , "1 Sq. Benjamin Franklin, 78180", "0634779411", LocalDate.of(1999, 8, 22));
        
        etudiantService.creerEtudiant(etudiant);
        log.info("Etudiant créer ! ");
        return "home";
    }/* */

    @GetMapping("/etudiants")
    public String listUsers(Model model) {
        List<Etudiant> listEtudiant = etudiantService.getAllEtudiant();
        model.addAttribute("listEtudiant", listEtudiant);
        
        return "etudiants";
    }

}