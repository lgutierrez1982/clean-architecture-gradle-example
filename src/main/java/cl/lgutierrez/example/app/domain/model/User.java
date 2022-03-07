package cl.lgutierrez.example.app.domain.model;

public class User  {

  private Long id;
  private String username;
  private String password;

  public static User.UserBuilder builder() {
    return new User.UserBuilder();
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }


  public static final class UserBuilder {
    private Long id;
    private String username;
    private String password;

    private UserBuilder() {
    }

    public User.UserBuilder withId(Long id) {
      this.id = id;
      return this;
    }

    public User.UserBuilder withUsername(String username) {
      this.username = username;
      return this;
    }

    public User.UserBuilder withPassword(String password) {
      this.password = password;
      return this;
    }


    public User build() {
      User user = new User();
      user.id = this.id;
      user.username = this.username;
      user.password = this.password;
      return user;
    }

  }

}

