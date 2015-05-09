
public class Moda {
	    
     public int moda(int M[]){
    	 
    	 int nVezes = 1;
         int moda = 0;  
         int comparaV = 0;  
          
         for (int p = 0; p < M.length; p++) {  
             nVezes = 1;  
   
             for (int k = p + 1; k < M.length; k++) {  
                 if (M[p] == M[k]) {  
                     ++nVezes;  
                 }  
             }  
             if (nVezes > comparaV) {  
                 moda = M[p];  
                 comparaV = nVezes;  
             }  
         }  
   
         return moda;
     }  
}


