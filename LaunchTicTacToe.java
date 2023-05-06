import java.util.Scanner;

class TicTacToe{
    static char[] arr = {'0','1','2','3','4','5','6','7','8','9'};
    static int count=0, res;

    public static void start(){
        board();
        play();
    }

    private static void board(){
        System.out.println("\n\t==================");
        System.out.println("\t---Tic-Tac-Toe---");
        System.out.println("\t==================\n");
        System.out.println("\t     |     |     ");
        System.out.println("\t  "+arr[1]+"  |  "+arr[2]+"  |  "+arr[3]+"  ");
        System.out.println("\t     |     |     ");
        System.out.println("\t-----------------");
        System.out.println("\t     |     |     ");
        System.out.println("\t  "+arr[4]+"  |  "+arr[5]+"  |  "+arr[6]+"  ");
        System.out.println("\t     |     |     ");
        System.out.println("\t-----------------");
        System.out.println("\t     |     |     ");
        System.out.println("\t  "+arr[7]+"  |  "+arr[8]+"  |  "+arr[9]+"  ");
        System.out.println("\t     |     |     ");

    }

    private static void play(){
        Scanner sc =  new Scanner(System.in);
        int player = 1;
        do{
            if(player%2==1){
                player = 1;
            }
            else{
                player = 2;
            }
            System.out.println("Player "+player+" Turn : ");
            System.out.println("Enter the position where you want to insert your Symbol: ");
            int n = sc.nextInt();

            if(isPositionAvailable(n)){
                if(player==1){
                    arr[n] = 'O';
                    player++;
                }
                else{
                    arr[n] = 'X';
                    player++;
                }
            }
            else{
                System.out.println("Entered location is already chosen by another player");
                System.out.println("Enter any other location");
            }
            res = checkWin();
            board();
            
        }while(res==0);
        if(res==1){
            System.out.println("Player "+(--player)+" Won The match");
        }
        else{
            System.out.println("Match Draw");
        }
        sc.close();
    }

    private static boolean isPositionAvailable(int n){
        if(arr[n]=='1' || arr[n]=='2' || arr[n]=='3' || arr[n]=='4' || arr[n]=='5' || arr[n]=='6' || arr[n]=='7' || arr[n]=='8' || arr[n]=='9'){
            return true;
        }    
        else{
            return false;
        }
    }

    private static int checkWin(){
        if(arr[1]==arr[2] && arr[2]==arr[3]){
            return 1;
        }
        else if(arr[4]==arr[5] &&  arr[5]==arr[6]){
            return 1;
        }
        else if(arr[7]==arr[8] && arr[8]==arr[9]){
            return 1;
        }
        else if(arr[1]==arr[4] && arr[4]==arr[7]){
            return 1;
        }
        else if(arr[2]==arr[5] && arr[5]==arr[8]){
            return 1;
        }
        else if(arr[3]==arr[6] && arr[6]==arr[9]){
            return 1;
        }
        else if(arr[1]==arr[5] && arr[5]==arr[9]){
            return 1;
        }
        else if(arr[3]==arr[5] && arr[5]==arr[7]){
            return 1;
        }
        else if(arr[1]!='1' && arr[2]!='2' && arr[3]!='3' && arr[4]!='4' && arr[5]!='5' && arr[6]!='6' && arr[7]!='7' && arr[8]!='8' && arr[9]!='9'){
            return -1;
        }
        else{
            return 0;
        }
    }
}
public class LaunchTicTacToe {
    public static void main(String[] args) {
        TicTacToe.start();
    }
}
