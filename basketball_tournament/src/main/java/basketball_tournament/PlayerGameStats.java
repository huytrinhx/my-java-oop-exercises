package basketball_tournament;

import java.util.List;
import java.util.ArrayList;

public class PlayerGameStats {
    public Game game;
    public Player player;
    public int fieldGoals;
    public int threePoints;
    public int freeThrows;
    public int offensiveRebounds;
    public int defensiveRebounds;
    public int assists;

    public PlayerGameStats(Game game, 
                            Player player, 
                            int fieldGoals, 
                            int threePoints, 
                            int freeThrows, 
                            int offensiveRebounds, 
                            int defensiveRebounds, 
                            int assists) { 
    this.game = game;
    this.player = player;
    this.fieldGoals = fieldGoals;
    this.threePoints = threePoints;
    this.freeThrows = freeThrows;
    this.offensiveRebounds = offensiveRebounds;
    this.defensiveRebounds = defensiveRebounds;
    this.assists = assists;
    }

    // Getters and setters
    public Player getPlayer() {
        return player;
    }

    public int getOffensiveRebounds() {
        return offensiveRebounds;
    }

    public int getDefensiveRebounds() {
        return defensiveRebounds;
    }

    public int getAssists() {
        return assists;
    }
    
    // Add method to get individual score by a player in a game here
    public int getPlayerGameScore() {
        return fieldGoals * 2 + threePoints + freeThrows;
    }
   

    // Add method to populate player game stats here
    public static List<PlayerGameStats> populatePlayerGameStats(int[][] playerGameStat, Game game, List<Player> players) {
        List<PlayerGameStats> output = new ArrayList<>();
        int i = 0;
        for (int[] stat: playerGameStat) {
            PlayerGameStats s = new PlayerGameStats(game, players.get(i), stat[0], stat[1], stat[2], stat[3], stat[4], stat[5]);
            output.add(s);
            i++;
        }

        return output;

    }
}
