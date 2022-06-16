package pl.altkom.scah.ownerservice.client;

import java.util.List;

import pl.altkom.scah.ownerservice.client.model.Dog;

public interface DogClient {

    List<Dog> getOwnerDogs(final Long ownerId);
    List<Dog> getDogs();
}
