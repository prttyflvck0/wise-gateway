package ru.wise.gateway.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import org.jspecify.annotations.Nullable;

/**
 * Данные запроса на создание проекта
 */
@Schema(description = "Данные для создания проекта")
public record CreateProjectRequest(
        @Schema(description = "Название проекта")
        @NotBlank(message = "Название проекта не может быть пустым")
        String name,

        @Schema(description = "Описание проекта")
        @Nullable String description,

        @Schema(description = "Дополнительные заметки о проекте")
        @Nullable String notes
) {
}
