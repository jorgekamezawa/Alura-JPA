package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setAgencia("1234");
		conta.setBanco("001 - BANCO DO BRASIL");
		conta.setNumero("12345-6");
		conta.setTitular("Rafaela Tomé");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		//conta = em.find(Conta.class, 1);
		em.persist(conta);
		
		em.getTransaction().commit();
		em.close();
		
	}
	
}
