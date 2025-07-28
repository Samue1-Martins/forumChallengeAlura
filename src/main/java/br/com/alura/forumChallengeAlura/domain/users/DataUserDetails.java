package br.com.alura.forumChallengeAlura.domain.users;

import org.apache.catalina.User;

public record DataUserDetails(
        Long id,
        String name,
        String password
) {
    public DataUserDetails(UsersClass data){
        this(data.getId(),
        data.getName(),
        data.getPassword());

    }
}
