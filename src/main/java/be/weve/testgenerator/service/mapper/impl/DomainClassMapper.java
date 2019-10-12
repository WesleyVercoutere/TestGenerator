package be.weve.testgenerator.service.mapper.impl;

import be.weve.testgenerator.business.DomainClass;
import be.weve.testgenerator.service.dto.DomainClassDto;
import be.weve.testgenerator.service.mapper.Mapper;
import org.springframework.stereotype.Service;

@Service
public class DomainClassMapper implements Mapper<DomainClass, DomainClassDto> {

    @Override
    public DomainClass mapToObj(DomainClassDto dto) {
        if (dto == null) return null;

        DomainClass obj = new DomainClass();
        obj.setPath(dto.getPath());
        obj.setFileName(dto.getFileName());
        obj.setConverted(dto.isConverted());

        return obj;
    }

    @Override
    public DomainClassDto mapToDto(DomainClass obj) {
        if (obj == null) return null;

        DomainClassDto dto = new DomainClassDto();
        dto.setPath(obj.getPath());
        dto.setFileName(obj.getFileName());
        dto.setConverted(obj.isConverted());

        return dto;
    }
}
