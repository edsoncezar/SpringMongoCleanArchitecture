package br.com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.user.domain.Users;
import br.com.user.repository.UsersRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ListAllUsersService {

    @Autowired
    UsersRepository repository;

    public List<Users> listUsers() {
	return repository.findByActiveIsTrue();
    }

}
