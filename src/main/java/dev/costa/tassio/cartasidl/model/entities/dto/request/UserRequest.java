package dev.costa.tassio.cartasidl.model.entities.dto.request;

import lombok.Setter;

@Setter
public class UserRequest {
    private String email;
    private String name;
    private String password;
}
