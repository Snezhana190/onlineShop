package by.semashko.onlineShop.repository;

import by.semashko.onlineShop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositiry extends JpaRepository <User,Integer>{
    Optional <User> findUserByLogin (String login);
}
