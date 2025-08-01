package br.com.alura.forumChallengeAlura.domain.users;

import java.util.List;

public record DataUserTopicsDetails (
        Long id,
        String name,
        List topics
){
    public DataUserTopicsDetails(UsersClass data){
        this(data.getId(),
                data.getName(),
                data.getTopics());
    }
}
