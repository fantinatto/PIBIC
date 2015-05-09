import java.io.File;
import java.io.PrintWriter;
import java.util.Calendar;


public class Pajek {
	
	protected void criaDiretorio(){
        File dir = new File("c:/PAJEK");  
        if (dir.mkdir()) {  
            System.out.println("Diretorio criado com sucesso!\n");  
        }
        else{  
            System.out.println("\nErro ao criar diretorio, ou diretório já existente!");  
        }     
    }
    
	protected void geraArquivoPAJEK(int matrizAdjacencia [][], int vertices){
        try{  
            try (PrintWriter pw = new PrintWriter("c:/PAJEK/3.net")) {
                pw.printf("*Vertices %d\n", vertices);
                for(int i = 0; i < vertices; i++){
                            pw.printf("%d  \"%d\" \n", i+1, i+1);

                 }
                 pw.printf("*Edges\n");
                 for(int i = 0; i < vertices; i++){
                            for(int j = 0; j <  vertices; j++){
                                if(matrizAdjacencia[i][j] != 0){
                                    pw.printf("%d %d %d\n", i+1 ,j+1, matrizAdjacencia[i][j]);
                                }
                            }
                 }
                pw.flush();
            }  
        }
        catch(Exception e){    
        }        
    }
	
	public Pajek(int matrizAdjacencia [][], int vertices){
		criaDiretorio();
		geraArquivoPAJEK(matrizAdjacencia, vertices);
		
		
	}

}
