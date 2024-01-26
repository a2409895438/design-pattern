import java.util.Scanner;

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
