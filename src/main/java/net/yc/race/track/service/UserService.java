package net.yc.race.track.service;

import lombok.RequiredArgsConstructor;
import net.yc.race.track.model.User;
import net.yc.race.track.repository.UserRepository;
import net.yc.race.track.serviceInf.UserServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInf {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            if (passwordEncoder.matches(password, user.get().getPassword())) {
                return user;
            }
        }
        return Optional.empty();
    }
}
