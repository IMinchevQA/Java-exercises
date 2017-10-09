public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private String getFlourType() {
        return this.flourType;
    }

    private void setFlourType(String flourType) {
        String currentFlourType = flourType.toLowerCase().trim();
        if(!currentFlourType.equals("white") && !currentFlourType.equals("wholegrain")) {
            throw new CE("Invalid type of dough.");
        }

        this.flourType = flourType;
    }

    private double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new CE("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private String getBakingTechnique() {
        return this.bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        String currentBakingTechnique = bakingTechnique.toLowerCase().trim();
        if (!currentBakingTechnique.equals("crispy") &&
            !currentBakingTechnique.equals("chewy") &&
            !currentBakingTechnique.equals("homemade")) {
            throw new CE("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double CalculateDoughCalories() {
        double flourTypeModifier =  this.getFlourType().toLowerCase().trim().equals("white") ? 1.5 : 1.0;
        double bakingTechniqueModifier = getBakingTechniqueModifier();
        return (2 * this.getWeight()) * flourTypeModifier * bakingTechniqueModifier;
    }

    private double getBakingTechniqueModifier(){
        switch (this.getBakingTechnique().toLowerCase().trim()) {
            case "crispy":
                return 0.9;
            case "chewy":
                return 1.1;
            default:
                return 1.0;
        }
    }
}
