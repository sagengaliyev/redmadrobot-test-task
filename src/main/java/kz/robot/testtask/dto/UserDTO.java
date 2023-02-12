package kz.robot.testtask.dto;

import jakarta.persistence.*;
import kz.robot.testtask.model.Advertisement;
import kz.robot.testtask.model.Role;
import kz.robot.testtask.model.Status;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String status;
    private String role;
    private List<AdvertisementDTO> advertisements;
}
