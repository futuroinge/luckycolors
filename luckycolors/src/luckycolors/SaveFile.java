package luckycolors;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SaveFile {

    private static final String FILENAME = "scoreboard.csv";
    private ArrayList<Player> scores;
    private String name;
    private int score;
    private int level;

    public SaveFile(String name, int score, int level) {
        this.scores = new ArrayList<>();
        this.name = name;
        this.score = score;
        this.level = level;
    }

    public void saveScore() {
        loadScores();
        scores.add(new Player(level, name, score));

        scores.sort(Comparator.comparingInt(Player::getLevel)
                .thenComparing(Player::getScore, Comparator.reverseOrder()));

        List<Player> topScores = new ArrayList<>();
        for (int lvl = 1; lvl <= 3; lvl++) {
            int count = 0;
            for (Player entry : scores) {
                if (entry.getLevel() == lvl) {
                    topScores.add(entry);
                    if (++count == 10) {
                        break;
                    }
                }
            }
        }
        writeScoresToFile(topScores);
    }

    private void loadScores() {
        scores.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int level = Integer.parseInt(parts[0]);
                    String existingName = parts[1];
                    int existingScore = Integer.parseInt(parts[2]);
                    scores.add(new Player(level, existingName, existingScore));
                }
            }
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }
    }

    private void writeScoresToFile(List<Player> topScores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Player entry : topScores) {
                writer.write(entry.getLevel() + "," + entry.getName() + "," + entry.getScore());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }
    }

    public SaveFile(int level) {
        this.level = level;
        this.scores = new ArrayList<>();
        getFullScoreboard();
    }

    // Method to read scores from the file and filter by level
    private void getFullScoreboard() {
        String filename = "scoreboard.csv";
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.charAt(0) == (char) ('0' + level)) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String name = parts[1];
                        int score = Integer.parseInt(parts[2]);
                        scores.add(new Player(name, score));
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        if (scores.isEmpty()) {
            System.out.println("Sin ningun registro en el nivel " + level);
        }
    }

    public List<Player> getFilteredScores() {
        return scores;
    }
}
