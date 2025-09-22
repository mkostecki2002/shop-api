package com.shop.api.repository;

import com.shop.api.data.Role;
import com.shop.api.data.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName name);
}
