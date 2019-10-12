package be.weve.testgenerator.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<B, D> {

    B mapToObj(D dto);
    D mapToDto(B obj);

    default List<B> mapToObj(List<D> dtos) {
        return dtos.stream().map(this::mapToObj).collect(Collectors.toList());
    }

    default List<D> mapToDto(List<B> objects) {
        return objects.stream().map(this::mapToDto).collect(Collectors.toList());
    }

}
