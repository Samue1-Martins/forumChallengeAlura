package br.com.alura.forumChallengeAlura.domain.users;

import br.com.alura.forumChallengeAlura.domain.topic.TopicClass;
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
    @OneToMany(mappedBy = "id_author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TopicClass> topicsList = new ArrayList<>();

    public UsersClass(@Valid CreateUsers data) {
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
    }
}
