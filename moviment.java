import java.util.Scanner;

public class Laberint {

	public static void Moviment (String [][] matriu, String caracter, int[] pepito, String menu, boolean estatPartida) {
		for (int i = 0; i < matriu.length; i ++) {
			System.out.println("");
			for (int j = 0; j < matriu[i].length; j ++) {
				System.out.print(matriu[i][j]);
			}
		}
		if (caracter.equals("W")) {
			if (!(pepito[0] < 1) && !(matriu[pepito[0]-1][pepito[1]].equalsIgnoreCase("M")) &&
					!(matriu[pepito[0]-1][pepito[1]].equalsIgnoreCase("S"))) {
				matriu[pepito[0]][pepito[1]] = " ";
				pepito [0]--;
				matriu[pepito[0]][pepito[1]] = "P";
			}
			else if (matriu[pepito[0]-1][pepito[1]].equals("S")) {
				System.out.print("Enhorabona has superat el laberint!");
			}
			else {
				System.out.println("Pepito no pot pujar");
			}
		}
		else if (caracter.equalsIgnoreCase("A")) {
			if(!(pepito[1] < 1) && !(matriu[pepito[0]][pepito[1]-1].equalsIgnoreCase("M"))
					&& !(matriu[pepito[0]-1][pepito[1]].equalsIgnoreCase("S")) &&
					!(matriu[pepito[0]][pepito[1]-1].equalsIgnoreCase("S"))) {
				matriu[pepito[0]][pepito[1]] = " ";
				pepito [1]--;
				matriu[pepito[0]][pepito[1]] = "P";
		}
			else if (matriu[pepito[0]-1][pepito[1]].equals("S")) {
				System.out.print("Enhorabona has superat el laberint!");
			}
			else {
				System.out.print("Pepito no pot anar a l'esquerra");
			}
	}
		else if (caracter.equalsIgnoreCase("S")){
			if (!(pepito[0] > matriu.length-1) && !(matriu[pepito[0]+1][pepito[1]].equalsIgnoreCase("M"))&&
					!(matriu[pepito[0]+1][pepito[1]].equalsIgnoreCase("S"))) {
				matriu[pepito[0]][pepito[1]] = " ";
				pepito [0]++;
				matriu[pepito[0]][pepito[1]] = "P";
		}
			else if (matriu[pepito[0]-1][pepito[1]].equals("S")) {
				System.out.print("Enhorabona has superat el laberint!");
			}
			else {
				System.out.print("Pepito no pot anar a la dreta");
			}
		}
		else if (caracter.equalsIgnoreCase("D")) {
			if (!(pepito[1] < matriu[pepito[0]].length-1) && !(matriu[pepito[0]][pepito[1]+1].equalsIgnoreCase("M"))&&
					!(matriu[pepito[0]][pepito[1]+1].equalsIgnoreCase("S"))) {
				matriu[pepito[0]][pepito[1]] = " ";
				pepito [0]++;
				matriu[pepito[0]][pepito[1]] = "P";
		}
			else if (matriu[pepito[0]-1][pepito[1]].equals("S")) {
				System.out.print("Enhorabona has superat el laberint!");
				estatPartida = true;
			}
			else {
				System.out.print("Pepito no pot baixar");
			}
		}
		// Posar codi per a guardar la partida
		else if (caracter.equalsIgnoreCase("Q")) {
			menu = "Q";
			System.out.print("Sortint");
		}
		else {
			System.out.print("ERROR: no has introduït cap comandament");
		}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclat = new Scanner (System.in);
		
	}

}
