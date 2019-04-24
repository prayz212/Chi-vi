import java.util.*;

public class Game1Player {
    public String startGame() {
        String[] board = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int so = 0, flag = 1;
        Scanner nhap = new Scanner(System.in);
        PrintBoard(board);

        do {
            if (flag == 1) {
                System.out.print("Enter your turn: ");
                so = nhap.nextInt();
                Nhap(board,so,flag);
            }
            else if (flag == 2) 
                Minimax(board);
            
            PrintBoard(board);

            int count = countEmpty(board).length;

            if (count <= 3) {
                if (isWin(board) == true) {
                    if (flag == 1)
                        return "X";
                    else if (flag == 2)
                        return "O";
                }
                else if (count == 0)
                    return "0";                    
                }

            if (flag == 1)
                flag = 2;
            else 
                flag = 1;

        } while (true);
    }

    private void Minimax(String[] board) {
        int bestMove;
        List <Integer> listE_n = new LinkedList <Integer> ();  
        for (int x : countEmpty(board))
        {
            String[] coppy_1 = coppyBoard(board);
            Nhap(coppy_1, x + 1, 2);

            if (isWin(coppy_1) == true)
                listE_n.add(1000);

            List<Integer> listE_n_min = new LinkedList<Integer>();  
            
            if (countEmpty(coppy_1).length > 0) {
                for (int y : countEmpty(coppy_1)) 
                {
                    String[] coppy_2 = coppyBoard(coppy_1);
                    Nhap(coppy_2, y + 1, 1);

                    if (isWin(coppy_2) == true)
                        listE_n_min.add(-1000);

                    List<Integer> listE_n_max = new LinkedList<Integer>();                

                    if (countEmpty(coppy_2).length > 0) {
                        for (int z : countEmpty(coppy_2))
                        {
                            String[] coppy_3 = coppyBoard(coppy_2);
                            Nhap(coppy_3, z + 1, 2);
                            listE_n_max.add(countWay(coppy_3, "O") - countWay(coppy_3, "X"));
                        }
                        
                        listE_n_min.add(Collections.max(listE_n_max));
                    }
                    else {
                        listE_n_min.add(countWay(coppy_2, "O") - countWay(coppy_2, "X"));
                    }
                }
            
                listE_n.add(Collections.min(listE_n_min));
            }
            else {
                listE_n.add(countWay(coppy_1, "O") - countWay(coppy_1, "X"));
            }

        }
        int index = 0;
        int max = Collections.max(listE_n);
        for (int x : listE_n) {
            if (x == max)
                break;
            index++;
        }

        bestMove = countEmpty(board)[index];
        Nhap(board, bestMove + 1, 2);
        System.out.println("Computer turn: " + (bestMove + 1));
    }

    private void Nhap(String[] array1, int so, int flag) {
        boolean state = true;
        while (state)
        {
            if (so <= 9 && so >= 1 && array1[so-1] != "X" && array1[so-1] != "O") {
                String Dau = "X";
                if (flag == 2)
                    Dau = "O";
                array1[so-1] = Dau;
                state = false;
            }
            else {
                System.out.print("Enter your turn again: ");
                Scanner nhap = new Scanner(System.in);
                so = nhap.nextInt();
                state = true;
            }
        }
    }

    private int countWay(String[] board, String sign) {
        int count = 8;
        String op_sign = null;

        if (sign.equals("X"))
            op_sign = "O";
        else 
            op_sign = "X";            

        // Kiem tra 3 hang ngang.
        for (int i = 0; i <= 8; i = i + 3) {
            if (board[i].equals(op_sign) || board[i + 1].equals(op_sign) || board[i + 2].equals(op_sign))
                count--;
        }

        // Kiem tra 3 hang doc
        for (int i = 0; i <= 2; i++) {
            if (board[i].equals(op_sign) || board[i + 3].equals(op_sign) || board[i + 6].equals(op_sign))
                count--;
        }

        // Kiem tra 2 hang cheo
        if (board[0].equals(op_sign) || board[4].equals(op_sign) || board[8].equals(op_sign))
                count--;
        if (board[2].equals(op_sign) || board[4].equals(op_sign) || board[6].equals(op_sign))
                count--;

        return count;
    }

    private int[] countEmpty(String[] board) {
        LinkedList<Integer> Cell = new LinkedList<Integer>();  
    
        for (int i = 0; i <= 8; i++) {
            if (!board[i].equals("X") && !board[i].equals("O"))
                Cell.add(i);
        }
        
        int n = Cell.size();
        int[] emptyCell = new int[n];

        // Coppy sang mang.
        for (int i = 0; i < n; i++) 
            emptyCell[i] = Cell.removeFirst();

        return emptyCell;
    }

    private void PrintBoard(String[] array) {
        System.out.println("-------------------");
        System.out.println("|  "+ array[0] +"  |  "+ array[1] +"  |  "+ array[2] +"  |");
        System.out.println("-------------------");
        System.out.println("|  "+ array[3] +"  |  "+ array[4] +"  |  "+ array[5] +"  |");
        System.out.println("-------------------");
        System.out.println("|  "+ array[6] +"  |  "+ array[7] +"  |  "+ array[8] +"  |");
        System.out.println("-------------------");
    }

    private boolean isWin(String[] board) {
        for (int i = 0; i <= 8; i = i + 3) {
            if (board[i].equals(board[i + 1]) && board[i + 1].equals(board[i + 2]))
                return true;
        }

        // Kiem tra 3 hang doc
        for (int i = 0; i <= 2; i++) {
            if (board[i].equals(board[i + 3]) && board[i + 3].equals(board[i + 6]))
                return true;
        }

        // Kiem tra 2 hang cheo
        if (board[0].equals(board[4]) && board[4].equals(board[8]))
                return true;
        if (board[2].equals(board[4]) && board[4].equals(board[6]))
                return true;
        return false;
    }

    private String[] coppyBoard(String[] board) {
        String[] coppy = new String[board.length];
        for (int i = 0; i < board.length; i++)
            coppy[i] = board[i];

        return coppy;
    }

    
}
