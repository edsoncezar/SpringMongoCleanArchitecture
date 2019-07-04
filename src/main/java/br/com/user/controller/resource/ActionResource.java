/*
 * 
 */
package br.com.user.controller.resource;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.user.controller.request.UsersResourceRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * Gets the name.
 *
 * @return the name
 */

/**
 * Gets the name.
 *
 * @return the name
 */
@Getter

/**
 * Instantiates a new action resource.
 *
 * @param name the name
 */

/**
 * Instantiates a new action resource.
 *
 * @param name the name
 */
@AllArgsConstructor
public enum ActionResource {

    /** The add. */
    ADD("Add"), /** The remove. */
 REMOVE("Remove");

    /** The name. */
    public String name;

    /**
     * From string.
     *
     * @param key the key
     * @return the action resource
     */
    @JsonCreator
    public static ActionResource fromString(String key) {
	return Arrays.stream(ActionResource.values())
		.filter(actionsResource -> actionsResource.name().equalsIgnoreCase(key)).findFirst().orElse(null);
    }

    /**
     * Checks if is adds the.
     *
     * @param actionsResource the actions resource
     * @return true, if is adds the
     */
    @JsonIgnore
    public static boolean isAdd(UsersResourceRequest actionsResource) {
	return ADD.equals(actionsResource.getAction());
    }

    /**
     * Checks if is removes the.
     *
     * @param actionsResource the actions resource
     * @return true, if is removes the
     */
    @JsonIgnore
    public static boolean isRemove(UsersResourceRequest actionsResource) {
	return REMOVE.equals(actionsResource.getAction());
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    @JsonValue
    public String toString() {
	return String.valueOf(name);
    }
}