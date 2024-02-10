package my.controller;

import my.exception.MyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler(value = MyException.class)
    public String exceptionHandler(Model model, Exception exception) {
        model.addAttribute("exceptionCaption", exception.getClass().getSimpleName());
        model.addAttribute("exceptionBody", exception.getMessage());

        return "exception_box";
    }
}
