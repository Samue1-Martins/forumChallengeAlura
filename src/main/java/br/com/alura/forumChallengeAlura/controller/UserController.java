package br.com.alura.forumChallengeAlura.controller;

import br.com.alura.forumChallengeAlura.domain.users.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @RequestMapping("/create")
    public ResponseEntity createUser(@RequestBody @Valid DataCreateUsers data, UriComponentsBuilder uriBuilder){
        UsersClass registeredUser = userService.registerUser(data);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(registeredUser.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataUserDetails(registeredUser));
    }

    @GetMapping
    public ResponseEntity listUsers(){
        var listUser = userService.listAllUser();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailUserId(@PathVariable Long id) {
        var detailsUserId = userService.detailUserId(id);
        return ResponseEntity.ok(detailsUserId);
    }

    @PutMapping
    public ResponseEntity updateTopic(@RequestBody @Valid DataUpdateUser data){
        UsersClass updateUser = userService.updateUser(data.id(), data);
        return ResponseEntity.ok(new DataUserDetails(updateUser));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity  deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
