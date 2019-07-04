/*
 * 
 */
package br.com.user.controller.converter;

import org.springframework.stereotype.Component;

import br.com.user.controller.resource.UsersResource;
import br.com.user.domain.Users;
import br.com.user.utils.AESEncryption;


/**
 * The Class UsersResponseConverter.
 */
@Component
public class UsersResponseConverter {

    /** The aes encryption. */
    AESEncryption aesEncryption = new AESEncryption();

    /**
     * Convert.
     *
     * @param users the users
     * @return the users resource
     */
    public UsersResource convert(Users users) {
	final UsersResource usersResponse = new UsersResource();

	try {

	    String user = aesEncryption.decryptCredential(users.getUser());
	    String password = aesEncryption.decryptCredential(users.getPassword());

	    usersResponse.setUser(user);

	    usersResponse.setPassword(password);

	} catch (Exception e) {
	    e.printStackTrace();
	}

	return usersResponse;

    }

}
