
package cl.previred.task.management.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cl.previred.task.management.entities.Task;

@RepositoryRestResource(path = "tasks", collectionResourceRel = "tasks")
public interface TaskRepository extends ListCrudRepository<Task, Long> {

}