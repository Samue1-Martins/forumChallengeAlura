package br.com.alura.forumChallengeAlura.domain.topic;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Table(name = "topics")
@Entity(name = "Topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;
    private Date createdAt;
    private String status;
    private String author;
    private String response;

    @Enumerated(EnumType.STRING)
    private CourseEnum course;

    public TopicClass(CreateTopic data) {
        this.title = data.title();
        this.message = data.message();
        this.createdAt = data.createdAt();
        this.status = data.status();
        this.author = data.author();
        this.response = data.response();
        this.course = data.course();
    }

    public void updateTopics(DataUpdateTopic data){
        if (data.message() != null){
            this.message = data.message();
        }
        if (data.response() != null){
            this.response = data.response();
        }
        if (data.status() != null){
            this.status = data.status();
        }
    }
}
