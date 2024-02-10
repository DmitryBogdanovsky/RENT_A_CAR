package my.dto.order;

import lombok.*;
import my.dto.car.CarDto;
import my.dto.user.UserResponseDto;
import my.model.order.OrderStatus;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private Integer id;

    private LocalDate dateOfOrder;

    private LocalDate startDate;

    private LocalDate endDate;

    private BigDecimal totalPrice;

    @NotNull
    private OrderStatus orderStatus;

    private UserResponseDto user;

    private CarDto car;

}
