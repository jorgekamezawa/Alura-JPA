package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {
	
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		Cliente cliente2 = new Cliente();
		Conta conta = new Conta();
		conta.setId(1);
		
		cliente.setNome("Jorge Kamezawa");
		cliente.setEndereço("Rua Professor José Medina");
		cliente.setProfissao("Analista de sistemas");
		cliente.setConta(conta);
		
		//cliente2.setNome("Murillo Pezzuol");
		//cliente2.setEndereço("Rua Professor José Medina");
		//cliente2.setProfissao("Analista de sistemas");
		//cliente2.setConta(conta);
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(cliente);
		
		em.getTransaction().commit();
		em.close();
		
	}

}
