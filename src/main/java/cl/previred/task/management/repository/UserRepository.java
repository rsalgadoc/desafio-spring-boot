package cl.previred.task.management.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cl.previred.task.management.entities.User;

@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserRepository extends ListCrudRepository<User, Long> {
	User findByEmail(String email);

}