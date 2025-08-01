package br.com.alura.forumChallengeAlura.domain.topic;

import br.com.alura.forumChallengeAlura.domain.users.UsersClass;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    private String response;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private UsersClass authorUser;

    @Enumerated(EnumType.STRING)
    private CourseEnum course;

    public TopicClass(CreateTopic data, UsersClass authorUser) {
        this.title = data.title();
        this.message = data.message();
        this.createdAt = data.createdAt();
        this.status = data.status();
        this.response = data.response();
        this.course = data.course();
        this.authorUser = authorUser;
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
