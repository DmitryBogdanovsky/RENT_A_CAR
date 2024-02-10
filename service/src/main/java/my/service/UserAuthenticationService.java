package my.service;

import my.dto.user.UserAuthenticationDto;

public interface UserAuthenticationService {
    UserAuthenticationDto findUserByEmail(String username);
}
