/*
 * 
 */
package br.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.user.domain.Users;
import br.com.user.repository.UsersRepository;
import lombok.AllArgsConstructor;


/**
 * The Class ListUsersByIdService.
 */
@Service

/**
 * Instantiates a new list users by id service.
 *
 * @param repository the repository
 */

/**
 * Instantiates a new list users by id service.
 *
 * @param repository the repository
 */
@AllArgsConstructor
public class ListUsersByIdService {

    /** The repository. */
    @Autowired
    UsersRepository repository;

    /**
     * List users.
     *
     * @param user the user
     * @return the list
     */
    public List<Users> listUsers(List<String> user) {
	return repository.findByActiveIsTrueAndUserIn(user);
    }

}
