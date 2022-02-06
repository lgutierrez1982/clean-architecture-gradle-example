package cl.lgutierrez.example.app.infraestructure.controller.mapper;

public abstract class DomainToDtoMapper<T1, T2> {

  //T1 IN Domain, T2 OUT DTO
  protected abstract T2 toDto(T1 object);
}
