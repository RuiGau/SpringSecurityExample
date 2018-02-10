package com.example.demo.data_access;

import com.example.demo.models.ApplicationUser;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ApplicationUserRepository extends PagingAndSortingRepository<ApplicationUser, Long> {
    public ApplicationUser findByEmail(String email);
}
