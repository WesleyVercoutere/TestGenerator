package be.weve.testgenerator.service.manager;

import be.weve.testgenerator.business.DomainClass;
import be.weve.testgenerator.business.repository.impl.DomainClassRepository;
import be.weve.testgenerator.service.dto.DomainClassDto;
import be.weve.testgenerator.service.mapper.impl.DomainClassMapper;
import org.springframework.stereotype.Service;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainClassManager {

    private DomainClassRepository repo;
    private DomainClassMapper mapper;

    private PropertyChangeSupport support;

    //Constructor for Spring DI
    public DomainClassManager(DomainClassRepository domainClassRepository,
                              DomainClassMapper domainClassMapper) {
        this.repo = domainClassRepository;
        this.mapper = domainClassMapper;

        init();
    }

    private void init() {
        this.support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    //Open files
    public void openFiles(List<DomainClassDto> files) {
        List<DomainClass> objects = mapper.mapToObj(files);
        List<DomainClass> ok = objects.stream().filter(this::checkFileExtension).collect(Collectors.toList());
        ok.stream().forEach(e -> repo.create(e));

        support.firePropertyChange("addList", null, ok);
    }

    private boolean checkFileExtension(DomainClass obj) {
        return obj.getFileName().contains(".java");
        //TODO: add error output for file extension
    }

    public List<DomainClassDto> getAll() {
        return repo.readAll().stream().map(mapper::mapToDto).collect(Collectors.toList());
    }

    public void createTests() throws ClassNotFoundException {
        List<DomainClass> domainClasses = repo.readAll();

        for (DomainClass element : domainClasses) {

            String className = element.getFileName().replaceFirst("[.][^.]+$", "");

            Class classUnderTest = Class.forName(className);
            Field[] fields = classUnderTest.getDeclaredFields();

            System.out.println("class: " + className);

            List<Field> fieldList = Arrays.asList(fields);

            fieldList.forEach(e -> System.out.println("field name: " + e.getName()));


        }


    }
}
