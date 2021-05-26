import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

class main{

    public static int regresar(String lugar){
        int respuesta = -1;

        switch (lugar) {
            case ("Mixco"):
                respuesta =0; 
                break;

            case ("Antigua"):
                respuesta =1; 
                break;

            case ("Escuintla"):
                respuesta =2; 
                break;

            case ("Santa-Lucia"):
                respuesta =3; 
                break;

            case ("Guatemala"):
                respuesta =4; 
                break;
        
            default:
                break;
        }

        return respuesta;
    }

    public static String regresar2(int numero){
        String respuesta = "";

        switch (numero) {
            case (0):
                respuesta ="Mixco"; 
                break;

            case (1):
                respuesta ="Antigua"; 
                break;

            case (2):
                respuesta ="Escuintla"; 
                break;

            case (3):
                respuesta ="Santa-Lucia"; 
                break;

            case (4):
                respuesta ="Guatemala"; 
                break;
        
            default:
                break;
        }

        return respuesta;
    }

    static int INF = 99999;
    
    public static void main(String [] args){

        //Se crea grafico...................................
        int grafico[][] = { {0, INF,  INF, INF, INF},
                            {INF, 0,  INF, INF, INF},
                            {INF, INF,  0, INF, INF},   
                            {INF, INF,  INF, 0, INF},
                            {INF, INF,  INF, INF, 0},
                            };


        String graficoL[][] = { {"-----", "Antigua",  "Escuintla", "Santa-Lucia", "Guatemala"},
                                {"MIxco", "-----",  "Escuintla", "Santa-Lucia", "Guatemala"},
                                {"MIxco", "Antigua",  "-----", "Santa-Lucia", "Guatemala"},   
                                {"MIxco", "Antigua",  "Escuintla", "-----", "Guatemala"},
                                {"MIxco", "Antigua",  "Escuintla", "Santa-Lucia", "-----"},
                                };


        //LEER ARCHIVO
        String direccion = "guategrafo.txt";

        try{

            BufferedReader bufer = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            String componentes [] = {};
           
        
            while((bfRead = bufer.readLine()) != null){

                //el ciclo se hace mientras bfRead tenga un dato
                temp = temp + " "+ bfRead;              

            }

            componentes = temp.split(" ");

            
            // Recorrer Grafo
            for (int k = 1; k < componentes.length; k++){

                int fila = regresar(componentes[k]);
                int columna = regresar(componentes[k+1]);

                grafico[fila][columna] = Integer.parseInt(componentes[k+2]);

                k= k+2;
              
            }

        }catch(Exception e){
            
            System.out.println("No se ha encontrado el archivo solicitado" + e);
        } 

        //IMPRIMIR GRFICO ORIGNIAL///////////////////////////////////////////////////////
        System.out.println("Matriz Original");
        for (int i=0; i<5; ++i){
            for (int j=0; j<5; ++j){
                    if (grafico[i][j]==INF){
                        System.out.print("INF\t");
                    }
                    
                    else{
                        System.out.print(grafico[i][j]+"\t");
                    }                   
            }
            System.out.println();
        }

        grafo a = new grafo();
        grafico = a.floydWarshall(grafico);
        graficoL = a.floydWarshall2(grafico);
        

        Scanner scan = new Scanner(System.in);

        int op1 = 0;
        int opcion = 0;
        int op2 = 0;
        int opcion2 = 0;

        /*****************************************************************************************************/
        while (opcion != 4) {
            
            System.out.println("\n\n-----------.M.E.N.U.-----------");
            System.out.println("1. Buscar Ruta");
            System.out.println("2. Agregar ruta");
            System.out.println("3. Quitar ruta");
            System.out.println("4. Salir\n\n");

            String pedir = scan.next();
                    
            try {

                op1 = Integer.parseInt(pedir);

                if (op1 == 1) {

                    try {

                        int fila = -1;
                        int columna = -1;

                        System.out.println("Ingrese la ciudad de salida");
                        String r = scan.next();
                        fila = regresar(r);

                        System.out.println("Ingrese la ciudad de llegada");
                        String r2 = scan.next();
                        columna = regresar(r2);

                        if(fila != -1 && columna != -1){

                            int respuesta = grafico[fila][columna];

                            System.out.println("\nLa ruta mas corta tiene un valor de " + respuesta);
                            System.out.println("Debe pasar por los siguientes lugares: ");

                            String x="";

                            ArrayList<String> nodos = new ArrayList<String>();
                            nodos.add(r);

                            while(!x.equals(r2)){

                                int ciclo = regresar(r2);

                                for(int i=0; i<5;i++){
                                    if(graficoL[ciclo][i].equals(r2)){

                                        String res = regresar2(i);

                                        nodos.add(res);
                                        i=5;
                                        x=r2;
                                    }
                                }
                            }

                            nodos.add(r2);

                            for(int j=0; j<nodos.size(); j++){
                                System.out.print(nodos.get(j) + ", ");
                            }
                            
                        }else{
                            System.out.println("Destino o Salida no encontrada");
                        }
                      

                    }catch(Exception e){
                        System.out.println("Por favor revise las entradas"+e);
                    }

                                                     

                }else if(op1 == 2){

                    int fila = -1;
                    int columna = -1;

                    try {

                        System.out.println("Ingrese la ciudad de salida");
                        String r = scan.next();
                        fila = regresar(r);

                        System.out.println("Ingrese la ciudad de llegada");
                        String r2 = scan.next();
                        columna = regresar(r2);

                        System.out.println("Ingrese el peso");
                        int r3= scan.nextInt();

                        if(fila != -1 && columna != -1){
                            grafico[fila][columna] =r3;

                            System.out.println("Se ha agregado una nueva ruta");
                            
                        }else{
                            System.out.println("Destino o Salida no encontrada");
                        }

                        //IMPRIMIR GRFICO ORIGNIAL///////////////////////////////////////////////////////
                        System.out.println("Matriz");
                        for (int i=0; i<5; ++i){
                            for (int j=0; j<5; ++j){
                                    if (grafico[i][j]==INF){
                                        System.out.print("INF\t");
                                    }
                                    
                                    else{
                                        System.out.print(grafico[i][j]+"\t");
                                    }                   
                            }
                            System.out.println();
                        }

                        a.floydWarshall(grafico);

                        
                        

                    }catch(Exception e){
                        System.out.println("Por favor revise las entradas");
                    }


                } else if(op1 == 3){
                    int fila = -1;
                    int columna = -1;

                    try {

                        System.out.println("Ingrese la ciudad de salida");
                        String r = scan.next();
                        fila = regresar(r);

                        System.out.println("Ingrese la ciudad de llegada");
                        String r2 = scan.next();
                        columna = regresar(r2);


                        if(fila != -1 && columna != -1){
                            grafico[fila][columna] = INF;

                            System.out.println("Se ha quitado la ruta");
                            
                        }else{
                            System.out.println("Destino o Salida no encontrada");
                        }

                        //IMPRIMIR GRFICO ORIGNIAL///////////////////////////////////////////////////////
                        System.out.println("Matriz");
                        for (int i=0; i<5; ++i){
                            for (int j=0; j<5; ++j){
                                    if (grafico[i][j]==INF){
                                        System.out.print("INF\t");
                                    }
                                    
                                    else{
                                        System.out.print(grafico[i][j]+"\t");
                                    }                   
                            }
                            System.out.println();
                        }

                        a.floydWarshall(grafico);
                        

                    }catch(Exception e){
                        System.out.println("Por favor revise las entradas");
                    }
                   
                } else if(op1 ==4){
                    System.out.println("Gracias por usar el programa");
                    opcion = 4;                
                    
                } else{
                    System.out.println("Has ingresado una opcion invalida,s intenta de nuevo");
                }
                
            }catch (Exception e){
                //TODO: handle exception
                System.out.println("Debes ingresar un valor numerico como opcion");
                
            }
            
        }
    }
    
}