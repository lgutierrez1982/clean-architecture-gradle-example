package cl.lgutierrez.example.app.mocks.user;

import cl.lgutierrez.example.app.infraestructure.repository.entity.UserEntity;

public class UserEntityMock {

  public static UserEntity build_with_id_1_and_username() {

    UserEntity userEntity = new UserEntity();
    userEntity.setId(1L);
    userEntity.setUsername("lgutierrez@afc.cl");

    return userEntity;
  }

  public static UserEntity build_with_id_2_and_username() {

    UserEntity userEntity = new UserEntity();
    userEntity.setId(2L);
    userEntity.setUsername("ptapia@afc.cl");

    return userEntity;
  }

  public static UserEntity build_with_id_3_and_username() {

    UserEntity userEntity = new UserEntity();
    userEntity.setId(1L);
    userEntity.setUsername("ihenry@afc.cl");

    return userEntity;
  }

}
