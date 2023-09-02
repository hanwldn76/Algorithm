import java.util.*;

public class Kruskal {
    static int getParent(int[] parent, int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    static boolean findParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a==b) return true;
        return false;
    }

    static void kruskal(int[][] graph, int[] parent){
        int final_cost = 0;
        for(int i = 0; i<graph.length; i++){
            // 사이클이 발생하지 않는 경우 그래프에 포함
            if(!findParent(parent, graph[i][0] - 1, graph[i][1] - 1)){
                final_cost += graph[i][2];
                unionParent(parent, graph[i][0] - 1, graph[i][1] - 1);
            }
        }

        System.out.println(final_cost);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // n : 정점 개수, m : 간선 개수
        int n = sc.nextInt();
        int m = sc.nextInt();

        int [][] graph = new int[m][3];
        for (int i = 0; i < m; i++) {
            graph[i][0] = sc.nextInt();
            graph[i][1] = sc.nextInt();
            graph[i][2] = sc.nextInt();
        }

        // 간선의 비용을 기준으로 오름차순 정렬
        // o1[2] - o2[2] 세번째 숫자 기준 오름차순
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);

        // 각 정점이 포함된 그래프가 어디인지 저장
        int [] parent = new int [n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        kruskal(graph, parent);
    }
}
