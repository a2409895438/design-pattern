import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            try {
                int a = Integer.parseInt(sc.nextLine());
                System.out.println(a);
            }catch (NumberFormatException e){
                System.out.println("asdas");
            }

        }

    }
}


class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        boolean isPositive = true;
        if(s.length() > 0 && (s.charAt(0) == '+' || s.charAt(0) == '-')){
            isPositive = s.charAt(0) == '+' ? true : false;
            s = s.substring(1);
        }
        int rs = 0;
        int i = 0;
        while (s.length() > 0 && i < s.length()&& s.charAt(i) == '0'){
            i++;
        }
        for(;i<s.length();i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                break;
            }
            int carry = s.charAt(i) - '0';
            if(rs <= (Integer.MIN_VALUE + carry)/10){
                rs = Integer.MIN_VALUE;
                break;
            }
            rs = rs * 10 + carry * -1;
        }
        if(rs == Integer.MIN_VALUE && isPositive == true){
            return Integer.MAX_VALUE;
        }
        return isPositive ? -rs:rs;
    }
}