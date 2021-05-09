package com.vfbp.ProjetoFinalVitorFernandes.Services;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.vfbp.ProjetoFinalVitorFernandes.Models.PessoaModel;


public class PessoaDetails implements UserDetails{ // implements do spring security
	
	private PessoaModel pessoa;
	
	public PessoaDetails(PessoaModel pessoa) {
		super();
		this.pessoa = pessoa;
		}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority(pessoa.getPapel()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pessoa.getSenha();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return pessoa.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}