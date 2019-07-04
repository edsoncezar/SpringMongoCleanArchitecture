/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
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
import br.com.user.service.AddUsersService;
import br.com.user.utils.AESEncryption;

// TODO: Auto-generated Javadoc
/**
 * The Class AddUsersServiceTest.
 */
@RunWith(MockitoJUnitRunner.class)
public class AddUsersServiceTest {

    /** The add users service. */
    @InjectMocks
    private AddUsersService addUsersService;
    
    /** The users users repository. */
    @Mock
    private UsersRepository usersUsersRepository;
    
    /** The users users request to users converter. */
    @Mock
    private UsersRequestConverter usersUsersRequestToUsersConverter;
    
    /** The ae S encryption. */
    @Mock
    private AESEncryption aeSEncryption;

    /**
     * Test should add users service test.
     */
    @Test
    public void testShouldAddUsersServiceTest() {

	try {
	    byte[] value = aeSEncryption.encryptCredential("1");
	    final var credentials = Users.builder().user(value).password(value).build();

	    addUsersService.add(List.of(credentials));
	    verify(usersUsersRepository, atLeastOnce()).saveAll(any());
	} catch (Exception e) {
	    e.printStackTrace();
	}

    }

}