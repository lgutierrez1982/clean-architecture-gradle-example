package cl.lgutierrez.example.app.mocks.user;

import cl.lgutierrez.example.app.domain.model.User;
import java.util.Arrays;
import java.util.List;

public class UserListMock {

  public static List<User> build_users() {
    return Arrays.asList(
        User.builder().withId(1L).withUsername("lgutierrez@afc.cl").build(),
        User.builder().withId(2L).withUsername("ptapia@afc.cl").build(),
        User.builder().withId(3L).withUsername("erubio@afc.cl").build(),
        User.builder().withId(4L).withUsername("dtapiaf@afc.cl").build(),
        User.builder().withId(5L).withUsername("ihenry@afc.cl").build()
    );
  }

}
