package my.controller.car;

import my.controller.MessageBox;
import my.dto.car.BrandCarDto;
import my.service.BrandCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Secured("ROLE_ADMIN")
public class AddBrandController {

    @Autowired
    BrandCarService brandCarService;

    @GetMapping("brand-add.view")
    public String addBrandForm(Model model) {
        model.addAttribute("brand", new BrandCarDto());

        return "car/add_brand";
    }

    @PostMapping("brand-add.action")
    public String addBrand(@Valid @ModelAttribute("brand") BrandCarDto brandCarDto, BindingResult bindingResult,
                           Model model) {
        if (bindingResult.hasErrors())
            return "car/add_brand";

        brandCarService.addBrand(brandCarDto);

        model.addAttribute("messageBox",
                new MessageBox("BrandCar adding success", "add_brand.success_full", MessageBox.MessageBoxType.SUCCESS));
        return "message_box";
    }
}
