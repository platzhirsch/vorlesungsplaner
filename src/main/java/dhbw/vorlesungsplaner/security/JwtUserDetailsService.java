package dhbw.vorlesungsplaner.security;

import java.util.ArrayList;

import dhbw.vorlesungsplaner.dozenten.Dozenten;
import dhbw.vorlesungsplaner.dozenten.DozentenRepository;
import dhbw.vorlesungsplaner.dozenten.DozentenServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Autowired
    private DozentenRepository dozentenRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private DozentenServiceClass dozentenServiceClass;


    @Override
    public UserDetails loadUserByUsername(String dozMail) throws UsernameNotFoundException {

        Dozenten dozenten = dozentenRepository.findAllByDozMail(dozMail);
        if (dozenten == null) {
            throw new UsernameNotFoundException("User not found with username: " + dozMail);
        }
        return new org.springframework.security.core.userdetails.User(dozenten.getDozMail(), dozenten.getPassword(),
                new ArrayList<>());
    }


    public Dozenten save(DozentenServiceClass dozenten) {
        Dozenten newUser = new Dozenten();
        newUser.setDozVorname(dozenten.getDozVorname());
        newUser.setDozNachname(dozenten.getDozNachname());
        newUser.setDozMail(dozenten.getDozMail());
        newUser.setDozTel(dozenten.getDozTel());
        newUser.setDozMobil(dozenten.getDozMobil());
        newUser.setPassword(bcryptEncoder.encode(dozenten.getPassword()));
        return dozentenRepository.save(newUser);
    }
    public Dozenten update(DozentenServiceClass dozenten, Integer id) {
        Dozenten newUser = new Dozenten();
        newUser.setDozId(id);
        newUser.setDozVorname(dozenten.getDozVorname());
        newUser.setDozNachname(dozenten.getDozNachname());
        newUser.setDozMail(dozenten.getDozMail());
        newUser.setDozTel(dozenten.getDozTel());
        newUser.setDozMobil(dozenten.getDozMobil());
        newUser.setPassword(bcryptEncoder.encode(dozenten.getPassword()));
        return dozentenRepository.save(newUser);
    }

} 