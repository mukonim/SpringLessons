package guru.spring.framework.springwebapp2.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.spring.framework.springwebapp2.domain.Author;
import guru.spring.framework.springwebapp2.domain.Book;
import guru.spring.framework.springwebapp2.repositories.AuthorRepository;
import guru.spring.framework.springwebapp2.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner
{

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;	
	
	public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository) {
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	public void run(String... args)
	{

		Author mukoni = new Author("mukoni", "munzhelele");
		Author neo = new Author("Neo", "Munzhelele");

		Book artOfLearning = new Book("Art of Learning", "12331");
		Book artOfLearningAdvanced = new Book("Art of Learning Advanced", "44123");
		
		


		mukoni.getBooks().add(artOfLearningAdvanced);
		neo.getBooks().add(artOfLearning);
		bookRepository.save(artOfLearning);
		bookRepository.save(artOfLearningAdvanced);
		
		artOfLearningAdvanced.getAuthors().add(mukoni);
		artOfLearning.getAuthors().add(neo);
		
		authorRepository.save(mukoni);
		authorRepository.save(neo);
		
		


		
		
		System.out.println("Data updated");
		System.out.println("Number of authors:"+authorRepository.count());
		System.out.println("Number of books:"+bookRepository.count());
	}

}
