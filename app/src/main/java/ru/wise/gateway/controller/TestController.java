package ru.wise.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;
import ru.wise.gateway.api.TestApi;
import ru.wise.gateway.api.dto.CreateProjectRequest;
import ru.wise.gateway.api.dto.UpdateProjectRequest;
import ru.wise.gateway.repository.entity.ProjectEntity;
import ru.wise.gateway.service.ProjectService;

import java.util.List;

/**
 * Тестовый контроллер для проверки работы API
 */
@Validated
@RestController
@RequiredArgsConstructor
public class TestController implements TestApi {

    private final ProjectService projectService;

    @Override
    public String test() {
        return "Hello World!";
    }

    @Override
    public ProjectEntity createProject(CreateProjectRequest request) {
        return projectService.createProject(request);
    }

    @Override
    public List<ProjectEntity> getProjects() {
        return projectService.getAllProjects();
    }

    @Override
    public ProjectEntity updateProject(UpdateProjectRequest request) {
        return projectService.updateProject(request);
    }

    @Override
    public void deleteProject(Long projectId) {
        projectService.deleteProject(projectId);
    }

    @Override
    public ProjectEntity getProject(Long projectId) {
        return projectService.getProjectById(projectId);
    }
}
