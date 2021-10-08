package by.semashko.onlineShop.service.impl;

import by.semashko.onlineShop.repository.UserRepositiry;
import by.semashko.onlineShop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String USER_NOT_FOUND = "User not found";

    private UserRepositiry userRepositiry;

    @Autowired
    public UserServiceImpl(UserRepositiry userRepositiry) {
        this.userRepositiry = userRepositiry;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return Optional.ofNullable(userRepositiry.findUserByLogin(userName))
                .get()
                .orElseThrow(()->new UsernameNotFoundException(USER_NOT_FOUND));

    }
}
