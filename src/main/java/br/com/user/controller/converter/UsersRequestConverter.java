/*
 * 
 */
package br.com.user.controller.converter;

import org.springframework.stereotype.Component;

import br.com.user.controller.request.UsersResourceRequest;
import br.com.user.domain.Users;
import br.com.user.utils.AESEncryption;


/**
 * The Class UsersRequestConverter.
 */
@Component
public class UsersRequestConverter {

    /** The aes encryption. */
    AESEncryption aesEncryption = new AESEncryption();

    /**
     * Convert.
     *
     * @param usersResource the users resource
     * @return the users
     */
    public Users convert(UsersResourceRequest usersResource) {
	final Users users = new Users();

	try {
	    byte[] user = aesEncryption.encryptCredential(usersResource.getUser());
	    byte[] password = aesEncryption.encryptCredential(usersResource.getPassword());

	    users.setUser(user);
	    users.setPassword(password);

	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	return users;
    }

}
