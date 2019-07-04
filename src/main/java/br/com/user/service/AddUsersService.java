/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
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
 * The Class AddUsersService.
 */
@Service
@AllArgsConstructor
public class AddUsersService {

    /** The users repository. */
    @Autowired
    UsersRepository usersRepository;

    /**
     * Adds the.
     *
     * @param credentials the credentials
     */
    public void add(List<Users> credentials) {

	final var credential = credentials.stream().map(this::setActive).collect(Collectors.toList());

	usersRepository.saveAll(credentials);
    }

    /**
     * Sets the active.
     *
     * @param credential the credential
     * @return the users
     */
    private Users setActive(Users credential) {
	credential.setActive(true);
	credential.setLastUpdateDate(LocalDateTime.now(ZoneId.of("Brazil/East")));
	return credential;
    }

}