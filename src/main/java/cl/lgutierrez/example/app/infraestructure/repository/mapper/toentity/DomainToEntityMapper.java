package cl.lgutierrez.example.app.infraestructure.repository.mapper.toentity;

public interface DomainToEntityMapper<T1, T2> {

  //T1 IN Domain, T2 OUT Entity
  T2 toEntity(T1 objet);
}
