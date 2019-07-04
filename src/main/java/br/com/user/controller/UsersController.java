/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */
package br.com.user.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.user.controller.converter.UsersRequestConverter;
import br.com.user.controller.converter.UsersResponseConverter;
import br.com.user.controller.request.UsersListRequest;
import br.com.user.controller.resource.ActionResource;
import br.com.user.controller.resource.UsersResource;
import br.com.user.domain.Users;
import br.com.user.service.AddUsersService;
import br.com.user.service.ListAllUsersService;
import br.com.user.service.ListUsersByIdService;
import br.com.user.service.RemoveUsersService;
import lombok.AllArgsConstructor;

/**
 * The Class UsersController.
 */
@RestController

/**
 * Instantiates a new users controller.
 *
 * @param listAllUsersService    the list all users service
 * @param listUsersByIdService   the list users by id service
 * @param addUsersService        the add users service
 * @param removeUsersService     the remove users service
 * @param usersRequestConverter  the users request converter
 * @param usersResponseConverter the users response converter
 */
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UsersController {

    /** The list all users service. */
    private final ListAllUsersService listAllUsersService;

    /** The list users by id service. */
    private final ListUsersByIdService listUsersByIdService;

    /** The add users service. */
    private final AddUsersService addUsersService;

    /** The remove users service. */
    private final RemoveUsersService removeUsersService;

    /** The users request converter. */
    private final UsersRequestConverter usersRequestConverter;

    /** The users response converter. */
    private final UsersResponseConverter usersResponseConverter;

    /**
     * List all users.
     *
     * @return the list
     */
    @GetMapping("/listAll")
    public List<UsersResource> listAllUsers() {
	return listAllUsersService.listUsers().stream().map(usersResponseConverter::convert)
		.collect(Collectors.toList());
    }

    /**
     * List users by user.
     *
     * @param user the user
     * @return the list
     */
    @GetMapping
    public List<UsersResource> listUsersByUser(@RequestParam List<String> user) {
	return listUsersByIdService.listUsers(user).stream().map(usersResponseConverter::convert)
		.collect(Collectors.toList());
    }

    /**
     * Adds the or remove users.
     *
     * @param resource the resource
     */
    @PostMapping
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void addOrRemoveUsers(@RequestBody @Valid UsersListRequest resource) {

	List<Users> addUsers = resource.getUsers().stream().filter(ActionResource::isAdd)
		.map(usersRequestConverter::convert).collect(Collectors.toList());

	List<Users> removeUsers = resource.getUsers().stream().filter(ActionResource::isRemove)
		.map(usersRequestConverter::convert).collect(Collectors.toList());

	if (!addUsers.isEmpty()) {
	    addUsersService.add(addUsers);
	}

	if (!removeUsers.isEmpty()) {
	    removeUsersService.remove(removeUsers);
	}

    }

}