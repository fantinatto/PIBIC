import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;


public class Validacao extends Arquivo{
	
	
	public Validacao(){
		super();
	}
	
	public float [][] bufferArq;
	public int [] classeRealValidacao;
	
	@Override
	public void carregaArquivo(String Arquivo){		
		bufferArq = new float [numeroLinhas][numeroColunas];
		
	    int Linhas = 0, Colunas = 0;
	        BufferedReader bufferDoArquivo = null;
	        FileReader file;
	        String linha;
	        Scanner scanner = null;
	        try {
	            file = new FileReader(Arquivo);
	            bufferDoArquivo = new BufferedReader(file);
	            linha = bufferDoArquivo.readLine();  
	            
	            //conta linhas e colunas
	             while(linha != null){              
	                    scanner = new Scanner(linha);
	                    scanner.useLocale(Locale.US);                    
	                    while(scanner.hasNext()){
	                        if(scanner.hasNextFloat()){
	                        	bufferArq[Linhas][Colunas] = scanner.nextFloat();
	                            Colunas++;
	                            //System.out.println("Found :" + scanner.nextFloat());
	                        }
	                    }                    
	                Colunas = 0;
	                Linhas++;
	                linha = bufferDoArquivo.readLine();
	            }            
	            file.close();            
	        } catch (IOException ex) {
	           
	        }
	    }
	
		public void criaClasseReal(){
			classeRealValidacao = new int [numeroLinhas];
			
			for(int i = 0; i < this.numeroLinhas; i++){
				this.classeRealValidacao[i] = (int) this.bufferArq[i][0];
			}
			
		}
	
		public void arqToBuffer(String Arquivo){
			calculaLinhas(Arquivo);		
			try {
				calculaColunas(Arquivo);
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}	
			carregaArquivo(Arquivo);
			criaClasseReal();
			
		}
	
	}
