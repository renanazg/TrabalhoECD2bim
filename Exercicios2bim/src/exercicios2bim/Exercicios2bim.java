/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercicios2bim;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Exercicios2bim {

    private static int tamanho;
    private static Scanner scan = new Scanner(System.in);
    private static int option;
    private static int[] array;

    /**
     * @param args the command line arguments
     *
     */
    private static int pesquisa(int chave, int[] vet) {
        int esquerda, meio, direita;
        esquerda = 0;
        direita = vet.length - 1;

        while (esquerda <= direita) {
            meio = (esquerda + direita) / 2;
            if (chave == vet[meio]) {
                return meio;
            }
            if (chave > vet[meio]) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {

        System.out.println("                 MENU ORDENAÇÃO                         ");
        System.out.println("╔═══════════════════════════════╗");
        System.out.println("║ 1. Ordenação por Inserção                           ║");
        System.out.println("║ 2. Ordenação por Seleção                            ║");
        System.out.println("║ 3. Ordenação por Bolha                              ║");
        System.out.println("║ 4. Pesquisar Número                                 ║");
        System.out.println("║ 5. Sair                                             ║");
        System.out.println("╚═══════════════════════════════╝");
        option = scan.nextInt();
        System.out.println("Digite o tamanho do Vetor/Array: ");
        try {
            tamanho = scan.nextInt();

        } catch (Exception e) {
            System.out.println("tem que ser um numero Inteiro");

        }

        int i = 0;
        while (i < tamanho) {
            array = new int[tamanho];
            int num;
            System.out.println("Digite os Numeros do Array, digite 0 para sair");
            try {
                num = scan.nextInt();
                array[i] = num;
            } catch (Exception e) {
                System.out.println("tem que ser um numero Inteiro");
            }
            i++;
        }
        switch (option) {
            case 1:
                int chave,
                 j;
                System.out.println("Você escolheu ordenação por Inserção");
                System.out.println("Vetor Original:");
                for (i = 1; i < array.length; i++) {
                    chave = array[i];
                    for (j = i - 1; (j >= 0 && array[j] > chave); j--) {

                        array[j + 1] = array[j];

                    }
                    array[j + 1] = chave;
                }
                System.out.println("");
                System.out.println("Vetor ordenado por Inserção: ");
                for (i = 0; i < array.length; i++) {
                    System.out.print(array[i]);
                }
                System.out.println("");
                break;
            case 2:
                System.out.println("Você escolheu ordenação por Seleção");
                System.out.println("Vetor Original:");
                for (i = 0; i < array.length - 1; i++) {
                    int posicaoMenor = i;

                    for (j = i + 1; j < array.length; j++) {
                        if (array[j] < array[posicaoMenor]) {
                            posicaoMenor = j;
                        }
                    }

                    if (posicaoMenor != i) {
                        int aux = array[i];
                        array[i] = array[posicaoMenor];
                        array[posicaoMenor] = aux;
                    }
                }
                System.out.println("");
                System.out.println("Vetor ordenado por Seleção: ");
                for (i = 0; i < array.length; i++) {
                    System.out.print(array[i]);
                }
                System.out.println("");
                break;
            case 3:
//                int[] array = new int[original.size()];
                boolean houveTroca = true;
                System.out.println("Você escolheu ordenação por Bolha");
                System.out.println("Vetor Original:");
                while (houveTroca) {
                    houveTroca = false;

                    for (i = 0; i < array.length - 1; i++) {
                        if (array[i] > array[i + 1]) {
                            int aux = array[i];
                            array[i] = array[i + 1];
                            array[i + 1] = aux;
                            houveTroca = true;
                        }
                    }
                }
                System.out.println("");
                System.out.println("Vetor ordenado por Bolha: ");
                for (i = 0; i < array.length; i++) {
                    System.out.print(array[i]);
                }
                System.out.println("");
                break;
            case 4:
                System.out.println("Digite o numero que procura ");
                chave = scan.nextInt();
                int num;
                for (i = 1; i < array.length; i++) {
                    num = array[i];

                    for (j = i - 1; (j >= 0 && array[j] > num); j--) {

                        array[j + 1] = array[j];

                    }
                    array[j + 1] = num;
                }
                int posicao = pesquisa(chave, array);

                if (posicao >= 0) {
                    System.out.println("O Elemento " + chave + " está localizado na "
                            + "posição: " + posicao);
                } else {
                    System.out.println(
                            "O Elemento " + chave + " não foi localizado na lista");
                }
                break;

            case 5:
                System.out.println("Saindo ...");
                break;

            default:
                System.out.println("Opção Invalida!");
//                exibirMenu();
        }
    }
}
