package br.com.alura.forumChallengeAlura.domain.topic;

import br.com.alura.forumChallengeAlura.domain.users.UsersClass;

import java.util.Date;

public record DataTopicDetails(
         Long id,
         String name,
         String title,
         String message,
         Date createdAt,
         String status,
         String response,
         CourseEnum courseEnum
) {
    public DataTopicDetails(TopicClass topic){
    this(topic.getId(),
            topic.getAuthorUser().getName(),
            topic.getTitle(),
            topic.getMessage(),
            topic.getCreatedAt(),
            topic.getStatus(),
            topic.getResponse(),
            topic.getCourse());
    }

}
