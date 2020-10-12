package com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.mappers;

import com.mdfilipiaki.appointmentMedical.infra.enumeration.UserType;
import com.mdfilipiaki.appointmentMedical.infra.models.User;
import com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.request.UserRequest;
import com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.response.UserResponse;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public User RequestToModel(final UserRequest userRequest) {
        return new User(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPassword(),
                UserType.toEnum(userRequest.getType())
        );
    }


    public UserResponse ModelToResponse(final User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getType().getValue()
        );
    }

    public List<UserResponse> ConvertListModelToResponse(final List<User> users) {
        return users.stream().map(this::ModelToResponse).collect(Collectors.toList());
    }

}
