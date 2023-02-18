package negocio;

/**
 *
 * @author Anderson
 * 
 */
public class BombaCombustivel {

	// atributos
	private String tipo;
	private double precoLitro;
	private double quantidadeAtual = 200;
	private double quantidadeVendida;
	private double valorVendido;
	private boolean isLiberada;
	private String senha;
	private String senhaGerente;
	private int tentativas = 0;

	// construtor
	public BombaCombustivel(String tipo, double precoLitro, double quantidadeAtual, String senha, String senhaGerente,
			boolean isLiberada) {
		// passando os parametros e a referencia dos atributos
		this.tipo = tipo;
		this.precoLitro = precoLitro;
		this.quantidadeAtual = quantidadeAtual;
		this.senha = senha;
		this.senhaGerente = senhaGerente;
		this.isLiberada = isLiberada;
	}

	// Getters And Setters

	public double getQuantidadeAtual() {
		return this.quantidadeAtual;
	}

	public double getQuantidadeVendid() {
		return this.quantidadeVendida;
	}

	public String getTipo() {
		return this.tipo;
	}

	public boolean getIsIsLiberada() {
		return isLiberada;
	}

	public void setIsLiberada(boolean isLiberada) {
		this.isLiberada = isLiberada;
	}

	public void setPrecoLitro(double precoLitro) {
		this.precoLitro = precoLitro;
	}

	public double getPrecoLitro() {
		return precoLitro;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	// Métodos
	public boolean abasteceCliente(double l) {
		if (l > this.quantidadeAtual) {
			return isLiberada;
		}
		this.quantidadeAtual -= l;
		this.quantidadeVendida += l;
		this.valorVendido += (l * this.precoLitro);
		System.out.println("Seu tanque foi abastecido!");
		return true;
	}

	public void setPrecoAtual(double novoPreco) {
		if (isLiberada = true && novoPreco > 0) {
			setPrecoLitro(novoPreco);
			System.out.println("Bomba bloqueada! Preço modificado.");
		} else {
			System.out.println("Tente novamente, " + "preço não pode ser negativo!");
		}

	}

	public boolean liberarGerente(String senhaGerente) {
		if (senhaGerente.equals(this.senhaGerente)) {
			tentativas = 0;
			System.out.println("Bomba liberada!");
		} else {
			System.out.println("Senha incorreta.");
		}
		return false;
	}

	public void bloquear() {
		if (isLiberada == true) {
			isLiberada = false;
			System.out.println("Bomba está bloqueada!");
		} else {
			System.out.println("Bomba segue liberada!");
		}

	}

	public double mediaPreco() {
		return valorVendido / quantidadeVendida;
	}

	public boolean liberar(String senha) {
		if (tentativas < 3 && senha.equals(this.senha)) {
			setIsLiberada(true);
			setTentativas(0);
			System.out.println("Bomba liberada com sucesso, nº de tentativas: " + tentativas);
			return isLiberada = true;

		} else {
			tentativas++;
			System.out.println("Senha errada");
			System.out.println("Numero de tentativas: " + tentativas);

		}
		return isLiberada = false;
	}

	@Override
	public String toString() {
		return "====================================================\n" + "Tipo: " + this.tipo + ", Preço: "
				+ this.precoLitro + ", Quantidade Atual: " + this.quantidadeAtual + "\nQuantidade Vendida: "
				+ this.quantidadeVendida + ", Valor Vendido: " + this.valorVendido
				+ "\n====================================================";
	}
}
