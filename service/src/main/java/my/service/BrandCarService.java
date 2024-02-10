package my.service;


import my.dto.car.BrandCarDto;


import java.util.List;


public interface BrandCarService {


    BrandCarDto addBrand(BrandCarDto brandCarDto);


    BrandCarDto updateBrandCar(BrandCarDto updatedBrandCar);


    void deleteBrandCar(Integer id);


    BrandCarDto findBrandCarById(Integer id);

    long countAllBrandsCar();

    List<BrandCarDto> findAllBrandsCarPages(int page, int size);

}
