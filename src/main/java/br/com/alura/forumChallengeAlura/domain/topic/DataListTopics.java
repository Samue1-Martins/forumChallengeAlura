package br.com.alura.forumChallengeAlura.domain.topic;

import java.util.Date;

public record DataListTopics(
        Long id,
        String title,
        String message,
        Date createdAt,
        String status,
        String author,
        String response
) {
    public DataListTopics(TopicClass listTopic){
        this(listTopic.getId(),
                listTopic.getTitle(),
                listTopic.getAuthor(),
                listTopic.getCreatedAt(),
                listTopic.getAuthor(),
                listTopic.getMessage(),
                listTopic.getResponse());
    }
}
