import java.util.Scanner;

public class Laberint {
    public static void movimentPepito(String[][] matriu, String caracter, int[] pepito) {
        for (int i = 0; i < matriu.length; i++) {
            System.out.println();
            for (int j = 0; j < matriu[i].length; j++) {
                System.out.print(matriu[i][j]);
            }
        }
        if (caracter.equals("W")) {
            if (!(pepito[0] < 1) && !(matriu[pepito[0] - 1][pepito[1]].equalsIgnoreCase("M")) &&
                    !(matriu[pepito[0] - 1][pepito[1]].equalsIgnoreCase("S"))) {
                matriu[pepito[0]][pepito[1]] = " ";
                pepito[0]--;
                matriu[pepito[0]][pepito[1]] = "P";
            } else if (matriu[pepito[0] - 1][pepito[1]].equals("S")) {
                System.out.print("Enhorabona has superat el laberint!");
            } else {
                System.out.println("Pepito no pot pujar");
            }
        } else if (caracter.equalsIgnoreCase("A")) {
            if (!(pepito[1] < 1) && !(matriu[pepito[0]][pepito[1] - 1].equalsIgnoreCase("M"))
                    && !(matriu[pepito[0] - 1][pepito[1]].equalsIgnoreCase("S")) &&
                    !(matriu[pepito[0]][pepito[1] - 1].equalsIgnoreCase("S"))) {
                matriu[pepito[0]][pepito[1]] = " ";
                pepito[1]--;
                matriu[pepito[0]][pepito[1]] = "P";
            } else if (matriu[pepito[0] - 1][pepito[1]].equals("S")) {
                System.out.print("Enhorabona has superat el laberint!");
            } else {
                System.out.print("Pepito no pot anar a l'esquerra");
            }
        } else if (caracter.equalsIgnoreCase("S")) {
            if (!(pepito[0] > matriu.length - 1) && !(matriu[pepito[0] + 1][pepito[1]].equalsIgnoreCase("M")) &&
                    !(matriu[pepito[0] + 1][pepito[1]].equalsIgnoreCase("S"))) {
                matriu[pepito[0]][pepito[1]] = " ";
                pepito[0]++;
                matriu[pepito[0]][pepito[1]] = "P";
            } else if (matriu[pepito[0] - 1][pepito[1]].equals("S")) {
                System.out.print("Enhorabona has superat el laberint!");
            } else {
                System.out.print("Pepito no pot anar a la dreta");
            }
        } else if (caracter.equalsIgnoreCase("D")) {
            if (!(pepito[1] < matriu[pepito[0]].length - 1) && !(matriu[pepito[0]][pepito[1] + 1].equalsIgnoreCase("M")) &&
                    !(matriu[pepito[0]][pepito[1] + 1].equalsIgnoreCase("S"))) {
                matriu[pepito[0]][pepito[1]] = " ";
                pepito[0]++;
                matriu[pepito[0]][pepito[1]] = "P";
            } else if (matriu[pepito[0] - 1][pepito[1]].equals("S")) {
                System.out.print("Enhorabona has superat el laberint!");
                estatPartida = true;
                continuaJoc = false;
            } else {
                System.out.print("Pepito no pot baixar");
            }
        }
        // Posar codi per a guardar la partida
        else if (caracter.equalsIgnoreCase("Q")) {

            System.out.print("Sortint");
            continuaJoc = false;
        } else {
            System.out.print("ERROR: no has introduït cap comandament");
        }
    }

    // Usarem aquesta funció per a poder esbrinar
    // quin és el lloc més proper a la coordenada
    // 0, 0 per a ubicar allí a Pepito
    public static int[] buscadorLlocPepito(String matriu[][]) {
        // Creem una matriu que compti les coordenades
        // per a poder triar la més pepita (la més propera a 0, 0)
        // assignarem a cada posició un número cada cop més elevat
        // com més allunyat estigui de la coordenada 0,0
        int [] pepito = new int[2];
        int[] contadorCoordenades = new int[matriu.length * matriu[0].length];
        int[] eixX = new int[matriu.length];
        int[] eixY = new int[matriu[0].length];
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                // Fem un if per a evitar que la coordenada 0 ens doni problemes
                if (i * j != 0) {
                    contadorCoordenades[i * j] = contadorCoordenades[i * j - 1] + 1;
                } else {
                    contadorCoordenades[0] = 0;
                }
            }
        }
        // Triem el nombre més petit que no sigui paret
        int auxiliar = contadorCoordenades[matriu.length * matriu[0].length];
        for (int i = 0; i < matriu.length; i++) {
            for (int j = 0; j < matriu[0].length; j++) {
                if (contadorCoordenades[i * j] < auxiliar && contadorCoordenades[i * j] != 0
                        && !(matriu[i][j].equals("M"))) {
                    auxiliar = contadorCoordenades[i * j];
                    pepito[0] = i;
                    pepito[1] = j;
                }
            }
        }
        return pepito;
    }

    public static void joc(String[] args) {
        // TODO Auto-generated method stub
        Scanner teclat = new Scanner(System.in);
        boolean continuarJoc = true;
        boolean estatPartida = true;
        String caracter;
        int[] pepito = {0, 0};
        int contadorMoviments = 0;
        String[][] mapa = null;
        // Fem un bucle per a poder jugar, en el qual
        // es cridarà la funció moviment per a moure Pepito
        while (continuarJoc) {
            System.out.println("Escapa Pepito");
            System.out.print(" W - Pujar A - Esquerra S - Baixar D - Dreta");
            caracter = teclat.next();
            movimentPepito(mapa, caracter, pepito, continuarJoc, estatPartida);
            contadorMoviments++;
        }

    }

    public static String[][] mapes(int nivell) {
        Scanner teclat = new Scanner(System.in);

        String[][] mapa = null;

        System.out.println("Selecciona un nivell: ");
        System.out.println("1. Fàcil");
        System.out.println("2. Mitjà");
        System.out.println("3. Difícil");
        nivell = teclat.nextInt();

        if (nivell == 1) {
            mapa = new String[][]{
                    {"P", "M", "M", "S"},
                    {" ", "M", "M", " "},
                    {" ", "M", "M", " "},
                    {" ", " ", " ", " "}
            };
        } else if (nivell == 2) {
            mapa = new String[][]{
                    {"P", "M", "M", " ", " ", " ", " ", "S"},
                    {" ", " ", "M", " ", " ", " ", "M", " "},
                    {" ", " ", "M", " ", " ", " ", "M", " "},
                    {" ", " ", " ", " ", "M", "M", " ", " "},
                    {" ", " ", " ", " ", "M", "M", " ", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " "},
                    {" ", " ", "M", " ", " ", " ", " ", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " "}
            };
        } else if (nivell == 3) {
            mapa = new String[][]{
                    {"P", " ", " ", "", "M", "S", " ", " ", " ", " ", " ", " "},
                    {"M", "", "M", "M", "M", " ", "M", "M", "M", "M", " ", " "},
                    {" ", " ", " ", "M", " ", " ", "M", " ", "M", "M", " ", " "},
                    {" ", " ", " ", "M", "M", "M", "M", " ", "M", "M", "M", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " ", "M", "M", " ", " "},
                    {" ", " ", " ", "M", " ", " ", "M", "M", "M", " ", " ", " "},
                    {" ", "M", "M", "M", "M", " ", "M", "M", " ", "M", " ", " "},
                    {" ", "M", " ", " ", "M", " ", "M", " ", " ", "", " ", " "},
                    {" ", "M", " ", " ", "M", "M", "M", " ", " ", "M", " ", " "},
                    {" ", "M", " ", " ", " ", "M", " ", "M", "M", "M", "M", " "},
                    {" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " "},
                    {" ", " ", " ", " ", " ", "M", " ", " ", " ", "M", " ", " "}
            };
        }

        return mapa;
    }

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);

        int menu;
        int nivell = 0;

        do {
            System.out.println();
            System.out.println("##########");
            System.out.println("###Menu###");
            System.out.println("##########");
            System.out.println("1. Jugar partida");
            System.out.println("2. Resultats partides");
            System.out.println("3. Sortir");
            menu = teclat.nextInt();

            if (menu == 1) {
                String[][] mapa = mapes(nivell);
                int[] pepito = buscadorLlocPepito(mapa);
                for (int i = 0; i < mapa.length; i++) {
                    System.out.println();
                    for (int j = 0; j < mapa[i].length; j++) {
                        System.out.print(mapa[i][j]);
                    }
                }
                System.out.println();
                movimentPepito(mapa, );
            } else if (menu == 3) {
                System.out.println("Has sortit del joc!");
            }

        } while (menu != 3);
    }
}
