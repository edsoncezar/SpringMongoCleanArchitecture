package br.com.user.usecase;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.user.controller.converter.UsersRequestConverter;
import br.com.user.domain.Users;
import br.com.user.repository.UsersRepository;
import br.com.user.service.ListAllUsersService;
import br.com.user.service.ListUsersByIdService;

@RunWith(MockitoJUnitRunner.class)
public class ListAllUsersServiceTest {

    @InjectMocks
    private ListAllUsersService listAllUsersService;
    @InjectMocks
    private ListUsersByIdService listUsersByIdService;
    @Mock
    private UsersRepository usersUsersRepository;
    @Mock
    private UsersRequestConverter usersUsersRequestToUsersConverter;

    @Test
    public void testShouldListAllUsersService() {

	List<Users> listUsers = listAllUsersService.listUsers();

	final var listOfUsersUsers = List.of(listUsers);

	assertNotNull(listOfUsersUsers);

	verify(usersUsersRepository, atLeastOnce()).findByActiveIsTrue();

    }
}