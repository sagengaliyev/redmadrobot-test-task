package kz.robot.testtask.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FileEntityDTO {
    private Long id;
    private String title;
    private byte[] data;
    private String type;
    private LocalDateTime uploadedDate;
}
