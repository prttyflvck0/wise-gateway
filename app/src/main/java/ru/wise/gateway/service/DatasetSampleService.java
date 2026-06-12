package ru.wise.gateway.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.wise.gateway.api.dto.DatasetSampleDto;
import ru.wise.gateway.repository.DatasetRepository;
import ru.wise.gateway.repository.DatasetSampleRepository;
import ru.wise.gateway.repository.entity.DatasetEntity;
import ru.wise.gateway.repository.entity.DatasetSampleEntity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сервис для управления образцами датасета
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
//TODO сгенеренное
public class DatasetSampleService {

    private final DatasetSampleRepository datasetSampleRepository;
    private final DatasetRepository datasetRepository;

    /**
     * Получить образец по ID
     */
    public DatasetSampleDto getById(Long id) {
        return datasetSampleRepository.findById(id)
            .map(this::toDto)
            .orElseThrow(() -> new IllegalArgumentException("Dataset sample not found: " + id));
    }

    /**
     * Получить все образцы датасета
     */
    public List<DatasetSampleDto> getByDatasetId(Long datasetId) {
        return datasetSampleRepository.findByDatasetId(datasetId)
            .stream()
            .map(this::toDto)
            .toList();
    }

    /**
     * Создать новый образец
     */
    @Transactional
    public DatasetSampleDto create(DatasetSampleDto dto) {
        DatasetEntity dataset = datasetRepository.findById(dto.getDatasetId())
            .orElseThrow(() -> new IllegalArgumentException("Dataset not found: " + dto.getDatasetId()));

        DatasetSampleEntity entity = new DatasetSampleEntity();
        entity.setDataset(dataset);
        entity.setFilename(dto.getFilename());
        entity.setAnnotationFilename(dto.getAnnotationFilename());
        entity.setStoragePath(dto.getStoragePath());
        entity.setAnnotationStoragePath(dto.getAnnotationStoragePath());
        entity.setSubsetType(dto.getSubsetType());
        entity.setNotes(dto.getNotes());
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());

        DatasetSampleEntity saved = datasetSampleRepository.save(entity);
        return toDto(saved);
    }

    /**
     * Обновить образец
     */
    @Transactional
    public DatasetSampleDto update(Long id, DatasetSampleDto dto) {
        DatasetSampleEntity entity = datasetSampleRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Dataset sample not found: " + id));

        if (dto.getFilename() != null) {
            entity.setFilename(dto.getFilename());
        }
        if (dto.getAnnotationFilename() != null) {
            entity.setAnnotationFilename(dto.getAnnotationFilename());
        }
        if (dto.getStoragePath() != null) {
            entity.setStoragePath(dto.getStoragePath());
        }
        if (dto.getAnnotationStoragePath() != null) {
            entity.setAnnotationStoragePath(dto.getAnnotationStoragePath());
        }
        if (dto.getSubsetType() != null) {
            entity.setSubsetType(dto.getSubsetType());
        }
        if (dto.getNotes() != null) {
            entity.setNotes(dto.getNotes());
        }
        entity.setUpdatedAt(LocalDateTime.now());

        DatasetSampleEntity updated = datasetSampleRepository.save(entity);
        return toDto(updated);
    }

    /**
     * Удалить образец
     */
    @Transactional
    public void delete(Long id) {
        DatasetSampleEntity entity = datasetSampleRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Dataset sample not found: " + id));
        datasetSampleRepository.delete(entity);
    }

    /**
     * Конвертировать сущность в DTO
     */
    //todo мапстракт
    private DatasetSampleDto toDto(DatasetSampleEntity entity) {
        DatasetSampleDto dto = new DatasetSampleDto();
        dto.setId(entity.getId());
        dto.setDatasetId(entity.getDataset().getId());
        dto.setFilename(entity.getFilename());
        dto.setAnnotationFilename(entity.getAnnotationFilename());
        dto.setStoragePath(entity.getStoragePath());
        dto.setAnnotationStoragePath(entity.getAnnotationStoragePath());
        dto.setSubsetType(entity.getSubsetType());
        dto.setNotes(entity.getNotes());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
}

