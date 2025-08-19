package com.afi.tp_spring1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.afi.tp_spring1.model.Etudiant;
@Component
public interface Etudiant_Rep extends JpaRepository<Etudiant, Long> {
	public Optional<Etudiant> findByEmail(String email);
	public Iterable<Etudiant> findByNom(String nom);
}