
public class Cosseno {
	//X = val ; Y = test
	public float cosseno(float X[], float Y[]){
	       int i;
	       float S = 0, SX = 0, SY = 0, R;
	                
	        for(i = 1; i < X.length; i++){
	            S = S + X[i]*Y[i];
	            SX = SX + (X[i]*X[i]);
	            SY = SY +(Y[i]*Y[i]);
	           
	        }
	        R = SX * SY;
	       
	        R = (float) (S/(Math.sqrt(R)));
	        return R;
	    }
}
