package br.com.alura.forumChallengeAlura.domain.topic;

import java.util.Date;

public record DataTopicDetails(
         Long id,
         String title,
         String message,
         Date createdAt,
         String status,
         String author,
         String response,
         CourseEnum courseEnum
) {
    public DataTopicDetails(TopicClass topic){
    this(topic.getId(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getCreatedAt(),
            topic.getStatus(),
            topic.getAuthor(),
            topic.getResponse(),
            topic.getCourse());
    }
}
