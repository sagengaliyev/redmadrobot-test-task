package kz.robot.testtask.service;

import com.google.common.collect.Lists;
import kz.robot.testtask.dto.AdvertisementDTO;
import kz.robot.testtask.mapper.AdvertisementMapper;
import kz.robot.testtask.model.Advertisement;
import kz.robot.testtask.model.User;
import kz.robot.testtask.reports.ResourceCreationReport;
import kz.robot.testtask.repository.AdvertisementRepository;
import kz.robot.testtask.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@Service
@Slf4j
public class AdvertisementService {
    private final AdvertisementRepository advertisementRepository;
    private final AdvertisementMapper advertisementMapper;
    private final UserRepository userRepository;
    private final FileEntityService fileEntityService;

    public AdvertisementService(AdvertisementRepository advertisementRepository, AdvertisementMapper advertisementMapper, UserRepository userRepository, FileEntityService fileEntityService) {
        this.advertisementRepository = advertisementRepository;
        this.advertisementMapper = advertisementMapper;
        this.userRepository = userRepository;
        this.fileEntityService = fileEntityService;
    }

    public ResourceCreationReport create(AdvertisementDTO advertisementDTO, MultipartFile file, Principal principal,) throws IOException {
        User user = userRepository
                .findByEmail(principal
                        .getName()).orElseThrow(() -> new RuntimeException("unable to find user by username: " + principal.getName()));
        Long userId = user.getId();
        Advertisement advertisement = advertisementMapper.toEntity(advertisementDTO);
        advertisement.getUser().setId(userId);
        fileEntityService.upload(file);
        log.info("Пользователь с ID: {} успешно опубликовал новое объявление", userId);
        advertisementRepository.save(advertisement);
        return new ResourceCreationReport(Advertisement.class);
    }

    public Advertisement findById(Long advertisementID) {
        log.info("Вывод объявления с ID: {}", advertisementID);
        return advertisementRepository.findById(advertisementID).orElseThrow();
    }

    public List<Advertisement> findAll(){
        log.info("Вывод всех объявлений");
        return Lists.newArrayList(advertisementRepository.findAll());
    }
}
