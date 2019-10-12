package be.weve.testgenerator.service.manager;

import be.weve.testgenerator.business.repository.impl.DomainClassRepository;
import be.weve.testgenerator.service.mapper.impl.DomainClassMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class DomainClassManager {

    private DomainClassRepository repo;
    private DomainClassMapper mapper;

    public void openFiles(List<File> files) {
    }
}
