import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Arquivo {
	public String nome;
	public int numeroLinhas;
	public int numeroColunas;
	public int [] classeReal;
	public int [][] bufferArq;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public void setNumeroLinhas(int numeroLinhas) {
		this.numeroLinhas = numeroLinhas;
	}

	public int getNumeroColunas() {
		return numeroColunas;
	}

	public void setNumeroColunas(int numeroColunas) {
		this.numeroColunas = numeroColunas;
	}

	public int[] getClasseReal() {
		return classeReal;
	}

	public void setClasseReal(int[] classeReal) {
		this.classeReal = classeReal;
	}

	public int[][] getBufferArq() {
		return bufferArq;
	}

	public void setBufferArq(int[][] bufferArq) {
		this.bufferArq = bufferArq;
	}

	
	
	protected void calculaLinhas(String Arquivo){	
		
		try { 
			File arquivoLeitura = new File(Arquivo); 

			// pega o tamanho 
			long tamanhoArquivo = arquivoLeitura .length(); 
			FileInputStream fs = new FileInputStream(arquivoLeitura); 
			DataInputStream in = new DataInputStream(fs); 

			LineNumberReader lineRead = new LineNumberReader(new InputStreamReader(in)); 
			lineRead.skip(tamanhoArquivo);
			
			// conta o numero de linhas do arquivo, começa com zero, por isso adiciona 1 
			this.numeroLinhas = lineRead.getLineNumber()+1; 
			//System.out.println("O ARQUIVO CONTEM " + this.numeroLinhas + " LINHAS!!!!!!!");
			

			} catch (IOException e) { 
			
			}
		 
	}
	
	public int calculaColunas(String Arquivo) throws FileNotFoundException{
		int numDeColunas = 0;
		StringTokenizer token;
		 
		 try {
	            //abre arquivo para leitura
	            //FileReader arquivoAberto = new FileReader(this.caminhoDoArquivo);
	            FileReader fr = new FileReader(Arquivo);
	            BufferedReader br = new BufferedReader(fr);
	            
	            String linha = br.readLine();
	            
	            token = new StringTokenizer(linha);
	            while(token.hasMoreElements()){
	            	numDeColunas++;
	                token.nextToken();
	                   
	            }
	            br.close();
	            fr.close();	            
		 } 
		 catch (IOException ex) {
			 
		 }		 
		 this.numeroColunas = numDeColunas;
		 return numDeColunas;
		  
	}

	public void primeiraLinha(String Arquivo){
		StringTokenizer token;
		int exemplos = 0;
		/*
		 * A classe real sempre é a primeira linha dos arquivos 
		 * valid_vote -> representa a classe real dos exemplos de validação.
		 * test_vote -> classe real dos exemplos de teste*/
		classeReal = new int[this.numeroColunas];
		
		try {
            //abre arquivo para leitura
            //FileReader arquivoAberto = new FileReader(this.caminhoDoArquivo);
            FileReader fr = new FileReader(Arquivo);
            BufferedReader br = new BufferedReader(fr);            
            String linha = br.readLine();            
            token = new StringTokenizer(linha);
            
            while(token.hasMoreElements()){
            	classeReal[exemplos] = Integer.parseInt(token.nextToken());
            	
            	//System.out.println(classeReal[exemplos]);
            	exemplos++;                
                   
            }
            br.close();
            fr.close();	            
	 } 
	 catch (IOException ex) {
		 
	 }
		
	}
	
	
	public void carregaArquivo(String Arquivo){		
		StringTokenizer token;		
		//linha = voto; colunas = classe
		int voto = 0, classe = 0;
		bufferArq = new int [this.numeroLinhas][this.numeroColunas];
		
		try {
            //abre arquivo para leitura
            //FileReader arquivoAberto = new FileReader(this.caminhoDoArquivo);
            FileReader fr = new FileReader(Arquivo);
            BufferedReader br = new BufferedReader(fr);            
            String linha = br.readLine();     
            
            
            while(linha != null){
            	token = new StringTokenizer(linha);
            	
	            while(token.hasMoreElements()){
	            	bufferArq[voto][classe] = Integer.parseInt(token.nextToken());	            	
	            	classe++;        
	            }
	            voto++;
	            classe = 0;
	            linha = br.readLine();
            }
            
            br.close();
            fr.close();	            
	 } 
	 catch (IOException ex) {
		 
	 }
		
	}
		
	public void Arquivo(String Arquivo){
		calculaLinhas(Arquivo);		
		try {
			calculaColunas(Arquivo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		primeiraLinha(Arquivo);
		carregaArquivo(Arquivo);
	}
	
}
