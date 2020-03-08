package com.dp.micro.brewry.dpmsscbrewry.web.model;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private UUID id;
    private String name;
}
