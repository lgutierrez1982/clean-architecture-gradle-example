package cl.lgutierrez.example.app.infraestructure.controller.mapper.todomain;

public interface DTOToDomainMapper<T1, T2> {

  //T1 IN Dto, T2 OUT Domain
  T2 toDomain(T1 object);
}
