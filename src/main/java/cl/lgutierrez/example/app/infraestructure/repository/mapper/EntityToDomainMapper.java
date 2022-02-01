package cl.lgutierrez.example.app.infraestructure.repository.mapper;

public abstract class EntityToDomainMapper<T1, T2> {

  //T1 IN Entity, T2 OUT Domain
  protected abstract T2 toDomain(T1 object);
}
