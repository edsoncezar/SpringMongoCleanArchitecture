/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */

package br.com.user.controller.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersListRequest {

    /** The users. */
    private List<UsersResourceRequest> users;
}