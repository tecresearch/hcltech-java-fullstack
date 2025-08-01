package com.cetpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cetpa.models.TransactionInfo;

public interface TransactionRepository extends JpaRepository<TransactionInfo,Integer>
{
	@Query("from TransactionInfo where (fromaccount=:arg1 and toaccount=:arg1) or (fromaccount=:arg1 and type='Debit') or (toaccount=:arg1 and type='Credit')")
	List<TransactionInfo> getList(@Param("arg1") int accountno);
}
