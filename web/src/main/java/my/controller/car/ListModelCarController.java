package my.controller.car;


import lombok.RequiredArgsConstructor;
import my.dao.ModelCarRepository;
import my.dto.car.BrandCarDto;
import my.dto.car.ModelCarDto;
import my.service.BrandCarService;
import my.service.ModelCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Secured({"ROLE_ADMIN"})
public class ListModelCarController {

    private final BrandCarService brandCarService;
    private final ModelCarService modelCarService;

    @GetMapping("model-list.view")
    public String ModelListView(Model model){
        Map<Integer, String> brandCars = brandCarService.findAllBrandsCarPages(0, 100).stream()
                .collect(Collectors.toMap(BrandCarDto::getId, BrandCarDto::getBrandName));

        BrandCarDto currentBrandCar = new BrandCarDto();
        List<ModelCarDto> modelCars;

        if (brandCars.size() > 0) {
            Map.Entry<Integer, String> firstBrand = brandCars.entrySet().iterator().next();

            currentBrandCar.setId(firstBrand.getKey());
            currentBrandCar.setBrandName(firstBrand.getValue());

            modelCars = modelCarService.findAllModelsPagesByBrandCar(currentBrandCar.getId(), 0, 100);
        } else {
            modelCars = new ArrayList<>();
        }

        model.addAttribute("brand", currentBrandCar);
        model.addAttribute("brands", brandCars);
        model.addAttribute("models", modelCars);
        return "car/list_model";

    }


}
