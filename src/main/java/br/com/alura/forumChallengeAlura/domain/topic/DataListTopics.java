package br.com.alura.forumChallengeAlura.domain.topic;

import java.util.Date;

public record DataListTopics(
        Long id,
        String title,
        String message,
        Date createdAt,
        String status,
        String response
) {
    public DataListTopics(TopicClass listTopic){
        this(listTopic.getId(),
                listTopic.getTitle(),
                listTopic.getMessage(),
                listTopic.getCreatedAt(),
                listTopic.getStatus(),
                listTopic.getResponse());
    }
}
