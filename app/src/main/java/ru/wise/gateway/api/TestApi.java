package ru.wise.gateway.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;
import ru.wise.gateway.api.dto.CreateProjectRequest;
import ru.wise.gateway.api.dto.UpdateProjectRequest;
import ru.wise.gateway.repository.entity.ProjectEntity;

import java.util.List;

/**
 * Тестовый API
 */
@Tag(name = "Test API")
@RequestMapping("/test/api")
public interface TestApi {

    /**
     * Тестовый метод
     *
     * @return Строка "Hello, World!"
     */
    @Operation(
            summary = "Тестовый метод",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Успешный ответ"
            )
    )
    @GetMapping("/hello")
    String test();

    /**
     * Создать проект
     *
     * @param request данные для создания проекта
     * @return данные созданного проекта
     */
    @Operation(
            summary = "Создать проект",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Данные созданного проекта"
            )
    )
    @PostMapping("/create")
    ProjectEntity createProject(@Valid @Parameter(name = "Запрос на создание проекта")
                                CreateProjectRequest request);

    /**
     * Получить список всех проектов
     *
     * @return список всех проектов
     */
    @Operation(
            summary = "Получить список всех проектов",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Список всех проектов"
            )
    )
    @GetMapping("/projects")
    List<ProjectEntity> getProjects();

    /**
     * Обновить данные проекта
     *
     * @param request данные для обновления проекта
     * @return данные обновленного проекта
     */
    @Operation(
            summary = "Обновить данные проекта",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Данные обновленного проекта"
            )
    )
    @PatchMapping("/projects/update")
    ProjectEntity updateProject(@Valid @Parameter(name = "Запрос на обновление проекта")
                                UpdateProjectRequest request);

    /**
     * Удалить проект по идентификатору
     *
     * @param projectId идентификатор проекта для удаления
     */
    @Operation(
            summary = "Удалить проект по иднетификатору",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Проект успешно удален"
            )
    )
    @DeleteMapping("/projects/{projectId}/delete")
    void deleteProject(
            @Parameter(description = "Идентификатор проекта",
                    schema = @Schema(type = "string"))
            @Positive(message = "Идентификатор проекта должен быть положительным числом")
            @PathVariable
            Long projectId);

    /**
     * Получить проект по идентификатору
     *
     * @param projectId идентификатор проекта
     */
    @Operation(
            summary = "Получить проект по идентификатору",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Данные проекта"
            )
    )
    @GetMapping("/projects/{projectId}")
    ProjectEntity getProject(
            @Parameter(description = "Идентификатор проекта",
                    schema = @Schema(type = "string"))
            @Positive(message = "Идентификатор проекта должен быть положительным числом")
            @PathVariable
            Long projectId);
}
