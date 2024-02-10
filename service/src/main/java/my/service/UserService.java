package my.service;


import my.dto.user.UserRequestDto;
import my.dto.user.UserResponseDto;
import my.model.order.OrderStatus;
import org.springframework.security.access.annotation.Secured;

import java.util.List;


public interface UserService {

    UserResponseDto addUser(UserRequestDto userRequestDto);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    UserResponseDto updateUser(UserRequestDto updatedUser);

    @Secured("ROLE_ADMIN")
    void deleteUser(Integer id);

    @Secured("ROLE_ADMIN")
    long countAllUsers();

    @Secured("ROLE_ADMIN")
    List<UserResponseDto> findAllUsersPageable(int page, int size);

    @Secured("ROLE_ADMIN")
    long countAllUsersByOrderStatus(OrderStatus orderStatus);

    @Secured("ROLE_ADMIN")
    List<UserResponseDto> findAllUsersByOrderStatusPageable(OrderStatus orderStatus, int page, int size);

    @Secured("ROLE_ADMIN")
    UserResponseDto findUserById(Integer userId);

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    UserResponseDto findUser();
}
