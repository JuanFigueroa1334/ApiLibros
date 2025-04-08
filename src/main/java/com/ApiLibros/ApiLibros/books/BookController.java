/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiLibros.ApiLibros.books;

import com.ApiLibros.ApiLibros.Autores.Autor;
import com.ApiLibros.ApiLibros.Autores.AutorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    private AutorRepository autorRepository;
    
    @GetMapping
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookRepository.findById(id).get();
    }
    
    @PostMapping
    public Book createBook(@RequestBody Book book){
        return bookRepository.save(book);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return bookRepository.findById(id).map(book ->{
            bookRepository.delete(book);
            return ResponseEntity.ok("Libro eliminado exitosamente");
        }).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updateBook){
        return bookRepository.findById(id).map(book ->{
            book.setTitulo(updateBook.getTitulo());
            book.setAutor(updateBook.getAutor());
            book.setYear_publication(updateBook.getYear_publication());
            return ResponseEntity.ok(bookRepository.save(book));
            
        }).orElse(ResponseEntity.notFound().build());
    }
    
}
