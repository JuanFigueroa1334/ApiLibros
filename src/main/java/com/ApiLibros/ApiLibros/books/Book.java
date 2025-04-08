/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ApiLibros.ApiLibros.books;

import com.ApiLibros.ApiLibros.Autores.Autor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author User
 */
@Entity
@Table(name="libros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name="titulo")
    private String titulo;
    
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;
    
    @Column(name="anio_publicacion")
    private int yearpublication;
    
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public Autor getAutor(){
        return autor;
    }
    public void setAutor(Autor autor){
        this.autor = autor;
    }
     public int getYear_publication(){
        return this.yearpublication;
    }
    public void setYear_publication(int yearpublication){
        this.yearpublication = yearpublication;
    }
}
