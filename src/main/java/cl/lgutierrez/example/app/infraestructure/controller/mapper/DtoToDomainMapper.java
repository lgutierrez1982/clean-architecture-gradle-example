package cl.lgutierrez.example.app.infraestructure.controller.mapper;

public abstract class DtoToDomainMapper<T1, T2> {

  //T1 IN Dto, T2 OUT Domain
  protected abstract T2 toDomain(T1 object);
}
