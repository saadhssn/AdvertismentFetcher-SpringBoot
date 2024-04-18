package com.qavi.advertisementfetcher.usermanagement.services.role;

import com.qavi.advertisementfetcher.usermanagement.entities.role.Role;
import com.qavi.advertisementfetcher.usermanagement.models.PermissionBitsModel;
import com.qavi.advertisementfetcher.usermanagement.repositories.PermissionRepository;
import com.qavi.advertisementfetcher.usermanagement.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PermissionRepository permissionRepository;
    public boolean addRole(Role role)
    {
        try {
            roleRepository.save(role);
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }

    public boolean assignPermission(PermissionBitsModel permissionBitsModel,Long roleId) {
        try{
            roleRepository.assignPermission(permissionBitsModel.getPermissionBit(), permissionRepository.findByName(permissionBitsModel.getPermission()).getId(),roleRepository.findById(roleId).get().getId());
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
    }
}
