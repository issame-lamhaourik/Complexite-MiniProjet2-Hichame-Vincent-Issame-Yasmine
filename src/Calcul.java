public class Calcul {

    public static boolean testZoneDense(Graph graph, int [] x){
        for (int i = 0; i<x.length; i++){
            for (int j = i+1; j<x.length; j++){
                if (!graph.checkAdjacence(x[i], x[j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[] calculZoneDenseMaximal(Graph graph){
        int[] zonedensemax = new int[graph.getSize()];
        int index = 0;
        boolean fini = false;
        int size = graph.getSize();

        //Cherche une zone dense minimale avec 2 sommets (n'importe quelle adjacence)
        for (int i = 0; i<size; i++){
            for (int j = i + 1; j < size; j++ ) {
                if(graph.checkAdjacence(i,j)){
                    zonedensemax[index] = i;
                    zonedensemax[index+1] = j;
                    index++;
                    break;
                }
            }
        }

        //Calcule la zone dense maximale
        while(index< size && !fini){
            for(int i = zonedensemax[1]; i< size; i++){
                zonedensemax[index+1] = i;
                index++;
                if(!testZoneDense(graph,zonedensemax)){
                    zonedensemax[index] = -1;
                    index--;
                }
            }
        }



       return null;
    }





    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addAdjacence(0,1);
        g.addAdjacence(1,2);
        g.addAdjacence(2,0);
        g.addAdjacence(2,3);
        g.addAdjacence(1,3);
        g.addAdjacence(0,3);


        System.out.println(testZoneDense(g,new int[]{0,1,3}));  //question 1
    }

}
