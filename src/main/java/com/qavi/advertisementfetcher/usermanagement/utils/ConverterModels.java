package com.qavi.advertisementfetcher.usermanagement.utils;

import com.qavi.advertisementfetcher.usermanagement.entities.user.User;
import com.qavi.advertisementfetcher.usermanagement.models.UserDataModel;

public class ConverterModels {

    public static UserDataModel convertUserToUserDataModel(User user) {
        UserDataModel userDataModel = new UserDataModel();
        userDataModel.setFirstName(user.getFirstName());
        userDataModel.setLastName(user.getLastName());
        userDataModel.setEmail(user.getEmail());
        userDataModel.setId(user.getId());
        userDataModel.setRoles(user.getRole());
        userDataModel.setAuthType(user.getAuthType());
        userDataModel.setEnabled(user.isEnabled());
        userDataModel.setLastLoginAt(user.getLastLoginAt());
//        userDataModel.setCustomerAt(user.getCustomerAt());
        return userDataModel;
    }
}
