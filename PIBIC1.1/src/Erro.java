import java.io.FileNotFoundException;

public class Erro {	
	private Lista lista;
	private Cosseno cos;
	private Moda moda;
	public int colunas;
	private int [] classeTeste;
	private int [] knn_index;
	private int [] knn_teste;
	
	
		
	public void testeMarjoritario(int k, int id, int []classeReal){
		int i;	
		moda = new Moda();
		
		for(i = 0; i < k; i++){
			knn_teste[i] = lista.listaDeValidacao.get(i).index;
			knn_index[i] = classeReal[knn_teste[i]];
		}
		this.classeTeste[id] = moda.moda(knn_index);
	}
	
	public void criaListaDeValidacao(Teste t, final Validacao v){
		int i, j, k = 5, total = 0;
		float s, erro;
		knn_index = new int [k];
		knn_teste = new int [k];
		cos = new Cosseno();
		
		lista  = new Lista();		
		lista.alocaLista();
		//index = coluna teste = linha
		for(i = 0; i < t.numeroLinhas; i++){
			lista  = new Lista();		
			lista.alocaLista();
			for(j = 0; j < t.numeroLinhas; j++){
				s = cos.cosseno(v.bufferArq[j], t.bufferArq[i]);
				lista.insereNaLista(s, j, i);
			}
			lista.ordena();
			testeMarjoritario(k, i, v.classeRealValidacao);
			lista = null;
			System.gc();
			
			if(this.classeTeste[i] == t.classeRealTeste[i]){
				total++;
			}
			
		}
		
		erro = (float)total/colunas;
		erro = erro*100;
		System.out.println(erro);
	}
	
	public void Erro(final Teste t, final Validacao v){	
		classeTeste = new int [t.numeroLinhas];
		criaListaDeValidacao(t, v);
	}
}




