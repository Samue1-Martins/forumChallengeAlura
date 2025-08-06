package br.com.alura.forumChallengeAlura.domain.topic;

import br.com.alura.forumChallengeAlura.domain.users.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public TopicClass createTopic(DataCreateTopic data, Long userId){
        UsersClass authorUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("topic not found. " + userId));
        TopicClass newTopic = new TopicClass(data, authorUser);
        topicRepository.save(newTopic);
        return newTopic;
    }

    @Transactional
    public List<DataTopicDetails> listTopics(){
        var ListTopic = topicRepository
                .findAll()
                .stream()
                .map(DataTopicDetails::new)
                .toList();
        return ListTopic;
    }

    @Transactional
    public DataTopicDetails detailTopicId(Long id){
        TopicClass topic = topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("topic not found."));
        var topicDetails = new DataTopicDetails(topic);
        return topicDetails;
    }

    @Transactional
    public TopicClass updateUser(Long id, DataUpdateTopic data){
        TopicClass topic = topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("topic not found."));
        topic.updateTopics(data);
        return topicRepository.save(topic);
    }

    @Transactional
    public void deleteTopic(Long id){
        if (!topicRepository.existsById(id)){
            throw new EntityNotFoundException("Topic não encontrado.");
        }
        topicRepository.deleteById(id);
    }
}
