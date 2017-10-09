import java.util.ArrayList;
import java.util.List;

public class Gandalf {
    private List<String> foods;
    private int happiness;
    private String mood;

    public Gandalf() {
        this.foods = new ArrayList<>();
    }

    private List<String> getFoods() {
        return this.foods;
    }

    public void addFoods(List<String> foods) {

        foods.stream().forEach(f -> this.foods.add(f));
    }

    private int getHappiness() {
        return this.happiness;
    }

    public void setHappiness() {
        this.getFoods().stream().forEach(f -> {
            switch (f.toLowerCase()) {
                case "cram":
                    this.happiness += 2;
                    break;
                case "lembas":
                    this.happiness += 3;
                    break;
                case "apple":
                    this.happiness += 1;
                    break;
                case "melon":
                    this.happiness += 1;
                    break;
                case "honeycake":
                    this.happiness += 5;
                    break;
                case "mushrooms":
                    this.happiness -= 10;
                    break;
                default:
                    this.happiness -= 1;
                    break;
            }
        });
        this.setMood(this.getHappiness());
    }


    private String getMood() {
        return this.mood;
    }

    private void setMood(int happiness) {
        if (happiness < -5) {
            this.mood = "Angry";
        } else if (happiness >= -5 && happiness < 0) {
            this.mood = "Sad";
        } else if (happiness >= 0 && happiness <= 15) {
            this.mood = "Happy";
        } else {
            this.mood = "JavaScript";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d%n", this.getHappiness()));
        sb.append(String.format("%s", this.getMood()));

        return sb.toString();
    }
}
