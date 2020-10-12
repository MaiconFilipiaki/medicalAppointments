package com.mdfilipiaki.appointmentMedical.v1.user.presentation;

import com.mdfilipiaki.appointmentMedical.v1.user.infra.UserService;
import com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.mappers.UserMapper;
import com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.request.UserRequest;
import com.mdfilipiaki.appointmentMedical.v1.user.presentation.support.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserResource {

    final private UserService userService;

    @PostMapping
    ResponseEntity<UserResponse> createUser(@Valid @RequestBody final UserRequest userRequest) {
        final UserResponse userResponse = new UserMapper().ModelToResponse(
                userService.createUser(new UserMapper().RequestToModel(userRequest))
        );
        return ResponseEntity.ok().body(userResponse);
    }

    @GetMapping
    ResponseEntity<List<UserResponse>> listAll() {
        final List<UserResponse> listUsersResponse = new UserMapper().ConvertListModelToResponse(
                userService.listOfUser()
        );
        return ResponseEntity.ok().body(listUsersResponse);
    }


}
