package hunfortytofifty;
//https://www.geeksforgeeks.org/solve-crossword-puzzle/ (similarity Leetcode 2018)
//https://www.youtube.com/watch?v=fUAZS-sdP2Q
public class CheckIfWordCanBePlacedInCrossword {
    public static void main(String[] args) {
        char[][] arr={
                {'+','_','+','+','+','+','+','+','+','+'},
                {'+','_','+','+','+','+','+','+','+','+'},
                {'+','_','+','+','+','+','+','+','+','+'},
                {'+','_','_','_','_','_','+','+','+','+'},
                {'+','_','+','+','+','_','+','+','+','+'},
                {'+','_','+','+','+','_','+','+','+','+'},
                {'+','+','+','+','+','_','+','+','+','+'},
                {'+','+','_','_','_','_','_','_','+','+'},
                {'+','+','+','+','+','_','+','+','+','+'},
                {'+','+','+','+','+','_','+','+','+','+'}
            };

        String[] words={"LONDON","DELHI","ICELAND","ANKARA"};
        solution(arr,words,0);
    }
    public static void printArray(char[][] arr){
        for (int i=0 ;i<arr.length;i++){
            for (int j=0 ;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void solution(char[][] arr, String[] words, int vidx){
        if(vidx == words.length){
            printArray(arr);
            return;
        }
        String word = words[vidx];
        for (int i=0 ; i<arr.length; i++){
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == '_' || arr[i][j] == word.charAt(0)){
                    if(canPlaceWordHorizontally(arr,word,i,j)){
                        boolean[] wePlaced = placedWordHorizontally(arr,word,i,j);
                        solution(arr, words, vidx+1);
                        unPlacedWordHorizontally(arr,wePlaced,word,i,j);
                    }
                    if(canPlaceWordVertically(arr,word,i,j)){
                        boolean[] wePlaced = placedWordVertically(arr,word,i,j);
                        solution(arr, words, vidx+1);
                        unPlacedWordVertically(arr,wePlaced,word,i,j);
                    }
                }
            }
        }


    }

    public static boolean canPlaceWordHorizontally(char[][] arr,String word,int i,int j){
        if(j-1>=0 && arr[i][j-1] != '+'){
            return false;
        }else if (j+ word.length()<arr[0].length && arr[i][j+word.length()] != '+'){
            return false;
        }

        for (int jj=0; jj <word.length();jj++){
            if(j+jj >=arr[0].length){
                return false;
            }
            if(arr[i][j+jj] == '_' || arr[i][j+jj] == word.charAt(jj))
                continue;
            else
                return false;
        }
        return true;
    }
    public static boolean canPlaceWordVertically(char[][] arr,String word,int i,int j){
        if(i-1>=0 && arr[i-1][j] != '+'){
            return false;
        }else if (i+ word.length()<arr.length && arr[i+word.length()][j] != '+'){
            return false;
        }

        for (int ii=0; ii <word.length();ii++){
            if(i+ii >=arr.length){
                return false;
            }
            if(arr[i+ii][j] == '_' || arr[i+ii][j] == word.charAt(ii))
                continue;
            else
                return false;
        }
        return true;
    }

    public static boolean[] placedWordHorizontally(char[][] arr,String word,int i,int j){
        boolean[] wePlaced = new boolean[word.length()];
        for (int jj = 0; jj  < word.length(); jj++) {
            if(arr[i][j+jj] == '_'){
                arr[i][j+jj]= word.charAt(jj);
                wePlaced[jj]=true;
            }
        }
        return wePlaced;
    }
    public static boolean[] placedWordVertically(char[][] arr,String word,int i,int j){
        boolean[] wePlaced = new boolean[word.length()];
        for (int ii = 0; ii  < word.length(); ii++) {
            if(arr[i+ii][j] == '_'){
                arr[i+ii][j]= word.charAt(ii);
                wePlaced[ii]=true;
            }
        }
        return wePlaced;
    }

    public static void unPlacedWordHorizontally(char[][] arr,boolean[] wePlaced,String word,int i,int j){
        for (int jj = 0; jj < word.length(); jj++) {
            if(wePlaced[jj] == true)
                arr[i][j+jj]='_';
        }
    }
    public static void unPlacedWordVertically(char[][] arr,boolean[] wePlaced,String word,int i,int j){
        for (int ii = 0; ii < word.length(); ii++) {
            if(wePlaced[ii] == true)
                arr[i+ii][j]='_';
        }
    }
}
