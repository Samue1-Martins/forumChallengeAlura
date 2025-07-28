package br.com.alura.forumChallengeAlura.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UsersClass, Long> {
}
