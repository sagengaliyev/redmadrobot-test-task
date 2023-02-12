package kz.robot.testtask.service;

import com.electronwill.nightconfig.core.conversion.SpecFloatInRange;
import kz.robot.testtask.mapper.FileEntityMapper;
import kz.robot.testtask.model.FileEntity;
import kz.robot.testtask.reports.ResourceCreationReport;
import kz.robot.testtask.repository.FileEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

@Service
@Slf4j
public class FileEntityService {
    private final FileEntityRepository fileEntityRepository;
    private final FileEntityMapper fileEntityMapper;

    public FileEntityService(FileEntityRepository fileEntityRepository, FileEntityMapper fileEntityMapper) {
        this.fileEntityRepository = fileEntityRepository;
        this.fileEntityMapper = fileEntityMapper;
    }

    public void upload(MultipartFile file) throws IOException {
        FileEntity image = null;
        if (file.getSize() != 0) {
            image = fileEntityMapper.toEntity(file);
        }
        log.info("Загружаю изображение: {};", image.getTitle());
        fileEntityRepository.save(image);
    }
}
