package ru.wise.gateway.domain;

/**
 * Статус выполнения задачи
 */
public enum ExecutionStatus {
    CREATED,
    QUEUED,
    RUNNING,
    COMPLETED,
    FAILED,
    CANCELLED
}
