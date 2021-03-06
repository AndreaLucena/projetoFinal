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

import lojaunit.andrea.accessingdatapostgres.model.Categoria;
import lojaunit.andrea.accessingdatapostgres.repository.CategoriaRepository;


@Controller // This means that this class is a Controller
@RequestMapping(path="/categoria") // This means URL's start with /demo (after Application path)
public class CategoriaController {
	
	 @Autowired // This means to get the bean called userRepository
     // Which is auto-generated by Spring, we will use it to handle the data
	 private CategoriaRepository categoriaRepository;


	 @PostMapping // Map ONLY POST Requests
	 public @ResponseBody String addNewCategoria (@RequestBody Categoria categoria) {
  
// @ResponseBody means the returned String is the response, not a view name
// @RequestParam means it is a parameter from the GET or POST request

		  categoriaRepository.save(categoria);
		  return "Salvo";
		        
		  }

		  @GetMapping
		  public @ResponseBody Iterable<Categoria> getAllCategorias() {
		    // This returns a JSON or XML with the users
		    return categoriaRepository.findAll();
		  }
		  
		  @GetMapping(path="/find/{id}")
		  public @ResponseBody Optional<Categoria> findById(@RequestParam Integer idCategoria) {
		    // This returns a JSON or XML with this user
		    return categoriaRepository.findById(idCategoria);
		  }
		  @DeleteMapping(path="/delete/{id}")
		  @ResponseStatus (code = HttpStatus.ACCEPTED)
		  public @ResponseBody String deleteById(@PathVariable Integer id) {
			  //public @ResponseBody String deleteById @RequestParam Integer idCategoria?) {
		    // This returns a JSON or XML with this user
			  
			  if (categoriaRepository.findById(id) == null) {
				  return "Não encontrado";
			  }
			  categoriaRepository.deleteById(id);
			  return "Removido";
			  }
		  @PutMapping(path="/update/{id}")
		  public @ResponseBody String PutById( @PathVariable Integer id, @RequestBody Categoria categoria) {
		    // This returns a JSON or XML with this user
			  
			  if (categoriaRepository.findById(id) == null) {
				  return "Não encontrado";
			  }
			  
			  Categoria n = categoriaRepository.findById(id).get();
			  
			  n.setNome(categoria.getNome());
			  n.setAtivo(categoria.getAtivo());
			  
			    categoriaRepository.save(n);
			    return "Salvo";
		  }
		  
		}
