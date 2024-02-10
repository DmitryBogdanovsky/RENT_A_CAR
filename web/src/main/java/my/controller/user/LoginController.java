package my.controller.user;

import my.controller.MessageBox;
import my.dto.user.UserDetailsDto;
import my.dto.user.UserRequestDto;
import my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login.view")
    public String loginPage() {
        return "users/login";
    }

    @GetMapping("/registration.action")
    public String regUserForm(Model model) {
        model.addAttribute("user", new UserRequestDto(new UserDetailsDto()));
        return "users/login";
    }

    @PostMapping(value = "registration.action")
    public String registrationUser(@ModelAttribute("user") UserRequestDto userRequestDto,
                                   BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors())
            return "users/login";

        userService.addUser(userRequestDto);

        System.out.println("User registration was successfully ........");

        model.addAttribute("messageBox",
                new MessageBox("New user added", "Registration was successfully ........", MessageBox.MessageBoxType.SUCCESS));
        return "message_box";

    }
}