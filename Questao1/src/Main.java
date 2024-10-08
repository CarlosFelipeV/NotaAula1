import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota: ");
        double nota2 = scanner.nextDouble();

        double media = (nota1 + nota2) / 2;

        System.out.printf("A média do aluno %s é: %.2f%n", nome, media);

        if (media >= 7) {
            System.out.println("Situação: Você está Aprovado");
        } else if (media < 4) {
            System.out.println("Situação: Você está Reprovado");
        } else {
            System.out.println("Situação: Você está na Final");
        }

        scanner.close();
    }
}