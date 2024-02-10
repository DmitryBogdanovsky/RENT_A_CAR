package my.controller.car;


import lombok.RequiredArgsConstructor;
import my.controller.MessageBox;
import my.dto.car.BrandCarDto;
import my.dto.car.ModelCarDto;
import my.service.BrandCarService;
import my.service.ModelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@Secured("ROLE ADMIN")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EditModelCarsController {

    private  final BrandCarService brandCarService;
    private final ModelCarService modelCarService;

    @GetMapping("/modelCar-edit/{modelCarId}")
    public String EditModelCarsForm(@PathVariable(required = true) Integer modelCarId, Model model){
        model.addAttribute("model", modelCarService.findModelCarById(modelCarId));
        model.addAttribute("brands", brandCarService.findAllBrandsCarPages(0, 100).stream()
                .collect(Collectors.toMap(BrandCarDto::getId, BrandCarDto::getBrandName)));

        return "car/edit_model";
    }

    @PostMapping("/modelCar-edit/{modelCarId}")
    public String editModel(@PathVariable(required = true) Integer modelCarId,
                            @Valid @ModelAttribute("model") ModelCarDto updatedModelCarDTO,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "car/edit_modelCar";

        updatedModelCarDTO.setId(modelCarId);
        modelCarService.updateModelCar(updatedModelCarDTO);

        model.addAttribute("messageBox",
                new MessageBox("model.edit.success", "model.edit.success_full", MessageBox.MessageBoxType.SUCCESS));
        return "message_box";
    }

}
