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

import lojaunit.andrea.accessingdatapostgres.model.Cliente;
import lojaunit.andrea.accessingdatapostgres.repository.ClienteRepository;

@Controller // This means that this class is a Controller
@RequestMapping(path="/cliente") // This means URL's start with /cliente (after Application path)
public class ClienteController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private ClienteRepository clienteRepository;


  @PostMapping// Map ONLY POST Requests
  public @ResponseBody String addNewCliente (@RequestBody Cliente cliente) {
	  
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    clienteRepository.save(cliente);
    return "Salvo";
        
  }

  @GetMapping
  public @ResponseBody Iterable<Cliente> getAllClientes() {
    // This returns a JSON or XML with the users
    return clienteRepository.findAll();
  }
  
  @GetMapping(path="/find/{id}")
  public @ResponseBody Optional<Cliente> findById(@RequestParam Integer idCliente) {
    // This returns a JSON or XML with this user
    return clienteRepository.findById(idCliente);
  }
  @DeleteMapping(path="/delete/{id}")
  @ResponseStatus (code = HttpStatus.ACCEPTED)
  public @ResponseBody String deleteById(@PathVariable Integer id) {
    // This returns a JSON or XML with this user
	  
	  if (clienteRepository.findById(id) == null) {
		  return "Não encontrado";
	  }
	  clienteRepository.deleteById(id);
	  return "Removido";
	  }
  @PutMapping(path="/update/{id}")
  public @ResponseBody String PutById(@PathVariable Integer id, @RequestBody Cliente cliente) {
    // This returns a JSON or XML with this user
	
	  if (clienteRepository.findById(id) == null) {
		  return "Não encontrado";
	  }
	  
	  	Cliente n = clienteRepository.findById(id).get();
	    n.setNome(cliente.getNome());
	    n.setEmail(cliente.getEmail());
	    n.setCpf(cliente.getCpf());
	    n.setDataNascimento(cliente.getDataNascimento());
	    n.setSexo(cliente.getSexo());
	    n.setNomeSocial(cliente.getNomeSocial());
	    n.setApelido(cliente.getApelido());
	    n.setTelefone(cliente.getTelefone());
	    	  
	    clienteRepository.save(n);
	    return "Salvo";
  }
  
}
