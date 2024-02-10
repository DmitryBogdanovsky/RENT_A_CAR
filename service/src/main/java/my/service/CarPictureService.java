package my.service;


import my.model.car.CarPicture;

import java.util.List;
import java.util.UUID;

public interface CarPictureService {

    byte[] getPicture(Integer pictureId);

    List<Integer> getPictureIdByCarId(Integer carId);

}
