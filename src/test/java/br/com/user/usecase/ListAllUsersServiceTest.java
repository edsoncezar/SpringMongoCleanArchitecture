/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
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

// TODO: Auto-generated Javadoc
/**
 * The Class ListAllUsersServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class ListAllUsersServiceTest {

    /** The list all users service. */
    @InjectMocks
    private ListAllUsersService listAllUsersService;
    
    /** The list users by id service. */
    @InjectMocks
    private ListUsersByIdService listUsersByIdService;
    
    /** The users users repository. */
    @Mock
    private UsersRepository usersUsersRepository;
    
    /** The users users request to users converter. */
    @Mock
    private UsersRequestConverter usersUsersRequestToUsersConverter;

    /**
     * Test should list all users service.
     */
    @Test
    public void testShouldListAllUsersService() {

	List<Users> listUsers = listAllUsersService.listUsers();

	final var listOfUsersUsers = List.of(listUsers);

	assertNotNull(listOfUsersUsers);

	verify(usersUsersRepository, atLeastOnce()).findByActiveIsTrue();

    }
}