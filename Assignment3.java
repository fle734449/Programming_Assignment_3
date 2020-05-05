public class Assignment3 {
	
    public int maxFruitCount (int[] sections) {
        // Implement your dynamic programming algorithm here
        // You may use helper functions as needed
    	int[][] table = new int[sections.length][sections.length];
    	int[][] sums = new int[sections.length][sections.length];
    	
    	for(int i = 0; i < sections.length; i++) {;
    		sums[i][i] = sections[i];
    	}
    	
    	for(int i = 0; i < sections.length; i++) {
    		for(int j = i+1; j < sections.length; j++) {
    			sums[i][j] = sums[i][j-1] + sections[j];
    		}
    	}
    	
    	for(int i = 0; i < sections.length; i++) {
    		table[i][i] = 0;
    	}
    	
    	for(int i = 0; i < sections.length -1; i++) {
    		int j = i+1;
    		table[i][j] = Math.min(sections[i], sections[j]);
    	}
    	
    	for(int i = sections.length-1; i >= 0; i--) {
    		for(int j = i; j < sections.length; j++) {
    			int max = 0;
    			for(int k = i; k < j; k++) {
    				max = Math.min(sums[i][k] + table[i][k], sums[k+1][j] + table[k+1][j]);
    				if(max > table[i][j]) {
    					table[i][j] = max;
    				}
    			}    			
    		}
    	}
    	
    	return table[0][sections.length - 1];
		
	}
}
