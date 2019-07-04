package br.com.user.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import br.com.user.domain.Users;

@Component
public interface UsersRepository extends MongoRepository<Users, String> {

    List<Users> findByActiveIsTrue();

    List<Users> findByActiveIsTrueAndUserIn(List<String> user);

}