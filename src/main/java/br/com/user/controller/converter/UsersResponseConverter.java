package br.com.user.controller.converter;

import org.springframework.stereotype.Component;

import br.com.user.controller.resource.UsersResource;
import br.com.user.domain.Users;
import br.com.user.utils.AESEncryption;

@Component
public class UsersResponseConverter {

    AESEncryption aesEncryption = new AESEncryption();

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
