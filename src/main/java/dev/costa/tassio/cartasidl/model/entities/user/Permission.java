package dev.costa.tassio.cartasidl.model.entities.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "\"permission\"")
public class Permission implements GrantedAuthority {

    @Id
    @Column(name = "id_permission", nullable = false, unique = true)
    private Long id;

    @Column(name = "permission_type", nullable = false, unique = true)
    private String permissionType;
    @Override
    public String getAuthority() {
        return this.permissionType;
    }
}
