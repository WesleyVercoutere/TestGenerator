package be.weve.testgenerator.service.dto;

import lombok.Data;

@Data
public class DomainClassDto {

    private String path;
    private String fileName;
    private boolean converted;

}
