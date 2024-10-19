package com.github.gabrielferreiradasilva04.librayapi.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "livro")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private UUID id;
	@Column(name = "titulo")
	private String tiulo;
	@Column(name = "isdn")
	private String isdn;
	@Column(name = "dataPublicacao")
	private LocalDate dataPublicacao;
	@Column(name = "genero")
	private Genero genero;
	@Column(name = "preco")
	private Double preco;
	@OneToMany
	@JoinColumn(name = "autor")
	private Autor autor;
	
}
