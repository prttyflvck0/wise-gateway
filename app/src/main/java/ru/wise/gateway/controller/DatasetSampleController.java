package ru.wise.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.wise.gateway.api.DatasetSampleApi;
import ru.wise.gateway.api.dto.DatasetSampleDto;
import ru.wise.gateway.service.DatasetSampleService;

import java.util.List;

/**
 * Контроллер для управления образцами датасета
 */
@RestController
@RequiredArgsConstructor
public class DatasetSampleController implements DatasetSampleApi {

    private final DatasetSampleService datasetSampleService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DatasetSampleDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(datasetSampleService.getById(id));
    }

    @Override
    @GetMapping("/dataset/{datasetId}")
    public ResponseEntity<List<DatasetSampleDto>> getByDatasetId(@PathVariable Long datasetId) {
        return ResponseEntity.ok(datasetSampleService.getByDatasetId(datasetId));
    }

    @Override
    @PostMapping
    public ResponseEntity<DatasetSampleDto> create(@RequestBody DatasetSampleDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(datasetSampleService.create(dto));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<DatasetSampleDto> update(@PathVariable Long id, @RequestBody DatasetSampleDto dto) {
        return ResponseEntity.ok(datasetSampleService.update(id, dto));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        datasetSampleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

