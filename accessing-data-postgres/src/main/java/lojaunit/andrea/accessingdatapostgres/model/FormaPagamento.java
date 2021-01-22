package lojaunit.andrea.accessingdatapostgres.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class FormaPagamento {
	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Integer idFormaPagamento;

	  private String forma;
	  
	  private String descricao;
	  
	  private Integer ativo;
	  
	  @OneToMany(cascade=CascadeType.ALL)
		private List<Vendas>ListaVendas;

	public List<Vendas> getListaVendas() {
		return ListaVendas;
	}

	public void setListaVendas(List<Vendas> listaVendas) {
		ListaVendas = listaVendas;
	}

	public Integer getIdFormaPagamento() {
		return idFormaPagamento;
	}

	public void setIdFormaPagamento(Integer idFormaPagamento) {
		this.idFormaPagamento = idFormaPagamento;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
}
	