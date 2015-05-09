
public class MatrizDeAdjacencia {
	public int [][] matAdj;

	public int[][] getMatAdj() {
		return matAdj;
	}

	public void setMatAdj(int[][] matAdj) {
		this.matAdj = matAdj;
	}

	public int aresta;
	int [] vetAux;
	
	public int getAresta() {
		return aresta;
	}

	public void setAresta(int linha) {
		this.aresta = linha;
	}

	public void alocaMatriz(){
		this.matAdj = new int [aresta][aresta];				
	}
	
	public void vetAux(){
		this.vetAux = new int [aresta];				
	}
	
	public void inicializaMatriz(){
		int i, j,  tam = this.aresta;
		
		for(i = 0; i < tam; i++){
			this.vetAux[i] = 0;
			for(j = 0; j < tam; j++){
				this.matAdj[i][j] = 0;
	            }
	        }				
	}	

    public void calculaMat(int votos,int exemplos, 
        int matrizInicial[][], int vetorDeTestes[]){
        int []//<editor-fold defaultstate="collapsed" desc="comment">
                vetorAux
                //</editor-fold>
;
        vetorAux = new int[votos];
        
        this.matAdj = new int [votos][votos];
        int aux, cont;
        int index, relacao;
        
        //inicia a matriz valendo 0
        for(int i = 0; i < votos; i++){
            for(int j = 0; j < votos; j++){
            	 this.matAdj[i][j] = 0;
            }
        }
       
        //percorre matrizInicial comparando com os testes
        //cada linha da Matriz se refere a um vertica
        //
        for(int i = 0; i < exemplos; i++){
            cont = 0;
            for(int j = 0; j < votos; j++){
                //vertice acerta
                //j vai ser o numero do vertice
                //j até n-1
                if(matrizInicial[j][i] == vetorDeTestes[j]){
                    vetorAux[cont] = j;
                    cont++;
                }                               
            }
            //percorre o vetor de acertos e compara todos com todos
            for(int k = 0; k < cont; k++){
                for(int l = 0; l< cont; l++){
                    index = vetorAux[k];
                    relacao = vetorAux[l];
                    //se já foi feito uma ligação
                    //reforça o peso da aresta
                    if( this.matAdj[index][relacao] > 0){
                        aux =  this.matAdj[index][relacao];
                        aux++;
                        this.matAdj[index][relacao] = aux;
                        this.matAdj[relacao][index] = aux;
                    }
                    //se não inicia ligação
                    else{
                    	 this.matAdj[index][relacao] = 1;
                    	 this.matAdj[relacao][index] = 1;                    
                    }                    
                }            
            }
                      
        }       
    }
	
    public void imprime(){
		int c, l, f_arestas = this.aresta;
		for(c = 0; c < f_arestas; c++){
			for(l = 0; l < f_arestas; l++){				
					System.out.print(this.matAdj[l][c]+" ");
				}
			System.out.println();
			}
		
	}
    
	public MatrizDeAdjacencia(int votos, int exemplos, int []classeReal, int [][]bufferArq){
		setAresta(votos);
		alocaMatriz();
		vetAux();
		inicializaMatriz();	
		getMatAdj();
		calculaMat(votos, exemplos,bufferArq, classeReal);
		//imprime();		
	}
}
