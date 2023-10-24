package com.mftplus.storage.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder


@Entity(name = "userEntity")
@Table(name = "user_tbl")

@NamedQueries({
        @NamedQuery(name = "User.FindByUserName", query = "select oo from userEntity oo where oo.userName=:userName"),
        @NamedQuery(name = "User.FindByUserNameAndPassword", query = "select oo from userEntity oo where oo.userName=:userName and oo.password=:password"),
})
public class User extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "u_username", length = 20, unique = true)
    @Pattern(regexp = "^[A-Za-z]{10,30}$", message = "Invalid UserName")
    private String userName;


    @Column(name = "u_password", length = 20)
    @Pattern(regexp = "^[A-Za-z]{8,30}$", message = "Invalid Password")
    private String password;

    @OneToOne
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private Role role;
}
