package practiceinorder.p_161;

import java.util.ArrayList;
import java.util.List;
/*
    https://leetcode.com/problems/pascals-triangle/
    https://www.youtube.com/watch?v=ZFgJrfbaXT8
 */
public class PascalTriangleI {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));//[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    }
    public static List<List<Integer>> generate(int numRows) {
        if(numRows==0) return new ArrayList();

        List<List<Integer>> result = new ArrayList();

        for(int i=1;i<=numRows;i++){

            List<Integer> row = new ArrayList();
            for(int j=0;j<i;j++){
                if(j==0 || j==i-1){
                    row.add(1);
                }else{
                    row.add(result.get(i-2).get(j)+result.get(i-2).get(j-1));
                }
            }
            result.add(row);
        }

        return result;
    }
}
