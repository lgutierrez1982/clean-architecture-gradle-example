package cl.lgutierrez.example.app.infraestructure.controller.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class DomainToDtoMapper<T1, T2> {

  //T1 IN Domain, T2 OUT DTO
  protected abstract T2 toDto(T1 object);

  public List<T2> toDto(List<T1> values) {
    List<T2> returnValues = new ArrayList<>(values.size());
    for (T1 value: values) {
      returnValues.add(toDto(value));
    }
    return returnValues;
  }
}
