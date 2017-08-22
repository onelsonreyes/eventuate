package com.karadak.eventuate.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateRestaurantRequest {
    private String name;
    private String notificationEmailAddress;
    private String type;
}
