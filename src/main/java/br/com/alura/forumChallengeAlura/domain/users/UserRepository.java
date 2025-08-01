package br.com.alura.forumChallengeAlura.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UsersClass, Long> {
    Optional<UsersClass> findById(Long id);
}
