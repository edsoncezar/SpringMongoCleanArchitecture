/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */

package br.com.user.controller.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResource {

    /** The user. */
    private String user;

    /** The password. */
    private String password;

}