package my.controller.car;


import lombok.RequiredArgsConstructor;
import my.controller.MessageBox;
import my.dto.car.CarDto;
import my.dto.order.OrderRequestDto;
import my.dto.user.UserResponseDto;
import my.service.CarPictureService;
import my.service.CarService;
import my.service.OrderService;
import my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ShowCarController {
    private final CarService carService;
    private final CarPictureService carPictureService;
    private final OrderService orderService;
    private final UserService userService;

    @GetMapping("/car-show/{carId}")
    String showCar(@PathVariable(required = true) Integer carId, Model model) {
        CarDto carDto = carService.findCarById(carId);
        List<Integer> imageCars = carPictureService.getPictureIdByCarId(carId);

        OrderRequestDto orderRequestDto = new OrderRequestDto();
        // TODO: do we need it?
//        orderRequestDto.setCarId(new CarDto(carId));
//        orderRequestDto.setCarId(new CarDto(carId));

        model.addAttribute("car", carDto);
        model.addAttribute("images", imageCars);
        model.addAttribute("order", orderRequestDto);

        return "car/show_car";
    }

    @PostMapping("/car-show/{carId}")
    String orderForm(@PathVariable(required = true) Integer carId, Model model,
                     @Valid @ModelAttribute("order") OrderRequestDto orderRequest, BindingResult bindingResult) {
        UserResponseDto user = userService.findUserById(carId);
        boolean isUserBusy = orderService.isUserBusyForOrder(user.getId(),
                orderRequest.getStartDate(), orderRequest.getEndDate());
        if (isUserBusy)
            model.addAttribute("userBusyError", true);

        boolean isCarBusy = orderService.isCarBusyForOrder(carId,
                orderRequest.getStartDate(), orderRequest.getEndDate());
        if (isCarBusy)
            model.addAttribute("carBusyError", true);

        if (bindingResult.hasErrors() || isUserBusy || isCarBusy) {
            CarDto carDto = carService.findCarById(carId);
            List<Integer> images = carPictureService.getPictureIdByCarId(carId);

            model.addAttribute("car", carDto);
            model.addAttribute("images", images);

            return "car/show_car";
        }

//        orderRequest.setCarId(new CarDto(carId));
        orderService.addOrder(orderRequest);

        model.addAttribute("messageBox",
                new MessageBox("order.success", "order.success_full", MessageBox.MessageBoxType.SUCCESS));
        return "message_box";
    }

    @ResponseBody
    @GetMapping(value = "/car-image/{imageCarId}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable Integer imageCarId) {
        return carPictureService.getPicture(imageCarId);
    }


}
