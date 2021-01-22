package lojaunit.andrea.accessingdatapostgres.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Produto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EmbeddedId
	private Integer idProduto;
	
	private String nome;
	
	private String descricao;
	
	private double preco_unitario;
	
	private Integer unidade;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private Categoria categoria;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private Fornecedor fornecedor;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private Marca marca;
	
	 @OneToMany(cascade=CascadeType.ALL)
		private List<Faq>ListaFaq;

	public List<Faq> getListaFaq() {
		return ListaFaq;
	}

	public void setListaFaq(List<Faq> listaFaq) {
		ListaFaq = listaFaq;
	}
	
	// @OneToMany(cascade=CascadeType.ALL)
	//	private List<ItensVenda>ListaItensVenda;

	//public List<ItensVenda> getListaItensVenda() {
	//	return ListaItensVenda;
	//}

	//public void setListaItensVenda(List<ItensVenda> listaItensVenda) {
	//	ListaItensVenda = listaItensVenda;
	//}
	
	
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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

	public double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	
}	
	
	
