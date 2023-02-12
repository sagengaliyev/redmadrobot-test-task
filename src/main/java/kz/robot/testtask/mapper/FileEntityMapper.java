package kz.robot.testtask.mapper;

import kz.robot.testtask.dto.FileEntityDTO;
import kz.robot.testtask.model.FileEntity;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")
public interface FileEntityMapper {
    FileEntityDTO toDto(FileEntity fileEntity);

    FileEntity toEntity(MultipartFile file);
}
