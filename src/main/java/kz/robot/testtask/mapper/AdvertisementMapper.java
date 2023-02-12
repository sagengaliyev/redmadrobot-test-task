package kz.robot.testtask.mapper;

import kz.robot.testtask.dto.AdvertisementDTO;
import kz.robot.testtask.model.Advertisement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        UserMapper.class, FileEntityMapper.class
})
public interface AdvertisementMapper {
    AdvertisementDTO toDto(Advertisement advertisement);
    Advertisement toEntity(AdvertisementDTO advertisementDTO);
}
