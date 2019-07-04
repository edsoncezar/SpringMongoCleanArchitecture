package br.com.user.usecase;

import static org.mockito.ArgumentMatchers.any;
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
import br.com.user.service.RemoveUsersService;
import br.com.user.utils.AESEncryption;

@RunWith(MockitoJUnitRunner.class)
public class RemoveUsersServiceTest {

    @InjectMocks
    private RemoveUsersService removeUsersService;
    @Mock
    private UsersRepository usersUsersRepository;
    @Mock
    private UsersRequestConverter usersUsersRequestToUsersConverter;
    @Mock
    private AESEncryption aeSEncryption;

    @Test
    public void testShouldRemoveUsersServiceTest() {

	try {
	    byte[] value = aeSEncryption.encryptCredential("1");
	    final var credentials = Users.builder().user(value).password(value).build();

	    removeUsersService.remove(List.of(credentials));
	    verify(usersUsersRepository, atLeastOnce()).saveAll(any());

	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}