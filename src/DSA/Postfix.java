package DSA;

import java.util.Scanner;

public class Postfix {
    static String in;
    static String o = "";
    static Scanner sc = new Scanner(System.in);
    static Stack_ stk = new Stack_();
    static Postfix obj = new Postfix();
    static char c, c1;
    boolean x = false;

    public static void main(String[] args) {
        System.out.println("Enter value:");
        in = sc.next();
        stk.stackmake(in.length());
        obj.post(in);
        System.out.println("PSN: "+o);
        obj.disp();

    }

    public void post(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(Character.isLetterOrDigit(c)){
                o=o+c;
            }
            else if(c == '/' || c == '*' || c == '+' || c == '-'){

                while (!stk.isEmpty() && obj.precedence(stk.a[stk.Top],c))
                {
                    o=o+stk.pop();
                }
                stk.push(c);
            }
            else if(c=='(')
            {
                System.out.println("( detected");
                stk.push(c);
            }
            else if(c==')')
            {
                int x=stk.pop();
                while (x!='(')
                {
                    o=o+x;
                }
                stk.pop();
            }
        }
        for (int i= stk.Top;i>-1;i++)
        {
            o=o+stk.pop();
        }
    }
        public boolean precedence ( char s, char s1){

            if (s == '+' || s == '-' && s1 == '*' || s1 == '/') {
                x = false;
            }
            else if  (s == '*' || s == '/' && s1 == '+' || s1 == '-') {
                x = true;
            }
            else if (s == '*' || s == '/' && s1 == '*' || s1 == '/') {
                x = true;
            }
            else if (s == '+' || s == '-' && s1 == '+' || s1 == '-') {
                x = true;
            } else x = false;

            return x;
        }
        public void disp () {
            for (int i = stk.Top; i >= 0; i--) {
                System.out.println(stk.pop());
            }
        }
    }


