package guru.spring.framework.springwebapp2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.spring.framework.springwebapp2.repositories.BookRepository;

@Controller
public class BooksController {

	private final BookRepository bookRepository;
	
	public BooksController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@RequestMapping("/test")
	public String doSomething(Model model)
	{
		model.addAttribute("books", bookRepository.findAll());
		return "books/list";
	}}
