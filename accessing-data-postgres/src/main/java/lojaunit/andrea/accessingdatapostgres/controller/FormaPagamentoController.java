package lojaunit.andrea.accessingdatapostgres.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import lojaunit.andrea.accessingdatapostgres.model.FormaPagamento;
import lojaunit.andrea.accessingdatapostgres.repository.FormaPagamentoRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/formaPagamento") // This means URL's start with /demo (after Application path)
public class FormaPagamentoController {
	
	@Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
	private FormaPagamentoRepository formaPagamentoRepository;
	
@PostMapping// Map ONLY POST Requests
	  public @ResponseBody String addNewFormaPagamento (@RequestBody FormaPagamento formaPagamento) {
		  
	    // @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

	   	formaPagamentoRepository.save(formaPagamento);
	    return "Salvo";
	        
	  }

	  @GetMapping(path="/all")
	  public @ResponseBody Iterable<FormaPagamento> getAllFormaPagamento() {
	    // This returns a JSON or XML with the users
	    return formaPagamentoRepository.findAll();
	  }
	  @GetMapping(path="/find/{id}")
	  public @ResponseBody Optional<FormaPagamento> findById(@RequestParam Integer idFormaPagamento) {
	    // This returns a JSON or XML with this user
	    return formaPagamentoRepository.findById(idFormaPagamento);
	  }
	  @DeleteMapping(path="/delete/{id}")
	  @ResponseStatus (code = HttpStatus.ACCEPTED)
	  public @ResponseBody String deleteById(@PathVariable Integer id) {
	    // This returns a JSON or XML with this user
		  
		  if (formaPagamentoRepository.findById(id) == null) {
			  return "Não encontrado";
		  }
		  formaPagamentoRepository.deleteById(id);
		  return "Removido";
		  }
	  @PutMapping(path="/update/{id}")
	  public @ResponseBody String PutById(@PathVariable Integer id, @RequestBody FormaPagamento formaPagamento) {
		  
		  if (formaPagamentoRepository.findById(id) == null) {
			  return "Não encontrado";
		  }
		  
		  FormaPagamento n = formaPagamentoRepository.findById(id).get();
		    n.setForma(formaPagamento.getForma());
		    n.setDescricao(formaPagamento.getDescricao());
		    n.setAtivo(formaPagamento.getAtivo());
		      		    
		    formaPagamentoRepository.save(n);
		    return "Salvo";
	  }
	}