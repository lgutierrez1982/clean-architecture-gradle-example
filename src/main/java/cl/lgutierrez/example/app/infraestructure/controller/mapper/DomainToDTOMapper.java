package cl.lgutierrez.example.app.infraestructure.controller.mapper;

public abstract class DomainToDTOMapper<T1, T2> {

  //T1 IN Domain, T2 OUT DTO
  protected abstract T2 toDTO(T1 object);
}
