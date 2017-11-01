package br.unincor.view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Nesta classe você deve tratar exceção em todos os métodos que podem vir a
 * lançar exceções por entrada incorreta do usuário e remover os métodos não
 * utilizados.
 *
 */
public class Usuario {

	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exibeMsgErro(String texto) {
		JOptionPane.showMessageDialog(null, texto, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public void exibeMsgDebug(String texto) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println(sdf.format(new Date()) + " - [DEBUG] " + texto);
	}

	public Integer exibeMenuPrincipal() {
		Object[] opcoes = { "Sanduiche", "Sobremesa", "Finalizar pedido" };
		Integer op = JOptionPane.showOptionDialog(null,
												"Escolha o produto",
												"Menu Principal",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												opcoes,
												2);

		return op;
	}

	public Integer exibeMenuPagamento() {
		Object[] opcoes = { "Dinheiro", "Cartão" };
		Integer op = JOptionPane.showOptionDialog(null,
												"Forma de Pagamento",
												"Pagamento",
												JOptionPane.DEFAULT_OPTION,
												JOptionPane.INFORMATION_MESSAGE,
												null,
												opcoes,
												0);

		return op;
	}

	public Integer recebeInteiro(String texto) {
		
		try {
			Integer resposta = Integer.parseInt(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
	}

	public Long recebeLong(String texto) {
		try {
			Long resposta = Long.parseLong(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
		
	}

	public Double recebeDouble(String texto) {
		
		try {
			Double resposta = Double.parseDouble(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
	}

	public Float recebeFloat(String texto) {
		try {
			Float resposta = Float.parseFloat(JOptionPane.showInputDialog(texto));
			return resposta;
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
	}

	public Boolean recebeBoolean(String texto) {
		try {
			Integer op = JOptionPane.showConfirmDialog(null, texto);

			if (op == 0)
				return true;
			return false;
			
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
	}

	public String recebeTexto(String texto) {
		try {
			return JOptionPane.showInputDialog(texto);			
		} catch (Exception e) {
			exibeMsgErro("Erro na entrada do usuário");
		}
		return null;
		
	}
}
