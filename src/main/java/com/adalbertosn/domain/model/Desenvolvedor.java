package com.adalbertosn.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Desenvolvedor {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable=false,length = 255)
	private String nome;
	
	@NotNull
	@Column(nullable=false,length = 1)
	private String sexo;
	
	@NotNull
	@Column(nullable=false)
	private Integer idade;
	
	@NotNull
	@Column(nullable=false,length = 255)
	private String hobby;
	
	@NotNull
	@Column(nullable=false)
	private LocalDate dataNascimento;
	
	
	
}
