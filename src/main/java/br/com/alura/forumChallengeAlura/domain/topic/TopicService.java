package br.com.alura.forumChallengeAlura.domain.topic;

import br.com.alura.forumChallengeAlura.domain.users.UserRepository;
import br.com.alura.forumChallengeAlura.domain.users.UsersClass;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public TopicClass createTopic(CreateTopic data, Long userId){

        UsersClass authorUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado com o ID: " + userId));
        TopicClass newTopic = new TopicClass(data, authorUser);
        topicRepository.save(newTopic);

        return newTopic;
    }

}
