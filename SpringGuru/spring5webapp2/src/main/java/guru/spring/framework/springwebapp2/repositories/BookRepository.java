package guru.spring.framework.springwebapp2.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.spring.framework.springwebapp2.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

}
