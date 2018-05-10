package com.pccw.immd.adminfunc.repository;

import com.pccw.immd.adminfunc.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
}
