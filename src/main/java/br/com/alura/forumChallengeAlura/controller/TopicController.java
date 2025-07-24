package br.com.alura.forumChallengeAlura.controller;

import br.com.alura.forumChallengeAlura.domain.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity createTopic(@RequestBody @Valid CreateTopic data, UriComponentsBuilder uriBuilder){
        var topic = new TopicClass(data);
        topic.setCreatedAt(Calendar.getInstance().getTime());
        repository.save(topic);
        var uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(uri).body(new DataTopicDetails(topic));
    }

    @GetMapping
    public ResponseEntity<List<TopicClass>> list(){
        var page = repository.findAll();
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailTopicWithId(@PathVariable Long id){
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new DataTopicDetails(topic));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateTopic(@RequestBody @Valid DataUpdateTopic data){
        var topic = repository.getReferenceById(data.id());
        topic.updateTopics(data);
        return ResponseEntity.ok(new DataTopicDetails(topic));
    }
}
