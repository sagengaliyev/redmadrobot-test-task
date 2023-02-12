package kz.robot.testtask.mapper;

import kz.robot.testtask.dto.UserDTO;
import kz.robot.testtask.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
