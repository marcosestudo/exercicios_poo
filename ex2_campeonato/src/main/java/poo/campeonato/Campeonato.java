package poo.campeonato;

public class Campeonato {
    private static final int PG = 0;
    private static final int J = 1;
    private static final int V = 2;
    private static final int SG = 3;
    private static final int GP = 4;

    public static int lider(int numTimes, int[][] tabela) {
        int lider = 0; // Começa assumindo que o líder é o primeiro time
        for (int i = 1; i < numTimes; i++) {
            if (compareTimes(tabela[i], tabela[lider]) > 0) {
                lider = i;
            }
        }
        return lider + 1; // Adiciona 1 porque os times são numerados a partir de 1, não de 0
    }

    private static int compareTimes(int[] time1, int[] time2) {
        // Compara os times de acordo com os critérios definidos
        if (time1[PG] != time2[PG]) {
            return Integer.compare(time1[PG], time2[PG]); // Quem tem mais pontos ganhos é o líder
        } else if (time1[V] != time2[V]) {
            return Integer.compare(time1[V], time2[V]); // Quem tem mais vitórias é o líder
        } else if (time1[SG] != time2[SG]) {
            return Integer.compare(time1[SG], time2[SG]); // Quem tem melhor saldo de gols é o líder
        } else {
            return Integer.compare(time1[GP], time2[GP]); // Quem tem mais gols próximos é o líder
        }
    }

    public static void main(String[] args) {
        int[][] tabela = {
            {10, 4, 3, 6, 10},
            {8, 4, 2, 3, 7},
            {8, 4, 2, 2, 6},
            {6, 4, 1, -1, 4},
            {10, 4, 4, -4, 3},
            {4, 4, 1, -6, 2}
        };
        int numTimes = tabela.length;
        int lider = Campeonato.lider(numTimes, tabela);
        System.out.println("O líder do campeonato é o time " + lider);
    }
}
