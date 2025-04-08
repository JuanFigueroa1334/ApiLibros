/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiLibros.ApiLibros.Autores;

import com.ApiLibros.ApiLibros.books.Book;
import java.util.List;
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
@RequestMapping("/api/autores")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;
    
    @GetMapping
    public List<Autor> getAllAutores(){
        return autorRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable Long id){
        return autorRepository.findById(id).get();
    }
    
    @PostMapping
    public Autor createAutor(@RequestBody Autor autor){
        return autorRepository.save(autor);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAutor(@PathVariable Long id){
        return autorRepository.findById(id).map(autor ->{
            autorRepository.delete(autor);
            return ResponseEntity.ok("Libro eliminado exitosamente");
        }).orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody Autor updateAutor){
        return autorRepository.findById(id).map(autor ->{
            autor.setNombre(updateAutor.getNombre());
            return ResponseEntity.ok(autorRepository.save(autor));
            
        }).orElse(ResponseEntity.notFound().build());
    }
}