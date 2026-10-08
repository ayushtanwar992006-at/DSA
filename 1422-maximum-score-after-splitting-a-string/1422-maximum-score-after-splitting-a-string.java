class Solution {
    public int maxScore(String s) {
        int size = s.length() ;
        int maxScore = 0 ;

        for(int i=1 ; i<size ; i++){

            int leftScore = 0 ;
            int rightScore = 0 ;
            int j=0 ;
            
            while(j < i){
                if(s.charAt(j) == '0') leftScore++ ;
                j++ ;
            }
            
            while(j < size){
                if(s.charAt(j) == '1') rightScore++ ;
                j++ ;
            }

            int currentScore = leftScore + rightScore ;

            if(maxScore < currentScore) maxScore = currentScore ;
        }

        return maxScore ;
    }
}