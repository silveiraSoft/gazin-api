package com.adalbertosn.domain.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	@Column(nullable=false,length = 200)
	private String nome;
	
	@Column(nullable=false,length = 1)
	private String sexo;
	
	@Column(nullable=false)
	private Integer idade;
	
	@Column(nullable=false,length = 500)
	private String hobby;
	
	@Column(nullable=false,length = 500)
	private Date dataNacimento;
	
	
	
}
