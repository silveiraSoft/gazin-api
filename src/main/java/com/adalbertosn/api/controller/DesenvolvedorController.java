package com.adalbertosn.api.controller;

//import java.util.ArrayList;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.BeanUtils;

//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.adalbertosn.domain.exception.EntidadeEmUsoException;
import com.adalbertosn.domain.exception.EntidadeNaoEncontradaException;
import com.adalbertosn.domain.model.Desenvolvedor;
import com.adalbertosn.domain.repository.DesenvolvedorRepository;
import com.adalbertosn.domain.service.CadastroDesenvolvedorService;

/**
 * A clase DesenvolvedorController para gerencias os desenvolvedores a partir de Endpoint que usan os metodos seguintes:
 * <strong>GET, POST, PUT, DELETE</strong>
 * @author Adalberto Silveira Napoles
 * 
 */
@RestController
@RequestMapping("/developers")
public class DesenvolvedorController {
	
	@Autowired
	private DesenvolvedorRepository desenvolvedorRepository;
	@Autowired
	private CadastroDesenvolvedorService cadastroDesenvolvedor;
	@CrossOrigin(origins = "http://localhost")
	@GetMapping
	public List<Desenvolvedor> listar() {
		return desenvolvedorRepository.listar();
	}
	/**
	 * Endpoint para obter dados do desenvolvedor inserido no parâmetro
	 * Método GET /developers/{id}
	 * @param desenvolvedorId id do desenvolvedor
	 * @return 404 se não encontrou o desenvolvedor, ou 200 e o dado do desenvolvedores em formato json
	 */
	@CrossOrigin(origins = "http://localhost")
	@GetMapping("/{desenvolvedorId}")
	public ResponseEntity<Desenvolvedor> buscar(@PathVariable("desenvolvedorId") Long desenvolvedorId) {
        Desenvolvedor desenvolvedor = desenvolvedorRepository.buscar(desenvolvedorId);
		
		if (desenvolvedor != null) {
			return ResponseEntity.ok(desenvolvedor);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin(origins = "http://localhost")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public Desenvolvedor adicionar(@RequestBody Desenvolvedor desenvolvedor) {
		return desenvolvedorRepository.salvar(desenvolvedor);
	}
	//@CrossOrigin(originPatterns = "http://localhost/1")
	@CrossOrigin(origins = "http://localhost")
	@PutMapping("/{desenvolvedorId}")
	public ResponseEntity<Desenvolvedor> atualizar(@PathVariable("desenvolvedorId") Long desenvolvedorId,
			@RequestBody Desenvolvedor desenvolvedor) {
		Desenvolvedor desenvolvedorAtual = desenvolvedorRepository.buscar(desenvolvedorId);
		
		if (desenvolvedorAtual != null) {
			BeanUtils.copyProperties(desenvolvedor, desenvolvedorAtual, "id");
			
			desenvolvedorAtual = cadastroDesenvolvedor.salvar(desenvolvedorAtual);
			return ResponseEntity.ok(desenvolvedorAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@CrossOrigin(origins = "http://localhost")
	@DeleteMapping("/{desenvolvedorId}")
	public ResponseEntity<Desenvolvedor> remover(@PathVariable("desenvolvedorId") Long desenvolvedorId) {
		try {
			cadastroDesenvolvedor.excluir(desenvolvedorId);	
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}
