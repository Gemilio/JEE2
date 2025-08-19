package com.afi.tp_spring1.service;


import java.util.List;

import com.afi.tp_spring1.model.Etudiant;

public interface Etudiant_Interface {
	Etudiant ajouter(Etudiant e);
	
	void supprimer(long id);
	
	List<Etudiant> listeDesEtudiant();
	
	Etudiant recherche(long id);
	
	Iterable<Etudiant> rechercheNom(String nom);
	
	Etudiant modifier(Etudiant e);
}
