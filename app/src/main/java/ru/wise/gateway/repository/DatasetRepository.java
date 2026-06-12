package ru.wise.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.wise.gateway.repository.entity.DatasetEntity;

import java.util.List;

/**
 * Репозиторий для работы с датасетами
 */
@Repository
public interface DatasetRepository extends JpaRepository<DatasetEntity, Long> {
    /**
     * Поиск всех датасетов по ID проекта
     */
    List<DatasetEntity> findByProjectId(Long projectId);
}

