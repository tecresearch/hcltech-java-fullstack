package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.entity.User;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Integer>
{
    //Optional<UserInfo> findByEmail(String email); // Use 'email' if that is the correct field for login
	@Query("from User where name=:arg")
    User findByName(@Param("arg") String name); // Use 'name' if that is the correct field for login
}