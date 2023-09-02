import java.util.*;

public class UnionFind {
    static int getParent(int parent[], int x){
        if(parent[x]==x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    static void unionParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    static boolean findParent(int parent[], int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a==b) return true;
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int [] parent = new int [11];
        for(int i = 1; i<=10; i++){
            parent[i] = i;
        }

        int n = sc.nextInt();

        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            unionParent(parent, a, b);
        }

        /*
        unionParent(parent, 1, 2);
        unionParent(parent, 2, 3);
        unionParent(parent, 3, 4);
        unionParent(parent, 5, 6);
        unionParent(parent, 6, 7);
        unionParent(parent, 7, 8);

         */
        System.out.println("1과 5는 연결되어 있나요? "+ (findParent(parent, 1, 5)?"예":"아니오"));
        unionParent(parent, 1, 6);
        System.out.println("1과 5는 연결되어 있나요? "+ (findParent(parent, 1, 5)?"예":"아니오"));
    }
}
