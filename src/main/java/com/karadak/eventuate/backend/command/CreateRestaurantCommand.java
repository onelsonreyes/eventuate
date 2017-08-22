package com.karadak.eventuate.backend.command;

import com.karadak.eventuate.backend.model.CreateRestaurantRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateRestaurantCommand implements RestaurantCommand {
    private CreateRestaurantRequest createRestaurantRequest;
}
