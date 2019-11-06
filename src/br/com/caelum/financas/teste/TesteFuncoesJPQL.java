package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {
	
	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
//		String jpql = "select m from Movimentacao m where m.tipo = :pTipo";
//		String jpql = "select sum(m.valor) from Movimentacao m where m.conta = :pConta" + 
//				" and m.tipo = :pTipo" +
//				" order by m.valor asc";
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta" + 
				" and m.tipo = :pTipo" +
				" order by m.valor asc";
		Query query = em.createQuery(jpql);
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		
		Double media = (Double) query.getSingleResult();
		
		System.out.println("A media é: " + media);
		
//		List<Movimentacao> resultados = query.getResultList();
		
//		BigDecimal soma = new BigDecimal(3.14);
		
//		for (Movimentacao movimentacao : resultados) {
//			soma = soma.add(movimentacao.getValor());
//			System.out.println("Descrição: " + movimentacao.getDescricao());
//			System.out.println("Conta.id: " + movimentacao.getConta().getId());
//			System.out.println(soma);
//		}

		em.getTransaction().commit();
		em.close();
		
	}

}
