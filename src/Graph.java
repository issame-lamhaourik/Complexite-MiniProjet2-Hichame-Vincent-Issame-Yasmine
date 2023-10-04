public class Graph {
    private boolean[][] matrice_adj;
    private int taille;

    public Graph(int n){
        taille = n;
        matrice_adj = new boolean[n][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                matrice_adj[i][j] = false;
            }
        }
    }

    public Graph(boolean[][] m, int n){
        assert(m[0].length == n);
        matrice_adj = m;
        taille = n;
    }

    public void addAdjacence(int p1, int p2){
        matrice_adj[p1][p2] = true;
        matrice_adj[p2][p1] = true;
    }

    public boolean checkAdjacence(int p1, int p2){
        return(matrice_adj[p1][p2]);
    }

    public int getSize(){
        return taille;
    }
}
