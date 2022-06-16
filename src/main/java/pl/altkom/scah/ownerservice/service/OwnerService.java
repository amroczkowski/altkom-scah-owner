package pl.altkom.scah.ownerservice.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pl.altkom.scah.ownerservice.client.DogClient;
import pl.altkom.scah.ownerservice.controller.mapper.RequestMapper;
import pl.altkom.scah.ownerservice.controller.mapper.ResponseMapper;
import pl.altkom.scah.ownerservice.controller.model.CreateOwnerRequest;
import pl.altkom.scah.ownerservice.controller.model.Dog;
import pl.altkom.scah.ownerservice.controller.model.Owner;
import pl.altkom.scah.ownerservice.controller.model.UpdateOwnerRequest;
import pl.altkom.scah.ownerservice.repository.OwnerRepository;

@RequiredArgsConstructor
@Service
public class OwnerService {

    private final DogClient dogClient;
    private final OwnerRepository ownerRepository;

    public List<Owner> getOwners() {
        final List<Dog> dogs = pl.altkom.scah.ownerservice.client.mapper.ResponseMapper.map(dogClient.getDogs());
        final List<pl.altkom.scah.ownerservice.repository.model.Owner> owners = ownerRepository.findAll();
        return ResponseMapper.map(owners, dogs);
    }

    public Owner getOwner(final Long ownerId) {
        final pl.altkom.scah.ownerservice.repository.model.Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        final List<Dog> dogs = pl.altkom.scah.ownerservice.client.mapper.ResponseMapper.map(dogClient.getOwnerDogs(owner.getId()));
        return ResponseMapper.map(owner, dogs);
    }

    public Owner createOwner(final CreateOwnerRequest request) {
        final pl.altkom.scah.ownerservice.repository.model.Owner savedOwner = ownerRepository.save(RequestMapper.bind(request));
        return ResponseMapper.map(savedOwner, List.of());
    }

    public Owner updateOwner(final Long ownerId, final UpdateOwnerRequest request) {

        final pl.altkom.scah.ownerservice.repository.model.Owner sourceOwner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        final pl.altkom.scah.ownerservice.repository.model.Owner modifiedOwner = ownerRepository
                .save(RequestMapper.bind(request, sourceOwner));
        final List<Dog> dogs = pl.altkom.scah.ownerservice.client.mapper.ResponseMapper
                .map(dogClient.getOwnerDogs(modifiedOwner.getId()));
        return ResponseMapper.map(modifiedOwner, dogs);
    }
}