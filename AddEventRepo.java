package com.example.qvent.repo;

import com.example.qvent.model.AddEventDetails;
import com.example.qvent.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddEventRepo extends JpaRepository<AddEventDetails, Integer>
{
    List<AddEventDetails> findByOrganizer(Users organizer);
    List<AddEventDetails> findByOrganizerIdNot(int userId);
}
