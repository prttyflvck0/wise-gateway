package ru.wise.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.wise.gateway.repository.entity.ProjectEntity;

/**
 * Репозиторий для работы с проектами
 */
@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
