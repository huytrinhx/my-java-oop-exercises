package basketball_tournament;

import java.util.List;
import java.util.ArrayList;

class Game {
    public int gameNumber;
    public String date;
    public Team homeTeam;
    public Team awayTeam;
    public int attendance;
    public List<PlayerGameStats> playerGameStats;

    int homeTeamScore;
    int awayTeamScore;
    int winnerScore;
    int loserScore;
    Team winner;
    Team loser;

    public Game(int gameNumber, String date, Team homeTeam,
            Team awayTeam, int attendance) {
        this.gameNumber = gameNumber;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.attendance = attendance;
        this.playerGameStats = new ArrayList<>();
    }

    // Getters and setters
    public Team getHomeTeam() {
        return awayTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void addPlayerGameStats(PlayerGameStats stats) {
        playerGameStats.add(stats);
    }

    public List<PlayerGameStats> getPlayerGameStats() {
        return playerGameStats;
    }

    // Method to populate games
    public static List<Game> populateGame(List<Team> teams, String[][] gameData) {
        List<Game> games = new ArrayList<>();
        for (String[] data : gameData) {
            int gameNumber = Integer.parseInt(data[0]); // Game number
            String date = data[1]; // Game date
            Team homeTeam = teams.get(Integer.parseInt(data[2])); // Get home team
            Team awayTeam = teams.get(Integer.parseInt(data[3])); // Get away team
            int attendance = Integer.parseInt(data[4]); // Attendance
            // Create and add game to list
            Game game = new Game(gameNumber, date, homeTeam, awayTeam, attendance);
            games.add(game);
        }
        return games;
    }

    public void printGameDetails() {
        System.out.format("Game # %s:\n", gameNumber);
        System.out.format("Team %s score: %d \n", homeTeam.name, getTeamScore(homeTeam));
        System.out.format("Team %s score: %d \n", awayTeam.name, getTeamScore(awayTeam));
        getGameSummary();
        System.out.println("------------------------------------------------------------");
        System.out.format("Team: %s, Highest scorer: %s \n", homeTeam.name, getHighestTeamScorer(homeTeam));
        System.out.format("Team: %s, Highest scorer: %s \n", awayTeam.name, getHighestTeamScorer(awayTeam));
        System.out.println("------------------------------------------------------------");
    }

    // Add function to get sum of the PlayerGameScore for each player
    // in the game to compute the team score here
    public int getTeamScore(Team team) {
        int score = 0;
        for (PlayerGameStats s : playerGameStats) {
            if (team.hasPlayer(s.player)) {
                score += s.getPlayerGameScore();
            }
        }
        return score;
    }

    // Add function to get game summary here
    public void getGameSummary() {
        homeTeamScore = getTeamScore(homeTeam);
        awayTeamScore = getTeamScore(awayTeam);
        if (homeTeamScore > awayTeamScore) {
            winner = homeTeam;
            winnerScore = homeTeamScore;
            loser = awayTeam;
            loserScore = awayTeamScore;
        } else {
            winner = awayTeam;
            winnerScore = awayTeamScore;
            loser = homeTeam;
            loserScore = homeTeamScore;
        }

        System.out.format("%s wins against %s with a score of %d - %d \n", winner.name, loser.name, winnerScore,
                loserScore);
    }

    // Add function to get highest team scorer here
    public String getHighestTeamScorer(Team team) {
        Player mvp = new Player("", 0);
        int score = 0;
        for (PlayerGameStats s : playerGameStats) {
            if (team.hasPlayer(s.player) && s.getPlayerGameScore() > score) {
                score = s.getPlayerGameScore();
                mvp = s.player;
            }
        }
        return mvp.name;

    }
}