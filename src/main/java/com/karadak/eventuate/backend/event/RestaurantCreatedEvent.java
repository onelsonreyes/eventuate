package com.karadak.eventuate.backend.event;

import com.karadak.eventuate.backend.model.CreateRestaurantRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantCreatedEvent extends RestaurantEvent {
    private CreateRestaurantRequest createRestaurantRequest;

}
