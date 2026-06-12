package ru.wise.gateway.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import ru.wise.gateway.domain.SubsetType;

import java.time.LocalDateTime;

/**
 * DTO для образца датасета
 */
@Data
@Schema(description = "Образец датасета")
//todo чето странное зачем такое надо
public class DatasetSampleDto {
    
    @JsonProperty("id")
    @Schema(description = "Уникальный идентификатор", example = "1")
    private Long id;

    @JsonProperty("dataset_id")
    @Schema(description = "ID датасета", example = "1")
    private Long datasetId;

    @JsonProperty("filename")
    @Schema(description = "Имя файла образца", example = "image_001.jpg")
    private String filename;

    @JsonProperty("annotation_filename")
    @Schema(description = "Имя файла аннотации", example = "image_001.xml")
    private String annotationFilename;

    @JsonProperty("storage_path")
    @Schema(description = "Путь к образцу на сервере", example = "samples/1/image_001.jpg")
    private String storagePath;

    @JsonProperty("annotation_storage_path")
    @Schema(description = "Путь к аннотации на сервере", example = "samples/1/image_001.xml")
    private String annotationStoragePath;

    @JsonProperty("subset_type")
    @Schema(description = "Тип подмножества", example = "train")
    private SubsetType subsetType;

    @JsonProperty("notes")
    @Schema(description = "Примечания", example = "Хороший образец для обучения")
    private String notes;

    @JsonProperty("created_at")
    @Schema(description = "Дата создания")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    @Schema(description = "Дата обновления")
    private LocalDateTime updatedAt;
}

