package com.afi.tp_spring1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.afi.tp_spring1.model.Etudiant;
import com.afi.tp_spring1.repository.Etudiant_Rep;

@ComponentScan("com.afi.tp_spring1.repository")
@Service
public class Etudiant_Service implements Etudiant_Interface {
	@Autowired
	private Etudiant_Rep er;

	@Override
	public Etudiant ajouter(Etudiant e) {
		// TODO Auto-generated method stub
		return er.save(e);
	}

	@Override
	public void supprimer(long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
	}

	@Override
	public List<Etudiant> listeDesEtudiant() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public Etudiant recherche(long id) {
		// TODO Auto-generated method stub
		Optional<Etudiant> opt=er.findById(id);
		Etudiant et=null;
		if(opt.isPresent()) {
			et=opt.get();
		} else {
			throw new RuntimeException("Etudiant non trouvé " + id);
		}
		return et;
	}
	//

	@Override
	public Iterable<Etudiant> rechercheNom(String nom) {
		// TODO Auto-generated method stub
		return er.findByNom(nom);
	}
	
	@Override
	public Etudiant modifier(Etudiant e) {
		// TODO Auto-generated method stub
		return er.save(e);
	}
}
