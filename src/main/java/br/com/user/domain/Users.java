/*
 * 
 */
package br.com.user.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
@Document("users")

/**
 * Instantiates a new users.
 */

/**
 * Instantiates a new users.
 */
@NoArgsConstructor

/**
 * Instantiates a new users.
 *
 * @param user           the user
 * @param password       the password
 * @param active         the active
 * @param lastUpdateDate the last update date
 */

/**
 * Instantiates a new users.
 *
 * @param user           the user
 * @param password       the password
 * @param active         the active
 * @param lastUpdateDate the last update date
 */
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
