class Solution {
    public int numIslands(char[][] grid) {
        
        
 		int m = grid.length;
    		int n = grid[0].length;
    		int count = 0;
    		
    		int[] row = {-1, 1, 0, 0};
    		int[] col = {0, 0, 1, -1};
    		
    		for (int i = 0; i < m; i++) {
    			for (int j = 0; j < n; j++) {
    				if (grid[i][j] == '1') {
    					count++;
    					
    					Queue<int[]> q = new LinkedList<>();
    					q.add(new int[] {i, j});
    					grid[i][j] = '0';
    					
    					while (q.size() > 0) {
    						int[] front = q.remove();
    						for (int k = 0; k < 4; k++) {
    							int r = front[0] + row[k];
    							int c = front[1] + col[k];
    							
    							if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1') {
    								q.add(new int[] {r, c});
    								grid[r][c] = '0';
    							}
    						}
    					}
    				}
    			}
    		}
    		
    		
    		return count;
    }
    
}