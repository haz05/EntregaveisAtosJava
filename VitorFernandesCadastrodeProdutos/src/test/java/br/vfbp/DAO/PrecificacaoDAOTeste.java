package br.vfbp.DAO;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.vfbp.Domain.Precificacao;

public class PrecificacaoDAOTeste {
	@Test
	@Ignore
	public void salvar() { //teste salvar (import)
		Precificacao precificacao = new Precificacao();
		precificacao.setCodigo("AAAA");
		precificacao.setDenominacao("test");
		precificacao.setPreco(50);
		
		PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO();
		precificacaoDAO.salvar(precificacao);
		
	}
	@Test
	@Ignore
	public void listar() { //teste para buscar toda a lista
		PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO();
		List<Precificacao> resultado = precificacaoDAO.listar();
		
		for (Precificacao precificacao: resultado) {
			System.out.println(precificacao.getCodigo() + " - " +precificacao.getPreco()+ " - " + precificacao.getDenominacao());
		}
		
	}
	
	@Test
	@Ignore
	public void buscar(){ // teste par buscar um id na tabela 
		Long id = 3L;
		
		PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO();
		Precificacao precificacao = precificacaoDAO.buscar(id);
	
		if(precificacao == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro encontrado:");
			System.out.println(precificacao.getCodigo() + " - " +precificacao.getPreco()+ " - " + precificacao.getDenominacao());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){
		Long id = 20L;
		PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO();
		Precificacao precificacao = precificacaoDAO.buscar(id);
		
		if(precificacao == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			precificacaoDAO.excluir(precificacao);
			System.out.println("Registro removido:");
			System.out.println(precificacao.getCodigo() + " - " +precificacao.getPreco()+ " - " + precificacao.getDenominacao());
		}
	}
	
	@Test
	public void editar(){
		Long id = 21L;
		PrecificacaoDAO precificacaoDAO = new PrecificacaoDAO();
		Precificacao precificacao = precificacaoDAO.buscar(id);
		
		if(precificacao == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(precificacao.getCodigo() + " - " +precificacao.getPreco()+ " - " + precificacao.getDenominacao());
			
			precificacao.setCodigo("BBBBBB");
			precificacao.setDenominacao("TESTE2");
			precificacao.setPreco((float) 50.40);
			precificacaoDAO.editar(precificacao);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(precificacao.getCodigo() + " - " +precificacao.getPreco()+ " - " + precificacao.getDenominacao());
		}
	}
	

}
