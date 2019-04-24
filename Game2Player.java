import java.util.Scanner;

public class Game2Player {
    public String startGame() {
        String[] array1 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int dem = 0, so = 0, flag = 1;
        String a = null, c = null;
        Scanner nhap = new Scanner(System.in);
        do {
            Bangcaro(array1);
            
            do {
                System.out.print("Player "+ flag +": ");
                so = nhap.nextInt();
                a = Nhap(array1,so,flag);
                if (flag == 1 && a.equals("Done"))
                    flag = 2;
                else if (flag == 2 && a.equals("Done"))
                    flag = 1;
                
                if (a.equals("Done"))
                    dem++;
            } while(a.equals("Not")); 
            
            if (dem >= 5) {
                c = KiemTra(array1,dem);
                if (c.equals("draw")) {
                    Bangcaro(array1);
                    return "0";
                }
                else if (c.equals("X") || c.equals("O")) {
                    Bangcaro(array1);
                    return c;
                }
            }

        } while (true);
    }

    private String Nhap(String[] array1, int so, int flag) {
        if (so <= 9 && so >= 1 && array1[so-1] != "X" && array1[so-1] != "O") {
            String Dau = "X";
            if (flag == 2)
                Dau = "O";
            array1[so-1] = Dau;
            return "Done";
        }
        else 
            return "Not";
    }

    private void Bangcaro(String[] array) {
        System.out.println("-------------------");
        System.out.println("|  "+ array[0] +"  |  "+ array[1] +"  |  "+ array[2] +"  |");
        System.out.println("-------------------");
        System.out.println("|  "+ array[3] +"  |  "+ array[4] +"  |  "+ array[5] +"  |");
        System.out.println("-------------------");
        System.out.println("|  "+ array[6] +"  |  "+ array[7] +"  |  "+ array[8] +"  |");
        System.out.println("-------------------");
    }

    private String KiemTra(String[] array,int i) {
        if (array[0].equals(array[1]) && array[0].equals(array[2]))
            return array[0];
        else if (array[3].equals(array[4]) && array[3].equals(array[5]))
            return array[3];
        else if (array[6].equals(array[7]) && array[6].equals(array[8]))
            return array[6];
        else if (array[0].equals(array[3]) && array[0].equals(array[6]))
            return array[0];
        else if (array[1].equals(array[4]) && array[1].equals(array[7]))
            return array[1];
        else if (array[2].equals(array[5]) && array[2].equals(array[8]))
            return array[2];
        else if (array[0].equals(array[4]) && array[0].equals(array[8]))
            return array[0];
        else if (array[2].equals(array[4]) && array[2].equals(array[6]))
            return array[2];
        else if (i == 9) 
            return "draw";
        return "";
    }
}