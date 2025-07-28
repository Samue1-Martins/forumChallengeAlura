package br.com.alura.forumChallengeAlura.controller;

import br.com.alura.forumChallengeAlura.domain.users.CreateUsers;
import br.com.alura.forumChallengeAlura.domain.users.DataUserDetails;
import br.com.alura.forumChallengeAlura.domain.users.UserRepository;
import br.com.alura.forumChallengeAlura.domain.users.UsersClass;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createUser(@RequestBody @Valid CreateUsers data, UriComponentsBuilder uriBuilder){
        var user = new UsersClass(data);
        repository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataUserDetails(user));
    }

    @GetMapping
    public List<UsersClass> users(){
        return repository.findAll();
    }
}
