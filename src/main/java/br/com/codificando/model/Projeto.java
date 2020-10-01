package br.com.codificando.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "projeto")
public class Projeto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	@Size(max=80)
	private String nome;
	
	@NonNull
	@Size(max=255)
	private String descricao;
	
	@NonNull
	@Size(max=50)
	private String status;
	
	@NonNull
	@Size(max=45)
	private String risco;
	
	@NonNull
	private double orcamento;
	
	@NonNull
	@Column(name="data_inicio")
	private Date dataInicio;
	
	@NonNull
	@Column(name="data_previsao")
	private Date dataPrevisao;
	
	@NonNull
	
	private Date dataFinal;
		
	@OneToOne
	@JoinColumn(name="funcionario_id", referencedColumnName = "id")
	private Funcionario gerente;
	
	@ManyToMany
	@JoinTable(name="projeto_funcionario",
			joinColumns = @JoinColumn(name="projeto_id"),
			inverseJoinColumns = @JoinColumn(name="funcionario_id"))
	
	private List<Funcionario> funcionarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRisco() {
		return risco;
	}

	public void setRisco(String risco) {
		this.risco = risco;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataPrevisao() {
		return dataPrevisao;
	}

	public void setDataPrevisao(Date dataPrevisao) {
		this.dataPrevisao = dataPrevisao;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}

	public Funcionario getGerente() {
		return gerente;
	}

	public void setGerente(Funcionario gerente) {
		this.gerente = gerente;
	}
	

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public String toString() {
		return "Projeto: " + nome + ", descricao: " + descricao + ", status: " + status + ", risco: "
				+ risco + ", orcamento: " + orcamento + ", dataInicio: " + dataInicio + ", dataPrevisao: " + dataPrevisao
				+ ", dataFinal: " + dataFinal + ", gerente: " + gerente;
	}
	
	
	
	
	
}
