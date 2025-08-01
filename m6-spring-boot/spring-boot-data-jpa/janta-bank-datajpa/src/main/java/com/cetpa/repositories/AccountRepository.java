package com.cetpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.models.Account;

import jakarta.transaction.Transactional;

public interface AccountRepository extends JpaRepository<Account,Integer>
{
	@Query("select accountno from Account where userid=:arg")
	int findByUserid(@Param("arg") String userid);

	@Query("select amount from Account where accountno=:arg")
	int getAmountById(@Param("arg") int accountno);

	@Modifying
	@Transactional
	@Query("update Account set amount=amount+:arg1 where accountno=:arg2")
	void updateAmount(@Param("arg1")int amount,@Param("arg2")int accountno);

	@Query("select concat(firstname,' ',lastname) from Account a join User u on a.userid=u.userid where a.accountno=:arg")
	String getNameByAccountno(@Param("arg") int accountno);
}
