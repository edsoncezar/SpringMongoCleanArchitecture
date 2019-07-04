/**
 * @author Edson Cezar
 *
 * Jul 4, 2019
 */

package br.com.user.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Instantiates a new users.
 *
 * @param user           the user
 * @param password       the password
 * @param active         the active
 * @param lastUpdateDate the last update date
 */
@Data
@Builder
@Document("users")
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    /** The user. */
    private byte[] user;

    /** The password. */
    private byte[] password;

    /** The active. */
    private boolean active;

    /** The last update date. */
    private LocalDateTime lastUpdateDate;

}
