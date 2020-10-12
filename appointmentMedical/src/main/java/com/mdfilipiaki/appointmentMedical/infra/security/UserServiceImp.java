package com.mdfilipiaki.appointmentMedical.infra.security;

import com.mdfilipiaki.appointmentMedical.infra.models.User;
import com.mdfilipiaki.appointmentMedical.infra.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {

        final User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return new UserSS(user.getId(), user.getEmail(), user.getPassword(), user.getType());
    }
}
