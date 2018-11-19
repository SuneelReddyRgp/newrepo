package practice;

import java.util.ArrayList;
import java.util.HashMap;

public class city {
	
	boolean newRoadSystem(boolean[][] roadRegister) {
	    
	    ArrayList a = null;
	    
	    HashMap h = new HashMap<Integer,ArrayList<Integer>>();
	    for(int i=0;i<roadRegister.length;i++){
	        a = new ArrayList<Integer>();
	        for(int j=0;j<roadRegister[i].length;j++){
	            
	            if(roadRegister[i][j]){
	                a.add(j);
	            }
	        }
	        
	        h.put(i,a);
	        
	    }
	    a = new ArrayList<>();
	    HashMap in = new HashMap<Integer,Integer>();
	    HashMap out = new HashMap<Integer,Integer>();
	    for(int i=0; i<h.size(); i++){
	        if(h.containsKey(i)){
	            a = (ArrayList) h.get(i);
	            out.put(i,a.size());
	            	for(int k=0; k<a.size();k++) {
	            		int key = (int) a.get(k);
	                if(in.containsKey(key)){
	                	int tempCount = (int) in.get(key);
	                	tempCount += 1;
	                    in.put(key,tempCount);
	                }else{
	                    in.put(key,1);
	                }
	            }
	        }
	    }
	    
	    for(int i=0; i<roadRegister.length; i++){
	        if(in.get(i) != out.get(i)){
	            return false;
	        }
	    }
	    
	    return true;

	}
	
	
	public static void main(String args[]) {
		
		boolean[][] roadregister = {{false,true,false,false}, 
		 {false,false,true,false}, 
		 {true,false,false,true}, 
		 {false,false,true,false}};
		
		city c = new city();
		System.out.println(c.newRoadSystem(roadregister));
		
	}
	
	


}
