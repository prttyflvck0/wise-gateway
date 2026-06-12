package ru.wise.gateway.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.wise.gateway.api.dto.DatasetSampleDto;

import java.util.List;

/**
 * API для управления образцами датасета
 */
@Tag(name = "Dataset Samples API")
@RequestMapping("/api/v1/dataset-samples")
public interface DatasetSampleApi {

    @GetMapping("/{id}")
    @Operation(summary = "Получить образец датасета по ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Образец найден",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DatasetSampleDto.class))),
        @ApiResponse(responseCode = "404", description = "Образец не найден")
    })
    ResponseEntity<DatasetSampleDto> getById(
        @Parameter(description = "ID образца")
        @PathVariable Long id
    );

    @GetMapping("/dataset/{datasetId}")
    @Operation(summary = "Получить все образцы датасета")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Список образцов",
            content = @Content(mediaType = "application/json", 
                array = @ArraySchema(schema = @Schema(implementation = DatasetSampleDto.class)))),
        @ApiResponse(responseCode = "404", description = "Датасет не найден")
    })
    ResponseEntity<List<DatasetSampleDto>> getByDatasetId(
        @Parameter(description = "ID датасета")
        @PathVariable Long datasetId
    );

    @PostMapping
    @Operation(summary = "Создать новый образец датасета")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Образец создан",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DatasetSampleDto.class))),
        @ApiResponse(responseCode = "400", description = "Некорректные данные"),
        @ApiResponse(responseCode = "404", description = "Датасет не найден")
    })
    ResponseEntity<DatasetSampleDto> create(
        @RequestBody DatasetSampleDto dto
    );

    @PutMapping("/{id}")
    @Operation(summary = "Обновить образец датасета")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Образец обновлен",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = DatasetSampleDto.class))),
        @ApiResponse(responseCode = "400", description = "Некорректные данные"),
        @ApiResponse(responseCode = "404", description = "Образец не найден")
    })
    ResponseEntity<DatasetSampleDto> update(
        @Parameter(description = "ID образца")
        @PathVariable Long id,
        @RequestBody DatasetSampleDto dto
    );

    @DeleteMapping("/{id}")
    @Operation(summary = "Удалить образец датасета")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Образец удален"),
        @ApiResponse(responseCode = "404", description = "Образец не найден")
    })
    ResponseEntity<Void> delete(
        @Parameter(description = "ID образца")
        @PathVariable Long id
    );
}

