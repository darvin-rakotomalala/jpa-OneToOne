package com.poc.repository;

import com.poc.model.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u WHERE lower(u.firstName) LIKE lower(concat('%', :searchText,'%')) OR lower(u.lastName) LIKE lower(concat('%', :searchText,'%'))")
    Page<User> findBySearchText(@Param("searchText") String searchText, Pageable page);

    /*@Query("SELECT new com.poc.donnee.dto.view.UserView(u.firstName, u.lastName, u.email, up.phoneNumber, up.gender, up.address) " +
            "FROM User u JOIN UserProfile up ON u.id = up.user.id")
    Page<UserView> joinSearchText(Pageable page);

    @Query("SELECT new com.poc.donnee.dto.view.UserView(u.firstName, u.lastName, u.email, up.phoneNumber, up.gender, up.address) " +
            "FROM User u JOIN UserProfile up ON u.id = up.user.id " +
            "WHERE lower(u.firstName) LIKE lower(concat('%', :searchText,'%')) OR lower(u.lastName) LIKE lower(concat('%', :searchText,'%'))")
    Page<UserView> joinSearchTextPaged(@Param("searchText") String searchText, Pageable page);*/

}
