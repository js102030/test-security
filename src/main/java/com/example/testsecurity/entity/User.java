package com.example.testsecurity.entity;

import com.example.testsecurity.enumType.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{8,16}$", message = "8~16자의 영문 대소문자, 숫자만 사용 가능합니다.")
    @Column(name = "id",unique = true, nullable = false)
    private String userId;

    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{12,}$", message = "12자리 이상의 영문, 숫자, 특수문자를 혼합하여 사용해야 합니다.")
    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String userId, String password, Role role) {
        this.userId = userId;
        this.password = password;
        this.role = role;
    }
}
