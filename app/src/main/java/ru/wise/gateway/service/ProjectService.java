package ru.wise.gateway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.wise.gateway.api.dto.CreateProjectRequest;
import ru.wise.gateway.api.dto.UpdateProjectRequest;
import ru.wise.gateway.repository.ProjectRepository;
import ru.wise.gateway.repository.entity.ProjectEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с проектами
 */
@Service
@RequiredArgsConstructor
//TODO тут можно будет делить на команд и квери сервисы
public class ProjectService {

    private final ProjectRepository repository;

    public ProjectEntity createProject(CreateProjectRequest request) {
        LocalDateTime now = LocalDateTime.now();

        ProjectEntity project = new ProjectEntity();
        project.setName(request.name());
        project.setDescription(request.description());
        project.setNotes(request.notes());
        project.setCreatedAt(now);
        project.setUpdatedAt(now);

        return repository.save(project);
    }

    public List<ProjectEntity> getAllProjects() {
        return repository.findAll();
    }

    public ProjectEntity updateProject(UpdateProjectRequest request) {
        ProjectEntity project = repository.findById(request.id())
                .orElseThrow(() -> new RuntimeException("Проект с id %d не найден".formatted(request.id())));

        project.setName(request.name());
        Optional.ofNullable(request.description()).ifPresent(project::setDescription);
        Optional.ofNullable(request.notes()).ifPresent(project::setNotes);
        project.setUpdatedAt(LocalDateTime.now());

        return repository.save(project);
    }

    public void deleteProject(Long projectId) {
        repository.deleteById(projectId);
    }

    public ProjectEntity getProjectById(Long projectId) {
        return repository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Проект с id %d не найден".formatted(projectId)));
    }

}
