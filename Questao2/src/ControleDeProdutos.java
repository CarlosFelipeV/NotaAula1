import java.util.Scanner;

class Produto {
    private String codigo;
    private String nome;
    private String tamanhoPeso;
    private String cor;
    private double valor;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, String tamanhoPeso, String cor, double valor, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.tamanhoPeso = tamanhoPeso;
        this.cor = cor;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void vender(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }

    public void exibirInformacoes() {
        System.out.println("Código: " + codigo);
        System.out.println("Nome: " + nome);
        System.out.println("Tamanho/Peso: " + tamanhoPeso);
        System.out.println("Cor: " + cor);
        System.out.println("Valor: R$" + valor);
        System.out.println("Quantidade em Estoque: " + quantidadeEstoque);
    }
}

public class ControleDeProdutos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = null;

        while (true) {
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Vender Produto");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            if (opcao == 1) {
                System.out.print("Digite o código do produto: ");
                String codigo = scanner.nextLine();
                System.out.print("Digite o nome do produto: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o tamanho ou peso: ");
                String tamanhoPeso = scanner.nextLine();
                System.out.print("Digite a cor: ");
                String cor = scanner.nextLine();
                System.out.print("Digite o valor: R$");
                double valor = scanner.nextDouble();
                System.out.print("Digite a quantidade em estoque: ");
                int quantidadeEstoque = scanner.nextInt();

                produto = new Produto(codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);
                System.out.println("Produto cadastrado com sucesso!");

            } else if (opcao == 2) {
                if (produto == null) {
                    System.out.println("Nenhum produto cadastrado.");
                    continue;
                }

                produto.exibirInformacoes();
                System.out.print("Digite a quantidade a ser vendida: ");
                int quantidadeVenda = scanner.nextInt();

                if (quantidadeVenda > produto.getQuantidadeEstoque()) {
                    System.out.println("Quantidade em estoque insuficiente!");
                    continue;
                }

                System.out.println("Escolha a forma de pagamento:");
                System.out.println("1. Pix / Espécie / Transferência / Débito (5% de desconto)");
                System.out.println("2. Crédito (3x sem juros)");
                int formaPagamento = scanner.nextInt();

                double valorTotal = produto.getValor() * quantidadeVenda;

                if (formaPagamento == 1) {
                    valorTotal *= 0.95; // Aplicar 5% de desconto
                    System.out.print("Valor total: R$" + valorTotal + ". Digite o valor pago: R$");
                    double valorPago = scanner.nextDouble();
                    if (valorPago > valorTotal) {
                        double troco = valorPago - valorTotal;
                        System.out.println("Troco: R$" + troco);
                    } else if (valorPago < valorTotal) {
                        System.out.println("Valor insuficiente!");
                    }
                } else if (formaPagamento == 2) {
                    System.out.println("Valor total: R$" + valorTotal + ". Pagamento em 3x sem juros.");
                }

                produto.vender(quantidadeVenda);
                System.out.println("Venda realizada com sucesso!");

            } else if (opcao == 3) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}