package my.controller.car;

import lombok.RequiredArgsConstructor;
import my.service.BrandCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListBrandController {
    @Autowired
    BrandCarService brandCarService;

    @GetMapping("brand-list.view")
    public String brandList(Model model, @RequestParam(value = "page", required = false, defaultValue = "1") int page) {
        model.addAttribute("page", page);
        model.addAttribute("pages", (brandCarService.countAllBrandsCar() - 1) / 5 + 1);
        model.addAttribute("brands", brandCarService.findAllBrandsCarPages(page - 1, 5));
        return "car/list_brand";

    }

}
