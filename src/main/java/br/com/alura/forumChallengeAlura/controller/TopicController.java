package br.com.alura.forumChallengeAlura.controller;

import br.com.alura.forumChallengeAlura.domain.topic.*;
import br.com.alura.forumChallengeAlura.domain.users.UserRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Calendar;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid DataCreateTopic data, UriComponentsBuilder uriBuilder){
        TopicClass topic = topicService.createTopic(data, data.userId());
        topic.setCreatedAt(Calendar.getInstance().getTime());
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataTopicDetails(topic));
    }

    @GetMapping
    public ResponseEntity listTopics(){
        var topics = topicService.listTopics();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTopicWithId(@PathVariable Long id){
        var topic = topicService.detailTopicId(id);
        return ResponseEntity.ok(topic);
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid DataUpdateTopic data){
        TopicClass updateTopic = topicService.updateUser(data.id(), data);
        return ResponseEntity.ok(new DataTopicDetails(updateTopic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id){
        topicRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
