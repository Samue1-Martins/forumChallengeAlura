package br.com.alura.forumChallengeAlura.domain.users;

import br.com.alura.forumChallengeAlura.domain.topic.TopicClass;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsersClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    @JsonManagedReference
    @OneToMany(mappedBy = "authorUser", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TopicClass> topics = new ArrayList<>();

    public UsersClass(@Valid CreateUsers data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }

    public void addTopic(TopicClass topic){
        this.topics.add(topic);
        topic.setAuthorUser(this);
    }
}
