package LabSolutions.Lab4;

public class Lab4 {

    /**
     * Task 1: longestDecreasingSeq
     * Returns the length of the longest consecutive decreasing sequence
     */
	public static int longestDecreasingSeq(int[] arr) {
        //TODO Write the code here. You may need to change the return value.
        if (arr == null || arr.length == 0) return 0;
     
        int maxLen = 1, currLen = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i-1]){
                currLen++;
            } else{
                currLen = 1;
            }
            if (currLen > maxLen){
                maxLen = currLen;
            }
        }

        return maxLen;
    }
    
    /**
     * Task 2: frequencyArray
     * Counts occurrences of odd integers in range [1, 50)
     */
    public static String frequencyArray(int[] arr) {
         if (arr == null || arr.length == 0) {
            return "";
        }

        int[] freqArr = new int[50];

        for (int num : arr) {
            if (num >= 1 && num < 50 && num % 2 != 0) {
                freqArr[num]++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 1; i < 50; i++) {
            if (freqArr[i] > 0) {
                res.append(i).append(": ").append(freqArr[i]).append("\n");
            }
        }
        
        if (res.length() > 0) res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
    
    /**
     * Task 3: canFormString
     * Checks if target can be formed from source by deleting characters
     */
    public static boolean canFormString(String source, String target) {
    	if (source == null || target == null) {
            return false;
        }
        source = source.toLowerCase();
        target = target.toLowerCase();

        int i =0 , j =0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
    
    /**
     * Task 4: matrixOperation
     * Calculates sum of main diagonal and product of anti-diagonal
     */
    public static String matrixOperation(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return "";

        int matLen = matrix.length;
        int diagSum = 0;
        int antiDiagProd = 1;
        
        for(int i = 0 ; i < matLen; i++){
            diagSum += matrix[i][i];
            antiDiagProd *= matrix[i][matLen - 1 - i];
        }

        return "Diagonal Sum:" + diagSum + ", Anti-Diagonal Product:" + antiDiagProd;
    }
    
    /**
     * Task 5: latinSquare
     * Checks if the matrix is a valid Latin square
     */
    public static boolean latinSquare(int[][] matrix) {
    	if (matrix == null || matrix.length == 0) return false;

        int matLen = matrix.length;

        for(int i = 0; i < matLen; i++){
            if(matrix[i].length != matLen) return false;
        }

    
        for (int i = 0; i < matLen; i++) {
            boolean[] used = new boolean[matLen + 1];
            for (int j = 0; j < matLen; j++) {
                int value = matrix[i][j];
                if (value < 1 || value > matLen || used[value]) {
                    return false;
                }
                used[value] = true;
            }
        }
        

        for (int j = 0; j < matLen; j++) {
            boolean[] used = new boolean[matLen + 1];
            for (int i = 0; i < matLen; i++) {
                int value = matrix[i][j];
                if (value < 1 || value > matLen || used[value]) {
                    return false;
                }
                used[value] = true;
            }
        }
        return true;
    }
}
