package br.com.alura.forumChallengeAlura.domain.topic;

import jakarta.validation.constraints.NotNull;

public record DataUpdateTopic(
        @NotNull
        Long id,
        String message,
        String response,
        String status
) {
}
