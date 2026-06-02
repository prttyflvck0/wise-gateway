package ru.wise.gateway.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.wise.gateway.domain.DataModality;
import ru.wise.gateway.domain.ExecutionStatus;
import ru.wise.gateway.domain.ReleaseStatus;
import ru.wise.gateway.domain.TaskType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сущность дата-сета
 */
@Entity
@Table(name = "dataset")
@Getter
@Setter
public class DatasetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "d_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "d_name", nullable = false)
    private String name;

    @Column(name = "d_description")
    private String description;

    @Column(name = "d_version_major", nullable = false)
    private Integer version_major;

    @Column(name = "d_version_minor", nullable = false)
    private Integer version_minor;

    @Column(name = "d_generation_params")
    //TODO должно подходить под формат jsonb
    private String generationParams;

    @Column(name = "d_source")
    private String source;

    @Column(name = "d_size", nullable = false)
    private Integer size;

    @Column(name = "d_release_status", nullable = false)
    private ReleaseStatus releaseStatus = ReleaseStatus.DRAFT;

    @Column(name = "d_exec_status", nullable = false)
    private ExecutionStatus executionStatus = ExecutionStatus.CREATED;

    @Column(name = "d_task_type", nullable = false)
    private TaskType taskType;

    @Column(name = "d_data_modality", nullable = false)
    private DataModality dataModality = DataModality.IMAGE;

    @Column(name = "d_notes")
    private String notes;

    @Column(name = "d_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "d_updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    //TODO потом подумать про фетч тайп
    @JoinColumn(name = "d_project_id", nullable = false)
    private ProjectEntity project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "d_parent_dataset_id")
    private DatasetEntity parentDataset;

    @OneToMany(mappedBy = "parentDataset", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<DatasetEntity> childDatasets;

}
