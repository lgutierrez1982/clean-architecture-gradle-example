package cl.lgutierrez.example.app.mocks.user;

import cl.lgutierrez.example.app.domain.model.User;

public class UserMock {

  public static User build_with_id_username() {

    return User.builder()
        .withId(1L)
        .withUsername("lgutierrez@afc.cl").build();
  }

  public static User build_with_id_1_and_username() {

    return User.builder()
        .withId(1L)
        .withUsername("lgutierrez@afc.cl").build();
  }

  public static User build_with_id_2_and_username() {

    return User.builder()
        .withId(2L)
        .withUsername("ptapia@afc.cl").build();
  }

  public static User build_without_id_and_with_username() {

    return User.builder()
        .withUsername("ptapia@afc.cl").build();
  }



}
