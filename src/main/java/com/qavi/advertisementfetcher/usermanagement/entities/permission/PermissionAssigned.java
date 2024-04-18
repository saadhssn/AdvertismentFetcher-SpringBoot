package com.qavi.advertisementfetcher.usermanagement.entities.permission;
import com.qavi.advertisementfetcher.usermanagement.entities.permission.Permission;
import com.qavi.advertisementfetcher.usermanagement.entities.role.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(PermissionAssigned.class)
public class PermissionAssigned implements Serializable {
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    Role role;
    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    Permission permission;
    String permissionBits;
}
