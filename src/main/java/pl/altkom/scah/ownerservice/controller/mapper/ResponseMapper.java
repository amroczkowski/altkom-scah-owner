package pl.altkom.scah.ownerservice.controller.mapper;

import java.util.List;
import java.util.stream.Collectors;

import pl.altkom.scah.ownerservice.controller.model.Dog;
import pl.altkom.scah.ownerservice.repository.model.Owner;

public class ResponseMapper {
    public static List<pl.altkom.scah.ownerservice.controller.model.Owner> map(final List<Owner> owners, final List<Dog> dogs) {
        return owners.stream()
                .map(owner -> map(owner,
                        dogs.stream().filter(d -> d.getOwnerId().equals(owner.getId())).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public static pl.altkom.scah.ownerservice.controller.model.Owner map(final Owner owner, final List<Dog> dogs) {

        final pl.altkom.scah.ownerservice.controller.model.Owner result = new pl.altkom.scah.ownerservice.controller.model.Owner();
        result.setId(owner.getId());
        result.setFirstName(owner.getFirstName());
        result.setLastName(owner.getLastName());
        result.setPhone(owner.getPhone());
        result.setDogs(dogs);

        return result;
    }
}
