package cn.echisan.springbootjwtdemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by echisan on 2018/6/23
 */
@Data
@Entity
@Table(name = "jd_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
//    private List<Role> roles;
    private String role;






    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
