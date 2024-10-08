package com.pfe.backend.repository;

import com.pfe.backend.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findUserByUsername(String username);

    User findUserByEmail(String email);

    @Query(value = "{}", fields = "{email : 1}")
    List<String> getEmails();

    long countByIsActive(boolean isActive);

    long countByIsNotLocked(boolean isNotLocked);
}
