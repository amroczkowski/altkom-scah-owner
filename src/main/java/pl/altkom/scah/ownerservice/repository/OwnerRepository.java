package pl.altkom.scah.ownerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.scah.ownerservice.repository.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}