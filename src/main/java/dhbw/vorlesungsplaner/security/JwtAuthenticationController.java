package dhbw.vorlesungsplaner.security;

import dhbw.vorlesungsplaner.dozenten.Dozenten;
import dhbw.vorlesungsplaner.dozenten.DozentenServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private DozentenServiceClass dozentenServiceClass;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/dozenten/register", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody DozentenServiceClass dozenten) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(dozenten));
    }

    @RequestMapping(value = "/dozenten/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestBody DozentenServiceClass dozenten, @PathVariable Integer id) {
        try {
            Dozenten existDozenten = dozentenServiceClass.get(id);
            return ResponseEntity.ok(userDetailsService.update(dozenten, id));
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}