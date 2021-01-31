package guru.spring.framework.springwebapp2.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.spring.framework.springwebapp2.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
