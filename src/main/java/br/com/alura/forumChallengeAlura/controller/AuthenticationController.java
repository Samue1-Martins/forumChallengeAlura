package br.com.alura.forumChallengeAlura.controller;

import br.com.alura.forumChallengeAlura.domain.authentication.DataAuthetication;
import br.com.alura.forumChallengeAlura.domain.users.UsersClass;
import br.com.alura.forumChallengeAlura.infra.security.DataTokenJWT;
import br.com.alura.forumChallengeAlura.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity restLogin(@RequestBody @Valid DataAuthetication data){

        var autheticationToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authetication = manager.authenticate(autheticationToken);
        var tokenJWT = tokenService.generationToken((UsersClass) authetication.getPrincipal());
        return ResponseEntity.ok(new DataTokenJWT(tokenJWT));
    }

}
