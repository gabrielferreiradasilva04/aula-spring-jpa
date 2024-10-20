package com.github.gabrielferreiradasilva04.librayapi.model;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "autor", schema = "public")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id")
	private UUID id;
	@Column(name = "nome", nullable = false, length = 100)
	private String nome;
	@Column(name = "nacionalidade", length = 50, nullable = false)
	private String nacionalidade;
	@Column(name = "data_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
}
