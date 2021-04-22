package br.vfbp.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.vfbp.DAO.PrecificacaoDAO;
import br.vfbp.Domain.Precificacao;

@ManagedBean
@ViewScoped 
public class PrecificacaoBean implements Serializable{
	
	private Precificacao precificacao;
	private List<Precificacao> precificacoes; //variavel q armazena os dados do banco de dados
	private List<Precificacao> precificacoesOrcamento;
	private float somaOrcamento = (float) 0.00;
	private float custoMaoDeObra = (float) 0.00;
	public Precificacao getPrecificacao() {
		return precificacao;
	}

	public void setPrecificacao(Precificacao precificacao) {
		this.precificacao = precificacao;
	}

	public List<Precificacao> getPrecificacoes() {
		return precificacoes;
	}

	public void setPrecificacoes(List<Precificacao> precificacoes) {
		this.precificacoes = precificacoes;
	}
	
	

	public List<Precificacao> getPrecificacoesOrcamento() {
		return precificacoesOrcamento;
	}

	public void setPrecificacoesOrcamento(List<Precificacao> precificacoesOrcamento) {
		this.precificacoesOrcamento = precificacoesOrcamento;
	}
	
	public float getSomaOrcamento() {
		return somaOrcamento;
	}

	public void setSomaOrcamento(float somaOrcamento) {
		this.somaOrcamento = somaOrcamento;
	}
	
	public float getCustoMaoDeObra() {
		return custoMaoDeObra;
	}

	public void setCustoMaoDeObra(float custoMaoDeObra) {
		this.custoMaoDeObra = custoMaoDeObra;
	}

	@PostConstruct
	public void listar() {
		try {
			PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO(); 
			precificacoes = precificacaoDAO.listar();  //armazenando em precificacoes todos os componentes do banco de dados
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("ERRO");
			e.printStackTrace();
			
		}
	}

	
	public void cadastro() {
		precificacao = new Precificacao();
	}


	public void salvar() {
		PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO(); 
		precificacaoDAO.merge(precificacao); //usar o merge p/ conseguir salvar e editar no mesmo lugar
		
		precificacoes = precificacaoDAO.listar();
		/* Message sem o OminFaces
		String texto = "Cadastro salvo com sucesso!";
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, mensagem);
		*/
		Messages.addGlobalInfo("Cadastro de:"+precificacao.getDenominacao());
		cadastro();
	}
	
	public void excluir(ActionEvent evento){
		try {
			precificacao = (Precificacao) evento.getComponent().getAttributes().get("componenteSelecionado");
			
			PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO(); 
			precificacaoDAO.excluir(precificacao);
			
			precificacoes = precificacaoDAO.listar();
			Messages.addGlobalInfo(precificacao.getDenominacao()+"Excluido com sucesso!" );
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("ERRO");
			e.printStackTrace();
			
		}
		
	}
	
	public void editar(ActionEvent evento){
		precificacao = (Precificacao) evento.getComponent().getAttributes().get("componenteSelecionado");
	
		//Messages.addGlobalInfo("Denominacao: "+precificacao.getDenominacao());

	}
	
	public void orcamento(){
		precificacao = new Precificacao();
		precificacoesOrcamento =  new ArrayList();
		somaOrcamento  = (float) 0.00;
		custoMaoDeObra = (float) 0.00;
		//Messages.addGlobalInfo("Orçamento");

	}
	public void gerar(){
		somaOrcamento = (float) 0.00;
		try {
			for(Precificacao po : precificacoesOrcamento) {
				
				somaOrcamento = somaOrcamento + po.getPreco();

			}
			//Messages.addGlobalInfo("Soma:"+somaOrcamento);
			somaOrcamento = custoMaoDeObra + somaOrcamento;
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro");
			e.printStackTrace();
			
		}
	
	}

}
