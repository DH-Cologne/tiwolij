package tiwolij.service.author;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import tiwolij.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	public Author findTop1ById(Integer authorId);

	public Author findTop1BySlug(String slug);

	public Author findTop1ByWikidataId(Integer wikidataId);

	public List<Author> findAll();

	// pagination

	public Page<Author> findAll(Pageable pageable);

}
