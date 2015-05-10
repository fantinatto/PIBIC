import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Diretorio {	
	private File diretorio;
	public File [] listaDoDiretorio;
	private int tipo = -1;
	
	//aa
	public void getDiretorio(){		
		System.out.printf("Informe o caminho da base:");
		
		 try{
		        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		        String s = bufferRead.readLine();
		        this.diretorio = new File(s);
		    }
		    catch(IOException e)
		    {
		        e.printStackTrace();
		    }
		 
	}
	
	public void listaDeDir(){
		this.listaDoDiretorio = diretorio.listFiles();		
	}
	
	public void verifica(){
		//só existe uma base
		
		//base
		//pegar a lista de todas as bases e armazenar em uma lista de bases
		Base b = new Base();
		b.carregaBases(this.listaDoDiretorio);
		
	}
		
	
	
	public void Diretorio(){
		getDiretorio();
		listaDeDir();
		verifica();		
	}
	
}
