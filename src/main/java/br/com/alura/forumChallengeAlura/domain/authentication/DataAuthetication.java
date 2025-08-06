package br.com.alura.forumChallengeAlura.domain.authentication;

import jakarta.validation.constraints.NotBlank;

public record DataAuthetication(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
