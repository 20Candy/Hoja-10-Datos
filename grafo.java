import java.util.*;
import java.lang.*;
import java.io.*;
 
 
class grafo{
    
    final static int INF = 99999, V = 5;

    String graficoL[][] = { {"-----", "Antigua",  "Escuintla", "Santa-Lucia", "Guatemala"},
                            {"Mixco", "-------",  "Escuintla", "Santa-Lucia", "Guatemala"},
                            {"Mixco", "Antigua",  "---------", "Santa-Lucia", "Guatemala"},   
                            {"Mixco", "Antigua",  "Escuintla", "-----------", "Guatemala"},
                            {"Mixco", "Antigua",  "Escuintla", "Santa-Lucia", "---------"},
                            };


 
    int[][] floydWarshall(int graph[][]){

        int dist[][] = new int[V][V];
        int i, j, k;

        // Crear Grafo
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                dist[i][j] = graph[i][j];
            }
        }


        // Recorrer Grafo
        for (k = 0; k < V; k++){

            for (i = 0; i < V; i++){

                for (j = 0; j < V; j++){
                    
                    //Verificacion distancia mas corta
                    if (dist[i][k] + dist[k][j] < dist[i][j]){

                        dist[i][j] = dist[i][k] + dist[k][j];

                        graficoL[i][j] = main.regresar2(i);


                    }
                }
            }
        }

        printSolution(dist);

        return dist;
    }

    String[][] floydWarshall2(int graph[][]){

        int dist[][] = new int[V][V];
        int i, j, k;

        // Crear Grafo
        for (i = 0; i < V; i++){
            for (j = 0; j < V; j++){
                dist[i][j] = graph[i][j];
            }
        }


        // Recorrer Grafo
        for (k = 0; k < V; k++){

            for (i = 0; i < V; i++){

                for (j = 0; j < V; j++){
                    
                    //Verificacion distancia mas corta
                    if (dist[i][k] + dist[k][j] < dist[i][j]){

                        dist[i][j] = dist[i][k] + dist[k][j];

                        graficoL[i][j] = main.regresar2(i);


                    }
                }
            }
        }
        
        printSolution2(graficoL);

        return graficoL;
    }


    

    void printSolution(int dist[][]){

        System.out.println("\nMatriz");
        for (int i=0; i<V; ++i){
            for (int j=0; j<V; ++j){
                    if (dist[i][j]==INF){
                        System.out.print("INF\t");
                    }
                    
                    else{
                        System.out.print(dist[i][j]+"\t");
                    }                   
            }
            System.out.println();
        }
    } 

    void printSolution2(String dist[][]){

        System.out.println("\nMatriz");
        for (int i=0; i<V; ++i){
            for (int j=0; j<V; ++j){

                System.out.print(dist[i][j]+"   \t");
                                    
            }
            System.out.println();
        }
    } 

}
