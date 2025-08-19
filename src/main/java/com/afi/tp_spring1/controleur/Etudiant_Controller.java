package com.afi.tp_spring1.controleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.afi.tp_spring1.model.Etudiant;
import com.afi.tp_spring1.service.Etudiant_Service;

@Controller
public class Etudiant_Controller {
	@Autowired
	private Etudiant_Service es;
	@GetMapping("/")
	public String afficheWelcome() {
		return "welcome";
	}
	
	@GetMapping("/etudiantForm")
	public String afficheWelcome(Model model) {
		Etudiant etudiant = new Etudiant();
		model.addAttribute("etudiant", etudiant);
		return "etudiantForm";
	}
	@PostMapping("/etudiantForm/save")
	public String Ajouter(@ModelAttribute("etudiant") Etudiant etudiant, BindingResult result, Model model) {
		es.ajouter(etudiant);
		return "redirect:/etudiantForm?success";
	}
	@GetMapping("/listEtudiant")
	public String listeDesEtudiant(Model model) {
	List<Etudiant> etudiants = es.listeDesEtudiant();
		model.addAttribute("etudiants", etudiants);
		return "listEtudiant";
}

	@GetMapping(path ="/rechercher/nom")
	public String afficheParNom (@ModelAttribute("etudiant") Etudiant etudiant, BindingResult result, Model model) {
		model.addAttribute("listeParNom", es.rechercheNom(etudiant.getNom()));
		return "listeParNom";
	}
	
	@GetMapping("/liste")
	public String listeEtudiant(Model model) {
	List<Etudiant> etudiants = es.listeDesEtudiant();
		model.addAttribute("etudiants", etudiants);
		return "listEtudiant";
	}
	
	@GetMapping("/login")
	public String login() {
	    return "login";
	}

	@GetMapping("/register")
	public String register(Model model) {
	    model.addAttribute("etudiant", new Etudiant());
	    return "register";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("etudiant") Etudiant etudiant) {
	    etudiant.setPassword(new BCryptPasswordEncoder().encode(etudiant.getPassword()));
	    es.ajouter(etudiant);
	    //	    return "/liste";
	    return "redirect:/login?registerSuccess";
	}
	
	@GetMapping("/editForm/{id}")
	public String afficherFormulaireEdition(@PathVariable Long id, Model model) {
	    try {
	        Etudiant etudiant = es.recherche(id);
	        model.addAttribute("etudiant", etudiant);
	    } catch (Exception e) {
	        model.addAttribute("error", "Étudiant introuvable : " + id);
	        return "redirect:/listEtudiant?error";
	    }
	    return "editForm";
	}

	@PostMapping("/editForm/save")
	public String modifierEtudiant(@ModelAttribute("etudiant") Etudiant etudiant, 
			BindingResult result, Model model) {
		es.modifier(etudiant);
		return "redirect:/editForm/" + etudiant.getId() + "?success";
	}
	
	@GetMapping("/detailEtudiant/{id}")
	public String afficherDetailsEtudiant(@PathVariable Long id, Model model) {
   		Etudiant etudiant = es.recherche(id);
    	model.addAttribute("etudiant", etudiant);
    	return "detailEtudiant"; 
	}
	
	@GetMapping("/delete/{id}")
	public String supprimerEtudiant(@PathVariable Long id) {
		es.supprimer(id);
		return "redirect:/listEtudiant?deleted";
	}

}