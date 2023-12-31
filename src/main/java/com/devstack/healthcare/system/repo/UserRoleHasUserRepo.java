package com.devstack.healthcare.system.repo;

import com.devstack.healthcare.system.entity.UserRole;
import com.devstack.healthcare.system.entity.UserRoleHasUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface UserRoleHasUserRepo extends JpaRepository<UserRole,Long> {
    @Query(value="select * from user_role_has_user where user_id=?1",nativeQuery = true)
    List<UserRoleHasUser> findByUserId(long id);
}
