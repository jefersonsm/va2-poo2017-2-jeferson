package br.unincor.controle;

import java.util.ArrayList;
import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * 1. Exibir o menu principal, onde o usuário deverá escolher
		 * qual produto deseja (sanduíche ou sobremesa), também deve-se ter a
		 * opção de “Finalizar pedido”.
		 * 
		 * 2. De acordo com a opção escolhida receber todos os atributos do
		 * produto desejado (nome, preço, trio e dobro de recheio para sanduíche
		 * e nome, preço e adicionais para sobremesa).
		 * 
		 * 3. Após a criação do produto, adicioná-lo na lista de produtos.
		 * 
		 * 4. Exibir o menu de pagamento com as opções “Dinheiro” e “Cartão”.
		 * Caso não seja selecionada nenhuma opção, considerar que o pagamento
		 * será feito em dinheiro.
		 * 
		 * 5. Para cada produto da lista calcular o seu valor final (utilizando
		 * os métodos da classe CalculaPreco) e salvá-lo no atributo ‘preco’.
		 * Tratar a exceção de preço zerado.
		 * 
		 * 6. Somar o valor final de todos os produtos para obter o valor total do pedido.
		 * 
		 * 7. Ao final do processamento do pedido, exibir um resumo do pedido com o preço
		 * final de cada produto e valor final do pedido.
		 * 
		 */
		
		Usuario gui = new Usuario();
		
		CalculoPrecos calc = new CalculoPrecos();
		
		List<Produto> listap = new ArrayList<Produto>();
		
		Integer op = 0;
		
		while(op != -1 && op != 2) {
			op=gui.exibeMenuPrincipal();
			System.out.println(op);
			try {
				if(op==0){
					 //Sanduiche
						Sanduiche sand = new Sanduiche(gui.recebeTexto("Nome:"),
								gui.recebeDouble("Preco:"), gui.recebeBoolean("Trio"),
								gui.recebeBoolean("Dobro Recheio:"));
						calc.calculaPrecoFinal(sand);
						listap.add(sand);
						
					}else if(op==1){
						//Sobremesa
						Sobremesa sobr = new Sobremesa(gui.recebeTexto("Nome: "),
									gui.recebeDouble("Preco: "), 
									gui.recebeBoolean("Adicionais: "));
						calc.calculaPrecoFinal(sobr);
						listap.add(sobr);						
					}
				
			} catch (PrecoZeradoException p) {
				// TODO: handle exception
				gui.exibeMsgErro(p.getMessage());
			}			
			
		}
		
		Integer opPagamento = gui.exibeMenuPagamento();
		Double vFinal = 0D;
		
		if(opPagamento==1){
			vFinal=calc.pagtoCartao(listap);			
		}else{
			vFinal=calc.pagtoDinheiro(listap);			
		}
		
		gui.exibeMsg("Resumo do pedido:");
		
		for (int i = 0; i < listap.size(); i++) {
			gui.exibeMsg(listap.get(i).verDados());
			
		}
		
		gui.exibeMsg("Valor total do pedido: R$" + vFinal );
		
	}
}