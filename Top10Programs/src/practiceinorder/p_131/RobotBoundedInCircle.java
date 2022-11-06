package practiceinorder.p_131;
/*
    https://leetcode.com/problems/robot-bounded-in-circle/
    https://www.youtube.com/watch?v=tVHDINI9ehQ
 */
public class RobotBoundedInCircle {
    public static void main(String[] args) {
        String s = "GGLLGG";
        System.out.println(isRobotBounded(s));//true
    }
    public static boolean isRobotBounded(String instructions) {
        char current_dir = 'N';
        int x = 0, y= 0;
        for(int i=0;i<instructions.length();i++){
            if(instructions.charAt(i) == 'G'){
                y += current_dir =='N' ? 1 : 0;
                y += current_dir =='S' ? -1 : 0;
                x += current_dir == 'E' ? 1 : 0;
                x += current_dir == 'W' ? -1 : 0;
            }
            else{
                char incoming = instructions.charAt(i);
                if(current_dir == 'N'){
                    current_dir = incoming == 'L' ? 'W' : 'E';
                }
                else if(current_dir == 'W'){
                    current_dir = incoming == 'L' ? 'S' : 'N';
                }
                else if(current_dir == 'S'){
                    current_dir = incoming == 'L' ? 'E' : 'W';
                }
                else{
                    current_dir = incoming == 'L' ? 'N' : 'S';
                }
            }

        }

        if(x==0 && y==0 || current_dir!='N')
            return true;

        return false;
    }
}
