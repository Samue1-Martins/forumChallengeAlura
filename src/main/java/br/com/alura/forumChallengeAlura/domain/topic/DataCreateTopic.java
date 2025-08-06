package br.com.alura.forumChallengeAlura.domain.topic;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

public record DataCreateTopic(
        @NotBlank
        String title,
        @NotBlank
        String message,
        Date createdAt,
        @NotBlank
        String status,
        @NotBlank
        String response,
        @NotNull
        CourseEnum course,
        @NotNull
        Long userId
        ) {

}
