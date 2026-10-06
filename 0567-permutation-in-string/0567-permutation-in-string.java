class Solution {

    public boolean compareFreq(int[] arr1 , int[] arr2){
        for(int i=0 ; i<26 ; i++){
            if(arr1[i] != arr2[i]){
                return false ;
            }
        }
        return true ;
    }

    public boolean checkInclusion(String s1, String s2) {
        int subStrSize = s1.length() ;
        int size = s2.length() ;

        if(subStrSize > size) return false ;

        int[] freq = new int[26] ;
        for(int i=0 ; i<subStrSize ; i++){
            int idx = s1.charAt(i)-'a' ;
            freq[idx]++ ;
        }

        int i=0 ;
        int[] currFreq = new int[26] ;
        while(i < subStrSize){
            int idx = s2.charAt(i)-'a' ;
            currFreq[idx]++ ;
            i++ ;
        }

        if(compareFreq(freq , currFreq)){
            return true ;
        }
        else{
            while(i < size){
                char newCh = s2.charAt(i) ;
                int newIdx = newCh - 'a' ;
                currFreq[newIdx]++ ;
                
                char oldCh = s2.charAt(i - subStrSize) ;
                int oldIdx = oldCh - 'a' ;
                currFreq[oldIdx]-- ;

                if(compareFreq(freq , currFreq)){
                    return true ;
                }

                i++ ;
            }
        }
        return false ;
    }
}