public class main {
    public static void main(String[] args) {
        String[][] mapaFacil = {{"P", "M", "M", "S"},
                {"", "M", "M", ""},
                {"", "M", "M", ""},
                {"", "", "", ""}
        };

        String[][] mapaMitja = {
                {"P", "M", "M", "", "", "", "", "S"},
                {"", "", "M", "", "", "", "M", ""},
                {"", "", "M", "", "", "", "M", ""},
                {"", "", "", "", "M", "M", "", ""},
                {"", "", "", "", "M", "M", "", ""},
                {"", "", "", "", "", "", "", ""},
                {"", "", "M", "", "", "", "", ""},
                {"", "", "", "", "", "", "", ""}
        };

        String[][] mapaDificil = {
                {"P", "", "", "", "", "", "", "", "", "", "", ""},
                {"M", "M", "M", "M", "", "", "", "", "", "", "", ""},
                {"", "", "", "M", "", "", "", "", "", "", "", ""},
                {"", "", "", "M", "M", "M", "M", "", "", "", "", ""},
                {"", "", "", "", "", "", "M", "", "", "", "", ""},
                {"", "", "", "", "", "", "M", "", "", "", "", ""},
                {"", "M", "M", "M", "M", "", "M", "M", "M", "M", "", ""},
                {"", "M", "", "", "", "", "", "", "", "M", "", ""},
                {"", "M", "", "", "", "", "", "", "", "M", "", ""},
                {"", "M", "", "", "", "", "", "", "", "M", "M", "S"},
                {"", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", ""}
        };
    }
}
