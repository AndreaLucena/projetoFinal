package lojaunit.andrea.accessingdatapostgres.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity // This tells Hibernate to make a table out of this class
public class Vendas {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@EmbeddedId
	private Integer idVendas;

	private Date dataHora;
	
	private double valor_total;
	
	// @OneToMany(cascade=CascadeType.ALL)
		//	private List<ItensVenda>ListaItensVenda;

		//public List<ItensVenda> getListaItensVenda() {
		//	return ListaItensVenda;
		//}

		//public void setListaItensVenda(List<ItensVenda> listaItensVenda) {
		//	ListaItensVenda = listaItensVenda;
		//}
	
	@ManyToOne (cascade=CascadeType.ALL)
	private Cliente cliente;
	
	@ManyToOne (cascade=CascadeType.ALL)
	private FormaPagamento formaPagamento;

	public Integer getIdVendas() {
		return idVendas;
	}

	public void setIdVendas(Integer idVendas) {
		this.idVendas = idVendas;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public double getValor_total() {
		return valor_total;
	}

	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}

}