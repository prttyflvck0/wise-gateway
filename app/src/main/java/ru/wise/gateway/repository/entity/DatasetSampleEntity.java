package ru.wise.gateway.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.wise.gateway.domain.SubsetType;

import java.time.LocalDateTime;

/**
 * Сущность образца датасета
 */
@Entity
@Table(name = "dataset_sample")
@Getter
@Setter
public class DatasetSampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "ds_id", nullable = false, updatable = false)
    private Long id;

    //todo fetch type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ds_dataset_id", nullable = false)
    private DatasetEntity dataset;

    @Column(name = "ds_filename", nullable = false)
    private String filename;

    @Column(name = "ds_annotation_filename")
    private String annotationFilename;

    @Column(name = "ds_storage_path")
    private String storagePath;

    @Column(name = "ds_annotation_storage_path")
    private String annotationStoragePath;

    @Column(name = "ds_subset_type")
    @Enumerated(EnumType.STRING)
    private SubsetType subsetType;

    @Column(name = "ds_notes")
    private String notes;

    @Column(name = "ds_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "ds_updated_at", nullable = false)
    private LocalDateTime updatedAt;
}

