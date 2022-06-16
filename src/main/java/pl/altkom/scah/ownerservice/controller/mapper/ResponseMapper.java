package pl.altkom.scah.ownerservice.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.altkom.scah.ownerservice.repository.model.Owner;

public class ResponseMapper {
    public static List<pl.altkom.scah.ownerservice.controller.model.Owner> map(final List<Owner> owners) {
        return owners.stream()
                .map(ResponseMapper::map)
                .collect(Collectors.toList());
    }

    public static pl.altkom.scah.ownerservice.controller.model.Owner map(final Owner owner) {

        final pl.altkom.scah.ownerservice.controller.model.Owner result = new pl.altkom.scah.ownerservice.controller.model.Owner();
        result.setId(owner.getId());
        result.setFirstName(owner.getFirstName());
        result.setLastName(owner.getLastName());
        result.setPhone(owner.getPhone());

        return result;
    }
}
