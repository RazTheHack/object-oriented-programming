package p5;

public class Game {
    private Player player1, player2;

    public Game(Player player1, Player player2) { 
        this.player1 = player1;
        this.player2 = player2; 
    } 

    public int playerThrows(Player player, boolean showThrows) {
        int nbrOfThrows = -1, aThrow;
        String res = player.getName() + " :";
        do {
            aThrow = player.throwDice();
            nbrOfThrows++;
            res += aThrow + " ";
        } while (aThrow != 1);
        if (showThrows) {
            TextWindow.println(res);
        }
        return nbrOfThrows;
    }

    public void play(boolean showThrows) {
        int p1 = 0, p2 = 0;
        p1 = playerThrows(player1, showThrows);
        p2 = playerThrows(player2, showThrows);
        if (p1 > p2) {
            TextWindow.println(player1.getName() + " vann över "
                    + player2.getName() + "  " + p1 + "-" + p2);
        } else if (p2 > p1) {
            TextWindow.println(player2.getName() + " vann över "
                    + player1.getName() + "  " + p2 + "-" + p1);
        } else {
            TextWindow.println("Oavgjort mellan " + player1.getName() + " och "
                    + player2.getName() + "  " + p1 + "-" + p2);
        }
    }
    public static void main(String[] args) {
    	SimpleDice dice = new SimpleDice( 6 );
    	Player player1 = new OrdinaryPlayer( "Gustav", dice );
    	Player player2 = new OrdinaryPlayer( "Valborg", dice );
    	Game game = new Game( player1, player2 );
    	game.play( true );
	}
}