package br.com.user.controller.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.user.controller.resource.ActionResource;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsersResourceRequest {

    @NotNull
    private ActionResource action;
    @NotBlank
    private String user;
    @NotBlank
    private String password;

}
