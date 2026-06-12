package ru.wise.gateway.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.wise.gateway.domain.ExecutionStatus;
import ru.wise.gateway.domain.ExperimentStage;
import ru.wise.gateway.domain.ReleaseStatus;

import java.time.LocalDateTime;

/**
 * Сущность эксперимента
 */
@Entity
@Table(name = "experiment")
@Getter
@Setter
public class ExperimentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "e_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "e_name", nullable = false)
    private String name;

    @Column(name = "e_description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "e_model_id", nullable = false)
    private ModelEntity model;

    @Column(name = "e_metrics")
    private String metrics;

    @Column(name = "e_release_status", nullable = false)
    private ReleaseStatus releaseStatus = ReleaseStatus.DRAFT;

    @Column(name = "e_exec_status", nullable = false)
    private ExecutionStatus executionStatus = ExecutionStatus.CREATED;

    @Column(name = "e_stage", nullable = false)
    private ExperimentStage stage = ExperimentStage.TRAINING;

    @Column(name = "e_notes")
    private String notes;

    @Column(name = "e_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "e_updated_at", nullable = false)
    private LocalDateTime updatedAt;
}

