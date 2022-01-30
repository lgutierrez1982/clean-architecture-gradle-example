package cl.lgutierrez.example.app.infraestructure.repository.mapper.todomain;

public interface EntityToDomainMapper<T1, T2> {

  //T1 IN Entity, T2 OUT Domain
  T2 toDomain(T1 object);
}
