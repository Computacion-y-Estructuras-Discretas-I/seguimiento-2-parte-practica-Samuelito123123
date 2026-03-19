import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt(), nb = sc.nextInt(), k = sc.nextInt();

        int[] servidorA = new int[na];
        for (int i = 0; i < na; i++) servidorA[i] = sc.nextInt();

        int[] servidorB = new int[nb];
        for (int i = 0; i < nb; i++) servidorB[i] = sc.nextInt();

        int[] baneados = new int[k];
        for (int i = 0; i < k; i++) baneados[i] = sc.nextInt();

        sc.close();

        TreeSet<Integer> activos = jugadoresActivos(servidorA, servidorB, baneados);

        System.out.println(activos.size());
        StringBuilder sb = new StringBuilder();
        for (int id : activos) sb.append(id).append(' ');
        System.out.println(sb.toString().trim());
    }


    public static TreeSet<Integer> jugadoresActivos(int[] servidorA, int[] servidorB, int[] baneados) {
        TreeSet<Integer> newA = new TreeSet<>();
        TreeSet<Integer> newB = new TreeSet<>();
        for (int i = 0; i < servidorA.length; i++) {
            newA.add(servidorA[i]);
        }
        for (int i = 0; i < servidorB.length; i++) {
            newB.add(servidorB[i]);
        }
        newA.addAll(newB);
        for (int i = 0; i < baneados.length; i++) {
            if (newA.contains(baneados[i])) {
                newA.remove(baneados[i]);
            }
        }
        return newA;
    }
}