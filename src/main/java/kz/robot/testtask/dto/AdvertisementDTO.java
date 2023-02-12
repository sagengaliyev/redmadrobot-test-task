package kz.robot.testtask.dto;

import jakarta.persistence.*;
import kz.robot.testtask.model.AdvertisementStatus;
import kz.robot.testtask.model.FileEntity;
import kz.robot.testtask.model.User;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class AdvertisementDTO {
    private Long id;
    private String title;
    private String description;
    private BigDecimal minimumPrice;
    private List<FileEntityDTO> images;
    private String advertisementStatus;
    private UserDTO user;
}
