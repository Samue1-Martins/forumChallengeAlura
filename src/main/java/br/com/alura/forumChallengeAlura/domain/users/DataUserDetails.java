package br.com.alura.forumChallengeAlura.domain.users;

public record DataUserDetails(
        Long id,
        String name
) {
    public DataUserDetails(UsersClass data){
        this(data.getId(),
        data.getName());
    }

}
