package pl.altkom.scah.ownerservice.controller.mapper;

import pl.altkom.scah.ownerservice.controller.model.CreateOwnerRequest;
import pl.altkom.scah.ownerservice.controller.model.UpdateOwnerRequest;
import pl.altkom.scah.ownerservice.repository.model.Owner;

public class RequestMapper {

    public static Owner bind(final CreateOwnerRequest request) {
        final Owner owner = new Owner();
        owner.setFirstName(request.getFirstName());
        owner.setLastName(request.getLastName());
        owner.setPhone(request.getPhone());
        return owner;
    }

    public static Owner bind(final UpdateOwnerRequest request, final Owner destination) {
        destination.setFirstName(request.getFirstName());
        destination.setLastName(request.getLastName());
        destination.setPhone(request.getPhone());
        return destination;
    }
}
