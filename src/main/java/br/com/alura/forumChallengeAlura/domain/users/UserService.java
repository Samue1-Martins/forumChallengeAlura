package br.com.alura.forumChallengeAlura.domain.users;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public UsersClass registerUser(DataCreateUsers data){
        var hashedPassword = passwordEncoder.encode(data.password());
        UsersClass newUser = new UsersClass(data.name(), data.email(), hashedPassword);
        return userRepository.save(newUser);
    }

    @Transactional
    public UsersClass updateUser(Long id, DataUpdateUser data){
        UsersClass user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        user.updateUser(data, passwordEncoder);
        return userRepository.save(user);
    }

    @Transactional
    public List<DataUserDetails> listAllUser(){
         var user = userRepository
                .findAll()
                .stream()
                .map(DataUserDetails::new)
                .toList();
        return user;
    }

    @Transactional
    public DataUserTopicsDetails detailUserId(Long id){
        UsersClass user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
        var userDetails = new DataUserTopicsDetails(user);
        return userDetails;
    }

    @Transactional
    public void deleteUser(Long id){
        if (!userRepository.existsById(id)){
            throw new EntityNotFoundException("Usuário não encontrado.");
        }
        userRepository.deleteById(id);
    }
}
