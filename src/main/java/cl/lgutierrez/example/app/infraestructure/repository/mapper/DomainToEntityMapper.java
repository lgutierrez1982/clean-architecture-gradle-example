package cl.lgutierrez.example.app.infraestructure.repository.mapper;

public abstract class DomainToEntityMapper<T1, T2> {

  //T1 IN Domain, T2 OUT Entity
  protected abstract T2 toEntity(T1 objet);
}
