import java.io.File;


public class Base {
	public String [] nome;
	public int iteracaco;
	public Erro e = new Erro();
	public VotoValidacao validacaoClassificador = new VotoValidacao();
	public Teste teste = new Teste();
	public Validacao validacao = new Validacao();
	
	//base
	//listaDoDiretorio[0].toString();
	//voto do classificador validacao
	//listaDoDiretorio[9].toString();
	//teste
	//listaDoDiretorio[4].toString();	
	
	@SuppressWarnings("unused")
	public void carregaBases(File[] listaDoDiretorio){	
		
		this.iteracaco = 1;
		this.nome = listaDoDiretorio[0].list();		
		this.nome[0] = this.nome[0].toString().replaceAll(".arff", iteracaco + ".txt");		
		// "C:\Users\Vinicius\Desktop\fantinatto\academico\PIBIC\base_andre\" + 
		// "VotosClassifValidacao" + "nome da base" +  "numero da iteração" + ".txt"		
		
		validacaoClassificador.Arquivo(listaDoDiretorio[9].toString() +"\\" + this.nome[0]);		
		teste.arqToBuffer(listaDoDiretorio[4].toString() + "\\" + iteracaco + "\\" + "Teste" + this.nome[0]);		
		
		MatrizDeAdjacencia mda = new MatrizDeAdjacencia(validacaoClassificador.numeroLinhas, 
				validacaoClassificador.numeroColunas, teste.classeRealTeste, validacaoClassificador.bufferArq);
		
		Pajek pj = new Pajek(mda.matAdj, validacaoClassificador.numeroLinhas);
		
		
		validacao.arqToBuffer(listaDoDiretorio[6].toString() + "\\" + iteracaco + "\\" + "Valida" + this.nome[0]);
		validacao.criaClasseReal();
		
		e.Erro(teste, validacao);
	
		
		
	}
	
}
