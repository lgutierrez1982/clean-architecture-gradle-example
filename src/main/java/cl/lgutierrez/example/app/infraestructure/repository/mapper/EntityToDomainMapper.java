package cl.lgutierrez.example.app.infraestructure.repository.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class EntityToDomainMapper<T1, T2> {

  //T1 IN Entity, T2 OUT Domain
  protected abstract T2 toDomain(T1 object);

  public List<T2> toDomain(List<T1> values) {
    List<T2> returnValues = new ArrayList<>(values.size());
    for (T1 value: values) {
      returnValues.add(toDomain(value));
    }
    return returnValues;
  }
}
