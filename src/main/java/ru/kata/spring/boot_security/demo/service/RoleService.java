package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.models.Role;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public Collection<Role> roleSet(String ADMIN, String USER) {
        Collection<Role> roles = new HashSet<>();
        if (ADMIN != null) {
            roles.add(new Role(1L, "ADMIN"));
        }
        if (USER != null) {
            roles.add(new Role(2L, "USER"));
        }
        if (ADMIN == null && USER == null) {
            roles.add(new Role(2L, "USER"));
        }
        return roles;
    }
}
