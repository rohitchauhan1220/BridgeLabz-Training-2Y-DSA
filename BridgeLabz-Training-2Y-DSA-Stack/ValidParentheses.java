import java.util.Scanner;
import java.util.Stack;
public class ValidParentheses {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    System.out.println(false);
                    return;
                }
                char top = stack.pop();
                if((c==')' && top!='(')||(c=='}'&&top!='{')||(c==']'&&top!='[')){
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty());
    }
}
