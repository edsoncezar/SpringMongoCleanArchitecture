package br.com.user.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Document("users")
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    private byte[] user;
    private byte[] password;

    private boolean active;
    private LocalDateTime lastUpdateDate;

}
