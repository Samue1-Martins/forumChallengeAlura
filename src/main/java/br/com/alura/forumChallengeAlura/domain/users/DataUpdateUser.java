package br.com.alura.forumChallengeAlura.domain.users;

import jakarta.validation.constraints.NotNull;

public record DataUpdateUser(
        @NotNull
        Long id,
        String name,
        String password
) {
}
