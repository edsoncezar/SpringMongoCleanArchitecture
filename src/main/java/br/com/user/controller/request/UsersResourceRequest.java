/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */

package br.com.user.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.user.controller.resource.ActionResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Instantiates a new users resource request.
 *
 * @param action   the action
 * @param user     the user
 * @param password the password
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResourceRequest {

    /** The action. */
    @NotNull
    private ActionResource action;

    /** The user. */
    @NotBlank
    private String user;

    /** The password. */
    @NotBlank
    private String password;

}
