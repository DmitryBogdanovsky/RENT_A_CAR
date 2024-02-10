package my.controller.user;

import my.controller.MessageBox;
import my.dto.user.UserRequestDto;
import my.dto.user.UserResponseDto;
import my.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Secured({"ROLE_ADMIN", "ROLE_USER"})
public class EditUserController {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserService userService;

//    @GetMapping("/edit-userProfile/{userId}.view")
//    public String userProfile(Model model) {
//
//        UserResponseDto userResponseDto = userService.findUser();
//        model.addAttribute("user", userResponseDto);
//        System.out.println("Get mapping:" + userResponseDto);
//        return "users/edit_user_profile";
//    }

    @GetMapping("/edit-userProfile/{userId}.view")
    public String editUserProfile(@PathVariable Integer userId, Model model) {
        UserResponseDto user = userService.findUserById(userId);
        model.addAttribute("user", new UserRequestDto(
                user.getId(),
                user.getEmail(),
                "",
                user.getUserDetails()
        ));
        System.out.println("Get mapping:" + user);
        return "users/edit_user_profile";
    }

    @PostMapping("/edit-userProfile/{userId}.action")
    public String editUser(@PathVariable(required = true) Integer userId,
                           @ModelAttribute("user") UserRequestDto updateUser,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "edit_user_profile";
        updateUser.setId(userId);
        userService.updateUser(updateUser);
        System.out.println("User updated was successfully ........");

        model.addAttribute("messageBox",
                new MessageBox("User updated", "updated was successfully ........", MessageBox.MessageBoxType.SUCCESS));
        return "message_box";
    }

}
