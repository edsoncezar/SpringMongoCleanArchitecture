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

@RestController
@AllArgsConstructor
@RequestMapping("/v1/users")
public class UsersController {

    private final ListAllUsersService listAllUsersService;
    private final ListUsersByIdService listUsersByIdService;
    private final AddUsersService addUsersService;
    private final RemoveUsersService removeUsersService;
    private final UsersRequestConverter usersRequestConverter;
    private final UsersResponseConverter usersResponseConverter;

    @GetMapping("/listAll")
    public List<UsersResource> listAllUsers() {
	return listAllUsersService.listUsers().stream().map(usersResponseConverter::convert)
		.collect(Collectors.toList());
    }

    @GetMapping
    public List<UsersResource> listUsersByUser(@RequestParam List<String> user) {
	return listUsersByIdService.listUsers(user).stream().map(usersResponseConverter::convert)
		.collect(Collectors.toList());
    }

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