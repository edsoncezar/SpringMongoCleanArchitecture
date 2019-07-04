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

@Service
@AllArgsConstructor
public class RemoveUsersService {

    @Autowired
    UsersRepository usersRepository;

    public void remove(List<Users> credentials) {

	final var credential = credentials.stream().map(this::setActive).collect(Collectors.toList());

	usersRepository.saveAll(credentials);
    }

    private Users setActive(Users users) {
	users.setActive(false);
	users.setLastUpdateDate(LocalDateTime.now(ZoneId.of("Brazil/East")));
	return users;
    }

}