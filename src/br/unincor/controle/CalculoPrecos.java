package br.unincor.controle;

import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;

public class CalculoPrecos {
	
	/**
	 * Primeiro deve-se testar se o preço do produto não está 'null'
	 * 		- Caso o preço esteja zerado ('null'), lançar uma PrecoZeradoException
	 * 
	 * Realizar o cálculo do preço final do produto seguindo as regras:
	 * 
	 * Sanduiche:
	 * 		- Trio: se for TRUE acrescenta R$XX,XX no preço (valor referente a batata e bebida)
	 * 		- Dobro de recheio: ser for TRUE acresce o preço em XX%
	 * 
	 * Sobremesa:
	 * 		- Adicionais: se for TRUE acresce o preço em XX%
	 * 
	 */
	public void calculaPrecoFinal(Produto p) throws PrecoZeradoException {
		
		if(p.getPreco()!=null && p.getPreco()!=0){
			
			if(p instanceof Sanduiche){
				Sanduiche sanduiche = (Sanduiche)p;
				
				if(sanduiche.getTrio()==true){
					sanduiche.setPreco(sanduiche.getPreco()+20);
				}
				if(sanduiche.getDobroRecheio()==true){
					sanduiche.setPreco(sanduiche.getPreco()*1.4);
				}
			}else if(p instanceof Sobremesa){
				Sobremesa sobremesa = (Sobremesa)p;
				if(sobremesa.getAdicionais()==true){
					sobremesa.setPreco(sobremesa.getPreco()*1.05);
				}
			}
			
		}else{
			throw new PrecoZeradoException(p);
		}
		
	}
	
	/**
	 * No pagamento em dinheiro após o calculo final do preço, dar desconto de XX%.
	 */
	public Double pagtoDinheiro(List<Produto> listaProduto){
		Double precoFinal = 0.0;
		
		for (Produto produto : listaProduto) {
			precoFinal+=produto.getPreco();			
		}
		
		return (precoFinal*0.95);		

	}
	
	/**
	 * No pagamento em dinheiro após o calculo final do preço, acrescer XX% no valor do preço.
	 */
	
	public Double pagtoCartao(List<Produto> listaProduto){
		Double precoFinal = 0.0;
		
		for (Produto produto : listaProduto) {
			precoFinal+=produto.getPreco();
		}
		
		return (precoFinal*1.1);
	}

}
