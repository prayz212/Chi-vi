import java.util.Scanner;

public class Main {
    public static void OnePlayer (Scanner input) {
        Player NguoiChoi = new Player();
        input.nextLine();
        System.out.print("Enter player name: ");
        String name = input.nextLine();
        NguoiChoi.setName(name);
        NguoiChoi.setSign("X");
        Game1Player game = new Game1Player();

        String result = game.startGame();

        if (result.equals(NguoiChoi.getSign()))
            System.out.println("Congratulations!!!" + NguoiChoi.getName() + " is winner.");
        else if (result.equals("O"))
            System.out.println("Congratulations!!! Computer is winner.");
        else 
            System.out.println("Dawing!!! Try harder ^_^.");
    }

    public static void TwoPlayer (Scanner input) {
        String name;

        Player NguoiChoi1 = new Player();
        input.nextLine(); // tranh tinh trang ko nhap duoc player 1
        System.out.print("Enter player 1 name: ");
        name = input.nextLine();
        NguoiChoi1.setName(name);
        NguoiChoi1.setSign("X");

        Player NguoiChoi2 = new Player();
        System.out.print("Enter player 2 name: ");
        name = input.nextLine();
        NguoiChoi2.setName(name);
        NguoiChoi2.setSign("O");

        Game2Player game = new Game2Player();

        String result = game.startGame();

        if (result.equals(NguoiChoi1.getSign()))
            System.out.println("Congratulations!!!" + NguoiChoi1.getName() + " is winner.");
        else if (result.equals(NguoiChoi2.getSign()))
            System.out.println("Congratulations!!!" + NguoiChoi2.getName() + " is winner.");
        else 
            System.out.println("Dawing!!! Try harder ^_^.");

    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Press 1 => Play with computer!");
        System.out.println("Press 2 => Play with your friends!");
        System.out.print("Enter your chosen: ");
        int chosen = input.nextInt();

        switch (chosen) {
            case 1: 
                OnePlayer(input);
                break;
            case 2: 
                TwoPlayer(input);
                break;
        }
    }
}