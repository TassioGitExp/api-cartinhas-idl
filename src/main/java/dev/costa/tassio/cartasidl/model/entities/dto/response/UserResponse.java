package dev.costa.tassio.cartasidl.model.entities.dto.response;

import dev.costa.tassio.cartasidl.model.entities.user.User;
import lombok.Getter;

@Getter
public class UserResponse {
    private String email;
    private String name;
    private Boolean enabled;

    public UserResponse responseOf(final User user){
        this.email = user.getEmail();
        this.name = user.getName();
        this.enabled = user.isEnabled();

        return this;
    }
}
