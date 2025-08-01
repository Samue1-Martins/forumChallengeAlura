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
import java.util.List;

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
    public ResponseEntity createTopic(@RequestBody @Valid CreateTopic data, UriComponentsBuilder uriBuilder){

        TopicClass topic = topicService.createTopic(data, data.userId());
        topic.setCreatedAt(Calendar.getInstance().getTime());
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataTopicDetails(topic));
    }

    @GetMapping
    public ResponseEntity<List<DataTopicDetails>> list(){
            var page = topicRepository
                    .findAll()
                    .stream()
                    .map(DataTopicDetails::new)
                    .toList();
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTopicWithId(@PathVariable Long id){
        var topic = topicRepository.getReferenceById(id);
        return ResponseEntity.ok(new DataTopicDetails(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid DataUpdateTopic data){
        var topic = topicRepository.getReferenceById(data.id());
        topic.updateTopics(data);
        return ResponseEntity.ok(new DataTopicDetails(topic));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTopic(@PathVariable Long id){
        var topic = topicRepository;
        topic.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
