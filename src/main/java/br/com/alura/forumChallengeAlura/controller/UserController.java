package br.com.alura.forumChallengeAlura.controller;

import br.com.alura.forumChallengeAlura.domain.users.*;
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
    public ResponseEntity<List<DataUserDetails>> listUsers(){
        var page = repository
                .findAll()
                .stream()
                .map(DataUserDetails::new)
                .toList();
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Long id) {
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataUserTopicsDetails(user));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid DataUpdateUser data){
        var user = repository.getReferenceById(data.id());
        user.updateUser(data);
        return ResponseEntity.ok(new DataUserDetails(user));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteUser(@PathVariable Long id){
        var user = repository;
        user.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
