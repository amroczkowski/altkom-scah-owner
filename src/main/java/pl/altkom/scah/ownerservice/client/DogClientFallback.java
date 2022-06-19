package pl.altkom.scah.ownerservice.client;

import java.util.List;

import org.springframework.stereotype.Component;

import pl.altkom.scah.ownerservice.client.model.Dog;

@Component
public class DogClientFallback implements DogClient {

    public List<Dog> getOwnerDogs(final Long ownerId) {
        throw new IllegalStateException("Dog service not responding. Please try again later.");
    }

    public List<Dog> getDogs() {
        throw new IllegalStateException("Dog service not responding. Please try again later.");
    }
}
