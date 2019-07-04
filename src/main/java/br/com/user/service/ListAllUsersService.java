/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
package br.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.user.domain.Users;
import br.com.user.repository.UsersRepository;
import lombok.AllArgsConstructor;

/**
 * The Class ListAllUsersService.
 */
@Service

/**
 * Instantiates a new list all users service.
 *
 * @param repository the repository
 */

/**
 * Instantiates a new list all users service.
 *
 * @param repository the repository
 */
@AllArgsConstructor
public class ListAllUsersService {

    /** The repository. */
    @Autowired
    UsersRepository repository;

    /**
     * List users.
     *
     * @return the list
     */
    public List<Users> listUsers() {
	return repository.findByActiveIsTrue();
    }

}
