package book.catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import book.catalogue.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
