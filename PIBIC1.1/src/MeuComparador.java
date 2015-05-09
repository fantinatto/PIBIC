import java.util.Comparator;


public class MeuComparador implements Comparator<No> {    

@Override
public int compare(No o1, No o2){  
    No c1 = (No) o1;  
    No c2 = (No) o2;  
  
    //float resultado = c1.getVolorDeValidacao() - c2.getVolorDeValidacao();
    
     return  (c1.getVolorDeValidacao() > c2.getVolorDeValidacao() ? -1: 
             (c1.getVolorDeValidacao() == c2.getVolorDeValidacao() ? 0: 1));
  }
} 
