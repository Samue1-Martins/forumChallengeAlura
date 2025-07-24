package br.com.alura.forumChallengeAlura.domain.topic;

import java.util.Date;

public record DataTopicDetails(
         Long id,
         String title,
         String message,
         Date createdAt,
         String status,
         String author,
         String response
) {
    public DataTopicDetails(TopicClass topic){
    this(topic.getId(),
            topic.getTitle(),
            topic.getAuthor(),
            topic.getCreatedAt(),
            topic.getAuthor(),
            topic.getMessage(),
            topic.getResponse());
    }
}
