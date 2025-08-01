package br.com.alura.forumChallengeAlura.domain.topic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<TopicClass, Long> {
    List<TopicClass> findAllByAuthorUser_Id(Long userId);
}
