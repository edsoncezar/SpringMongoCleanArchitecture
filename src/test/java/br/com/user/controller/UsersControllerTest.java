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

@RunWith(MockitoJUnitRunner.class)
public class UsersControllerTest {

    @InjectMocks
    private UsersController controller;
    @Mock
    private ListAllUsersService listAllUsersService;
    @Mock
    private ListUsersByIdService listUsersByIdService;
    @Mock
    private AddUsersService addUsersService;
    @Mock
    private RemoveUsersService removeUsersService;
    @Mock
    private UsersRepository usersUsersRepository;
    @Spy
    private UsersResponseConverter usersUsersToUsersResponseConverter;
    @Spy
    private UsersRequestConverter usersUsersRequestToUsersConverter;
    @Mock
    private AESEncryption aeSEncryption;

    @Test
    public void testShouldListAllUsers() throws Exception {

	final var usersCredentialList = controller.listAllUsers();
	assertNotNull(usersCredentialList);
	verify(listAllUsersService, atLeastOnce()).listUsers();

    }

    @Test
    public void testShouldListUsersUsingOneListOfUsersCodes() {

	final var user = List.of("1", "2");

	when(listUsersByIdService.listUsers(user)).thenReturn(anyList());

	final var usersCredentialListByFilial = controller.listUsersByUser(user);
	assertNotNull(usersCredentialListByFilial);
	verify(listUsersByIdService, atLeastOnce()).listUsers(user);

    }

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