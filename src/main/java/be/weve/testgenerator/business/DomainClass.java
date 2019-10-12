package be.weve.testgenerator.business;

import lombok.Data;

@Data
public class DomainClass {

    private String path;
    private String fileName;
    private boolean converted;

    public DomainClass() {
        converted = false;
    }

}
