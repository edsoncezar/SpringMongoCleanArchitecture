/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
package br.com.user.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.user.controller.UsersController;
import br.com.user.controller.converter.UsersRequestConverter;
import br.com.user.controller.converter.UsersResponseConverter;
import br.com.user.controller.request.UsersListRequest;
import br.com.user.controller.request.UsersResourceRequest;
import br.com.user.controller.resource.ActionResource;
import br.com.user.repository.UsersRepository;
import br.com.user.service.AddUsersService;
import br.com.user.service.ListAllUsersService;
import br.com.user.service.ListUsersByIdService;
import br.com.user.service.RemoveUsersService;
import br.com.user.utils.AESEncryption;


/**
 * The Class UsersControllerTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest {

    /** The controller. */
    @InjectMocks
    private UsersController controller;
    
    /** The list all users service. */
    @Mock
    private ListAllUsersService listAllUsersService;
    
    /** The list users by id service. */
    @Mock
    private ListUsersByIdService listUsersByIdService;
    
    /** The add users service. */
    @Mock
    private AddUsersService addUsersService;
    
    /** The remove users service. */
    @Mock
    private RemoveUsersService removeUsersService;
    
    /** The users users repository. */
    @Mock
    private UsersRepository usersUsersRepository;
    
    /** The users users to users response converter. */
    @Spy
    private UsersResponseConverter usersUsersToUsersResponseConverter;
    
    /** The users users request to users converter. */
    @Spy
    private UsersRequestConverter usersUsersRequestToUsersConverter;
    
    /** The ae S encryption. */
    @Mock
    private AESEncryption aeSEncryption;

    /**
     * Test should list all users.
     *
     * @throws Exception the exception
     */
    @Test
    public void testShouldListAllUsers() throws Exception {

	final var usersCredentialList = controller.listAllUsers();
	assertNotNull(usersCredentialList);
	verify(listAllUsersService, atLeastOnce()).listUsers();

    }

    /**
     * Test should list users using one list of users codes.
     */
    @Test
    public void testShouldListUsersUsingOneListOfUsersCodes() {

	final var user = List.of("1", "2");

	when(listUsersByIdService.listUsers(user)).thenReturn(anyList());

	final var usersCredentialListByFilial = controller.listUsersByUser(user);
	assertNotNull(usersCredentialListByFilial);
	verify(listUsersByIdService, atLeastOnce()).listUsers(user);

    }

    /**
     * Test should add users without removing.
     */
    @Test
    public void testShouldAddUsersWithoutRemoving() {

	final var usersList = UsersResourceRequest.builder().user("1").password("1").action(ActionResource.ADD).build();

	final var listOfUsersAdd = List.of(usersList);

	final var addUsers = UsersListRequest.builder().users(listOfUsersAdd).build();

	controller.addOrRemoveUsers(addUsers);

	verify(addUsersService, atLeastOnce()).add(anyList());
	verify(removeUsersService, never()).remove(anyList());

	final var usersRemove = UsersResourceRequest.builder().user("1").password("1").action(ActionResource.REMOVE)
		.build();

	final var listOfUsersRemove = List.of(usersRemove);

	final var removeUsers = UsersListRequest.builder().users(listOfUsersRemove).build();

	controller.addOrRemoveUsers(removeUsers);

    }

}