/*
 * 
 */
package br.com.user.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.user.domain.Users;
import br.com.user.repository.UsersRepository;
import lombok.AllArgsConstructor;


/**
 * The Class RemoveUsersService.
 */
@Service

/**
 * Instantiates a new removes the users service.
 *
 * @param usersRepository the users repository
 */

/**
 * Instantiates a new removes the users service.
 *
 * @param usersRepository the users repository
 */
@AllArgsConstructor
public class RemoveUsersService {

    /** The users repository. */
    @Autowired
    UsersRepository usersRepository;

    /**
     * Removes the.
     *
     * @param credentials the credentials
     */
    public void remove(List<Users> credentials) {

	final var credential = credentials.stream().map(this::setActive).collect(Collectors.toList());

	usersRepository.saveAll(credentials);
    }

    /**
     * Sets the active.
     *
     * @param users the users
     * @return the users
     */
    private Users setActive(Users users) {
	users.setActive(false);
	users.setLastUpdateDate(LocalDateTime.now(ZoneId.of("Brazil/East")));
	return users;
    }

}