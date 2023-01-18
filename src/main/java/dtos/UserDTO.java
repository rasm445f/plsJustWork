package dtos;


import entities.User;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDTO {
    private int id;
    private String userName;
    private String userPass;
    private List<String> roles;

    public UserDTO(User user){
        this.id = user.getId();
        this.userName = user.getUserName();
        this.userPass = user.getUserPass();
        this.roles = user.getRolesAsStrings();
    }
    public User toUser () {
        return new User(this.userName, this.userPass);
    }

    public static List<UserDTO> getUserDTOs(List<User> users) {
        List<UserDTO> UserDTOList = new ArrayList<>();
        users.forEach(user -> {
            UserDTOList.add(new UserDTO(user));
        });
        return UserDTOList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = BCrypt.hashpw(userPass, BCrypt.gensalt());
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDTO)) return false;
        UserDTO UserDTO = (UserDTO) o;
        return getId() == UserDTO.getId() && getUserName().equals(UserDTO.getUserName()) && getUserPass().equals(UserDTO.getUserPass()) && getRoles().equals(UserDTO.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getUserPass(), getRoles());
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", roles=" + roles +
                '}';
    }
}
