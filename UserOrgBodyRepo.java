package com.example.qvent.repo;

import com.example.qvent.model.UserOrganizingBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserOrgBodyRepo extends JpaRepository<UserOrganizingBody, Integer>
{

}
