package com.poc.repository;

import com.poc.model.domain.UserProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    /*@Query("FROM UserProfile up WHERE lower(up.user.firstName) LIKE lower(concat('%', :searchText,'%')) OR lower(up.user.lastName) LIKE lower(concat('%', :searchText,'%'))")
    Page<UserProfile> findBySearchText(@Param("searchText") String searchText, Pageable page);*/

    Page<UserProfile> findByAddressIgnoreCase(String address, Pageable page);
}
