package ru.wise.gateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.wise.gateway.repository.entity.DatasetSampleEntity;

import java.util.List;

/**
 * Репозиторий для работы с образцами датасета
 */
@Repository
public interface DatasetSampleRepository extends JpaRepository<DatasetSampleEntity, Long> {
    /**
     * Поиск всех образцов по ID датасета
     */
    List<DatasetSampleEntity> findByDatasetId(Long datasetId);
}

