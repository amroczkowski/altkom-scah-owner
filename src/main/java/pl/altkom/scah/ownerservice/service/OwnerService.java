package pl.altkom.scah.ownerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.altkom.scah.ownerservice.controller.mapper.ResponseMapper;
import pl.altkom.scah.ownerservice.controller.model.CreateOwnerRequest;
import pl.altkom.scah.ownerservice.controller.model.Owner;
import pl.altkom.scah.ownerservice.controller.model.UpdateOwnerRequest;

@Service
public class OwnerService {

    public List<Owner> getOwners() {
        final List<pl.altkom.scah.ownerservice.repository.model.Owner> owners = null; // Get owners from db
        return ResponseMapper.map(owners);
    }

    public Owner getOwner(final Long ownerId) {
        final pl.altkom.scah.ownerservice.repository.model.Owner owner = null; // Get owner from db
        return ResponseMapper.map(owner);
    }

    public Owner createOwner(final CreateOwnerRequest request) {
        final pl.altkom.scah.ownerservice.repository.model.Owner savedOwner = null; // Save owner to db
        return ResponseMapper.map(savedOwner);
    }

    public Owner updateOwner(final Long ownerId, final UpdateOwnerRequest request) {

        final pl.altkom.scah.ownerservice.repository.model.Owner sourceOwner = null; // Get owner from db

        final pl.altkom.scah.ownerservice.repository.model.Owner modifiedOwner = null; //Update owner in db
        return ResponseMapper.map(modifiedOwner);
    }
}
