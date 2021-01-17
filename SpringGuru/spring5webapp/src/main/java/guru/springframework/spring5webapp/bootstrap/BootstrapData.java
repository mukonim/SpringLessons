package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner
{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootstrapData(AuthorRepository authors, BookRepository books, PublisherRepository publisherRepository) {
		this.authorRepository = authors;
		this.bookRepository = books;
		this.publisherRepository = publisherRepository;
	}

	public void run(String... args)
	{
		Publisher mukoniBooks = new Publisher("MukoniBooks", "No 1", "Midrand","Gauteng", "2196");
		Publisher neoBooks = new Publisher("NeoBooks", "No 2", "Midrand","Gauteng", "2196");
		
		publisherRepository.save(mukoniBooks);
		publisherRepository.save(neoBooks);
		
		Author mukoni = new Author("Mukoni", "Munzhelele");
		Author neo = new Author("Neo", "Munzhelele");
		
		Book setDefaultSettingToPositive = new Book("Set Your Default Setting To Positive", "123412");
		setDefaultSettingToPositive.getAuthors().add(mukoni);
		setDefaultSettingToPositive.setPublisher(mukoniBooks);		
		mukoniBooks.getBooks().add(setDefaultSettingToPositive);
		mukoni.getBooks().add(setDefaultSettingToPositive);

		
		Book theBestWife = new Book("The Best Wife", "223412");
		theBestWife.getAuthors().add(neo);
		theBestWife.setPublisher(neoBooks);
		neoBooks.getBooks().add(theBestWife);
		neo.getBooks().add(theBestWife);
		
		authorRepository.save(mukoni);
		bookRepository.save(setDefaultSettingToPositive);
		
		authorRepository.save(neo);
		bookRepository.save(theBestWife);
		
		
		System.out.println("The number of authors:"+authorRepository.count());
		System.out.println("The number of books:"+bookRepository.count());
		System.out.println("The number of publishers:"+publisherRepository.count());
	}
}
