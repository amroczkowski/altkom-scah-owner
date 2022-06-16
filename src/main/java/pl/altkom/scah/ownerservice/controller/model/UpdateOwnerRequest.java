package pl.altkom.scah.ownerservice.controller.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UpdateOwnerRequest {

    private String firstName;
    private String lastName;
    private String phone;
}
