package ru.wise.gateway.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.jspecify.annotations.Nullable;

/**
 * Данные запроса на обновление проекта
 */
@Schema(description = "Данные для обновления проекта")
public record UpdateProjectRequest(
        @Schema(description = "Id проекта")
        @NotNull(message = "Id проекта должен быть задан")
        @Positive(message = "Id проекта должен быть положительным числом")
        Long id,

        @Schema(description = "Название проекта")
        @NotBlank(message = "Название проекта не может быть пустым")
        String name,

        @Schema(description = "Описание проекта")
        @Nullable String description,

        @Schema(description = "Дополнительные заметки о проекте")
        @Nullable String notes
) {
}
