package br.com.user.controller.resource;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.user.controller.request.UsersResourceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ActionResource {

    ADD("Add"), REMOVE("Remove");

    public String name;

    @JsonCreator
    public static ActionResource fromString(String key) {
	return Arrays.stream(ActionResource.values())
		.filter(actionsResource -> actionsResource.name().equalsIgnoreCase(key)).findFirst().orElse(null);
    }

    @JsonIgnore
    public static boolean isAdd(UsersResourceRequest actionsResource) {
	return ADD.equals(actionsResource.getAction());
    }

    @JsonIgnore
    public static boolean isRemove(UsersResourceRequest actionsResource) {
	return REMOVE.equals(actionsResource.getAction());
    }

    @Override
    @JsonValue
    public String toString() {
	return String.valueOf(name);
    }
}