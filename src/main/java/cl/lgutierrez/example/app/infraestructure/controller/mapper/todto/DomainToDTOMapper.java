package cl.lgutierrez.example.app.infraestructure.controller.mapper.todto;

public interface DomainToDTOMapper<T1, T2> {

  //T1 IN Domain, T2 OUT DTO
  T2 toDTO(T1 object);
}
