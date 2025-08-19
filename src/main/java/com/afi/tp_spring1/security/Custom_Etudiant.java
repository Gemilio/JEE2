package com.afi.tp_spring1.security;

import com.afi.tp_spring1.model.Etudiant;
import com.afi.tp_spring1.repository.Etudiant_Rep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class Custom_Etudiant implements UserDetailsService {
	@Autowired
    private Etudiant_Rep etudiantRep;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Etudiant etudiant = etudiantRep.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Etudiant non trouvé"));

//        return new User(etudiant.getEmail(), etudiant.getPassword(), Collections.emptyList());
        return new User(etudiant.getEmail(), etudiant.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_ETUDIANT")));

    }
}
