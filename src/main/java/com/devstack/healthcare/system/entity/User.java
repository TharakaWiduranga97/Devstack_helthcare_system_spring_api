package com.devstack.healthcare.system.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class User {
    @Id
    private long id;
    private String fullName;
    private String email;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    @OneToMany(mappedBy="user")
    private Set<UserRoleHasUser> userRoleHasUsers;




}
