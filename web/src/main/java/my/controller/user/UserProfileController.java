package my.controller.user;


import my.dto.user.UserResponseDto;
import my.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class UserProfileController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

    @GetMapping("/user-profile/{userId}.view")
    public String userProfile(Model model) {
        UserResponseDto userResponseDto = userService.findUser();
        model.addAttribute("user", userResponseDto);
        return "users/user_profile";
    }

}

