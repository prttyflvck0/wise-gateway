package ru.wise.gateway.repository.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import ru.wise.gateway.domain.ReleaseStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Сущность проекта
 */
@Entity
@Table(name = "project")
@Getter
@Setter
public class ProjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "p_id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "p_name", nullable = false)
    private String name;

    @Column(name = "p_description")
    private String description;

    @Column(name = "p_release_status", nullable = false)
    private ReleaseStatus releaseStatus = ReleaseStatus.DRAFT;

    @Column(name = "p_notes")
    private String notes;

    @Column(name = "p_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "p_updated_at", nullable = false)
    private LocalDateTime updatedAt;
    
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DatasetEntity> datasets;
}
