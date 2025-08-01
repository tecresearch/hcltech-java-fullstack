package com.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.security.entity.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> 
{
    //Optional<UserInfo> findByEmail(String email); // Use 'email' if that is the correct field for login
	@Query("from UserInfo where name=:arg")
	UserInfo findByName(@Param("arg") String name); // Use 'name' if that is the correct field for login
}