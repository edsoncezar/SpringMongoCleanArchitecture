/*
 * 
 */
package br.com.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.com.user.domain.Users;


/**
 * The Interface UsersRepository.
 */
@Component
public interface UsersRepository extends MongoRepository<Users, String> {

    /**
     * Find by active is true.
     *
     * @return the list
     */
    List<Users> findByActiveIsTrue();

    /**
     * Find by active is true and user in.
     *
     * @param user the user
     * @return the list
     */
    List<Users> findByActiveIsTrueAndUserIn(List<String> user);

}