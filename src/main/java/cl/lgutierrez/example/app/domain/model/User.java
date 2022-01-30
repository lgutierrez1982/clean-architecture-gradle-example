package cl.lgutierrez.example.app.domain.model;

import java.util.UUID;

public class User {

  private UUID uuid;
  private String username;
  private String password;
  private String email;

  public static User.UserBuilder builder() {
    return new User.UserBuilder();
  }

  public UUID getUuid() {
    return uuid;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }


  public static final class UserBuilder {
    private UUID uuid;
    private String username;
    private String password;
    private String email;

    private UserBuilder() {
    }

    public User.UserBuilder withUuid(UUID uuid) {
      this.uuid = uuid;
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

    public User.UserBuilder withEmail(String email) {
      this.email = email;
      return this;
    }

    public User build() {
      User user = new User();
      user.uuid = this.uuid;
      user.username = this.username;
      user.password = this.password;
      user.email = this.email;
      return user;
    }

  }

}

