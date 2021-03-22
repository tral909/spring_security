package io.github.spring_security.security;

import io.github.spring_security.model.Status;
import io.github.spring_security.model.User;
import io.github.spring_security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User doesn't exist")); // ошибки нет в логе

        boolean isActive = u.getStatus() == Status.ACTIVE;
        return new org.springframework.security.core.userdetails.User(
                u.getEmail(), u.getPassword(),
                isActive, isActive, isActive, isActive,
                u.getRole().getAuthorities());
    }
}
