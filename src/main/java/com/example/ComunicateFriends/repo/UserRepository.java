package com.example.ComunicateFriends.repo;

import com.example.ComunicateFriends.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
