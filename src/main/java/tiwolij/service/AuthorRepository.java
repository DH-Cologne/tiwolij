package tiwolij.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import tiwolij.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	public Author findById(int id);

	public Author findBySlug(String slug);

	public List<Author> findAll();

}
