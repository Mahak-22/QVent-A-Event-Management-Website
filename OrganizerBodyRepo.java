package com.example.qvent.repo;

import com.example.qvent.model.AddOrganizingBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerBodyRepo extends JpaRepository<AddOrganizingBody, Integer> {
}
