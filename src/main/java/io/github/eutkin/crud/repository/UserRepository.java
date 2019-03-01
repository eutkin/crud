package io.github.eutkin.crud.repository;

import io.github.eutkin.crud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserRepository extends UserDetailsService, JpaRepository<User, String> {

    @Override
    default UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findById(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
