import java.util.*;

public class Assignment3 {

    public int maxFruitCount (int[] sections) {
        // Implement your dynamic programming algorithm here
        // You may use helper functions as needed
    	/*int[][] table = new int[sections.length][sections.length];
    	for(int i = 0; i < sections.length; i++) {
    		for(int j = i; j < sections.length; j++) {
    			if(i == j) {
    				table[i][j] = 0;
    			}
    			else if (i == j-1) {
    				table[i][j] = Math.min(sections[i], sections[j]);
    			}
    			else {
    				int total = 0;
    				for(int k = i; k < j + 1; k++) {
    					total += sections[k];
    				}
    				ArrayList<Integer> subProblems = new ArrayList<Integer>();
    				int sub1 = 0;
    				for(int k = i; k < j; k++) {
    					sub1 += sections[k];
    					int sub2 = total - sub1;
    					int min = Math.min(sub1, sub2);
    					subProblems.add(min);
    				}
    				for(Integer subTotal : subProblems) {
    					if(subTotal > table[i][j]) {
    						table[i][j] = subTotal;
    					}
    				}
    			}
    		}
    	}*/
        return maxFruit(sections, 0, sections.length);
    }

	private int maxFruit(int[] sections, int start, int end) {
		if(end - start == 1) {
			return 0;
		} else if (end - start == 2) {
			return Math.min(sections[start], sections[end-1]);
		}
		
		int wall = 0;
		int total = 0;
		for(int i = start; i < end; i++) {
			total += sections[i];
		}
		
    	ArrayList<Integer> subProblems = new ArrayList<Integer>();
    	ArrayList<Integer> index = new ArrayList<Integer>();
		int sub1 = 0;
		for(int k = start; k < end; k++) {
			sub1 += sections[k];
			int sub2 = total - sub1;
			int min = Math.min(sub1, sub2);
			subProblems.add(min);
			index.add(k);
		}
		int max = 0;
		for(int k = 0; k < subProblems.size(); k++) {
			if(subProblems.get(k) > max) {
				max = subProblems.get(k);
				wall = index.get(k) + 1;
			}
		}
				
		int left = 0;
		int right = 0;
		for(int k = start; k < wall; k++) {
			left += sections[k];
		}
		for(int k = wall; k < end; k++) {
			right += sections[k];
		}
		return Math.min(left + maxFruit(sections, start, wall), right + maxFruit(sections, wall, end));
		
	}
}
