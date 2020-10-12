package com.mdfilipiaki.appointmentMedical.v1.user.infra;

import com.mdfilipiaki.appointmentMedical.infra.exceptions.DataIntegrityException;
import com.mdfilipiaki.appointmentMedical.infra.models.User;
import com.mdfilipiaki.appointmentMedical.infra.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public User createUser(final User user) {
        final User userFindByEmail = userRepository.findByEmail(user.getEmail());
        if (userFindByEmail != null) {
            throw new DataIntegrityException("Email already exists");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> listOfUser() {
        return userRepository.findAll();
    }

}
