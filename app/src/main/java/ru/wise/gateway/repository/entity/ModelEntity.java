package ru.wise.gateway.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.wise.gateway.domain.ExecutionStatus;
import ru.wise.gateway.domain.Framework;
import ru.wise.gateway.domain.ModelStage;
import ru.wise.gateway.domain.ReleaseStatus;
import ru.wise.gateway.domain.TaskType;

import java.time.LocalDateTime;

/**
 * Сущность модели
 */
@Entity
@Table(name = "model")
@Getter
@Setter
public class ModelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "m_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "m_name", nullable = false)
    private String name;

    @Column(name = "m_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "m_dataset_id", nullable = false)
    private DatasetEntity dataset;

    @Column(name = "m_version", nullable = false)
    private Integer version;

    @Column(name = "m_path", nullable = false)
    private String path;

    @Column(name = "m_framework", nullable = false)
    @Enumerated(EnumType.STRING)
    private Framework framework;

    @Column(name = "m_task_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    @Column(name = "m_input_shape", nullable = false, columnDefinition = "int[]")
    //todo что-то странное с типом данных надо поменять что вообще передаем то
    private String inputShape;

    @Column(name = "m_output_shape", nullable = false, columnDefinition = "int[]")
    //todo что-то странное с типом данных надо поменять что вообще передаем то
    private String outputShape;

    @Column(name = "m_epochs", nullable = false)
    private Integer epochs;

    @Column(name = "m_model_size")
    private Long modelSize;

    @Column(name = "m_training_params")
    private String trainingParams;

    @Column(name = "m_release_status", nullable = false)
    private ReleaseStatus releaseStatus = ReleaseStatus.DRAFT;

    @Column(name = "m_exec_status", nullable = false)
    private ExecutionStatus executionStatus = ExecutionStatus.CREATED;

    @Column(name = "m_stage", nullable = false)
    private ModelStage stage = ModelStage.TRAINING;

    @Column(name = "m_notes")
    private String notes;

    @Column(name = "m_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "m_updated_at", nullable = false)
    private LocalDateTime updatedAt;
}

