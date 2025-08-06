package br.com.alura.forumChallengeAlura.domain.users;

import br.com.alura.forumChallengeAlura.domain.topic.TopicClass;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsersClass implements UserDetails {
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

    public void updateUser(DataUpdateUser data){
        if (data.name() != null){
            this.name = data.name();
        }
        if (data.password() != null){
            this.password = data.password();
        }
    }

    public void addTopic(TopicClass topic){
        this.topics.add(topic);
        topic.setAuthorUser(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
