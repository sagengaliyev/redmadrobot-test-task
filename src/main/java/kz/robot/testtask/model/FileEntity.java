package kz.robot.testtask.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "FILE_ENTITY")
public class FileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "DATA")
    private byte[] data;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "UPLOADED_DATE")
    private LocalDateTime uploadedDate;

}
