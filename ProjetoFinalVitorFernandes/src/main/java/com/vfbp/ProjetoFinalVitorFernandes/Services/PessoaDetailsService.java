package com.vfbp.ProjetoFinalVitorFernandes.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vfbp.ProjetoFinalVitorFernandes.Models.PessoaModel;
import com.vfbp.ProjetoFinalVitorFernandes.Repositories.PessoaRepository;



@Service
public class PessoaDetailsService implements UserDetailsService{
	
	@Autowired
	private PessoaRepository pessoarepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		PessoaModel pessoa = pessoarepository.findByLogin(username);
		
		if(pessoa == null) {
			throw new UsernameNotFoundException(username+"nao encontrado");
		}
		
		return new PessoaDetails(pessoa);
	}

}
