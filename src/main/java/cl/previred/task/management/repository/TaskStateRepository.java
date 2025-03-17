package cl.previred.task.management.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cl.previred.task.management.entities.TaskState;

@RepositoryRestResource(path = "taskStates", collectionResourceRel = "taskStates")
public interface TaskStateRepository extends ListCrudRepository<TaskState, Long> {

}