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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Secured("ROLE_ADMIN")
public class EditBrandController {
    @Autowired
    BrandCarService brandCarService;

    @GetMapping("/brand-edit/{brandId}.view")
    public String editBrandForm(@PathVariable(required = true) Integer brandId, Model model) {
        BrandCarDto brandCarDto = brandCarService.findBrandCarById(brandId);

        model.addAttribute("brand", brandCarDto);

        return "car/edit_brand";
    }

    @PostMapping("/brand-edit/{brandId}.action")
    public String editBrand(@PathVariable(required = true) Integer brandId,
                             @ModelAttribute("brand") BrandCarDto updateBrand,
                            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors())
            return "car/edit_brand";

        updateBrand.setId(brandId);
        brandCarService.updateBrandCar(updateBrand);
        System.out.println("brand update successfully .............");
        model.addAttribute("messageBox",
                new MessageBox("brand.update", "brand update successfully .............", MessageBox.MessageBoxType.SUCCESS));
        return "message_box";
    }
}
