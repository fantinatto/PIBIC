import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Lista {

	List<No> listaDeValidacao;
    private Collection<?> No;

    public List<No> getListaDeValidacao() {
        return listaDeValidacao;
    }

    public void setListaDeValidacao(List<No> listaDeValidacao) {
        this.listaDeValidacao = listaDeValidacao;
    }
    
    public void alocaLista(){
        this.listaDeValidacao = new LinkedList<No>();
    }    
    
    public void insereNaLista(float valor, int idValidacao, int idTeste){
        No node = new No();        
        node.setVolorDeValidacao(valor);
        node.setIndex(idValidacao);
        node.setTeste(idTeste);
        this.listaDeValidacao.add(node);
    }
    //decrescente
    public void ordena(){
        Collections.sort(this.listaDeValidacao, new MeuComparador());
    }
    //
    public void desalocaLista(){    	
        this.listaDeValidacao.retainAll(No);
    }
}
