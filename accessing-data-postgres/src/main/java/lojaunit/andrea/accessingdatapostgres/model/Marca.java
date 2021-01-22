package lojaunit.andrea.accessingdatapostgres.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Marca {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idMarca;

	private String nome;
	  
	private String descricao;
	
	 @OneToMany(cascade=CascadeType.ALL)
		private List<Produto>ListaProduto;

	public List<Produto> getListaProduto() {
		return ListaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		ListaProduto = listaProduto;
	}

	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
