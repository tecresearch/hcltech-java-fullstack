/*
 * In Hibernate, operations are typically categorized based on how they interact with the database and the persistence context. Here’s a list of commonly used Hibernate methods grouped by their purpose:

1. CRUD Operations
These are the basic operations for managing entities:

save() – Inserts a new record into the database.
persist() – Similar to save(), but follows JPA specifications more strictly.
update() – Updates an existing record.
merge() – Merges changes from a detached entity into the persistent context.
delete() – Removes an entity from the database.
get() – Fetches an entity by its primary key (returns null if not found).
load() – Fetches an entity lazily (throws exception if not found).
---------------------------------------------------------------------------------
1. save(Object entity)
Purpose: Inserts a new record into the database.
Return Type: Serializable
Details: Returns the identifier (primary key) of the saved entity.
2. persist(Object entity)
Purpose: Makes a transient instance persistent.
Return Type: void
Details: Does not return the identifier. Throws an exception if the entity already exists.
3. update(Object entity)
Purpose: Updates an existing persistent entity.
Return Type: void
Details: Used to reattach a detached entity to the session.
4. merge(Object entity)
Purpose: Merges the state of a detached entity into the current persistence context.
Return Type: <T> T (the managed instance that the state was merged into)
Details: Returns a persistent instance with the updated state.
5. delete(Object entity)
Purpose: Removes the entity from the database.
Return Type: void
Details: Deletes the record corresponding to the entity.
6. get(Class<T> entityClass, Serializable id)
Purpose: Fetches an entity by its primary key.
Return Type: <T> T
Details: Returns the entity or null if not found. Performs an immediate database hit.
7. load(Class<T> entityClass, Serializable id)
Purpose: Lazily fetches an entity by its primary key.
Return Type: <T> T
Details: Returns a proxy. Throws ObjectNotFoundException if the entity doesn’t exist when accessed.
--------------------------------------------------------------------------------------------------------
2. Querying Data
Hibernate provides multiple ways to query data:

HQL (Hibernate Query Language):
createQuery("from EntityName")
Criteria API (deprecated in favor of JPA Criteria API):
createCriteria(Entity.class)
Native SQL:
createSQLQuery("SELECT * FROM table_name")
Named Queries:
Defined in entity classes using annotations like @NamedQuery

3. Session Management
These methods manage the Hibernate session lifecycle:

openSession() – Opens a new session.
getCurrentSession() – Returns the current session bound to the context.
beginTransaction() – Starts a transaction.
commit() – Commits the transaction.
rollback() – Rolls back the transaction.
close() – Closes the session.

4. Caching
Hibernate supports first-level and second-level caching:

evict() – Removes an object from the first-level cache.
clear() – Clears the session cache.
flush() – Synchronizes session state with the database.

5. Object State Transitions
These methods help manage entity states:

Transient – Not associated with any session.
Persistent – Associated with a session and tracked.
Detached – Was associated but now disconnected.
 */

package com.hcl.employee.repository;

import com.hcl.employee.model.Employee;

public interface EmployeeRepository {

	public void save(Employee employee);
	public void persist(Employee employee);
	public void update(Employee employee);
	public void delete(Employee employee);
	public Employee get(int id);
	
}
