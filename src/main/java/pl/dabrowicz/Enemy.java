package pl.dabrowicz;

public class Enemy {
    private String enemyName;
    private ElementType enemyElement;

    public Enemy(){

    }

    public Enemy (String enemyName, ElementType enemyElement) {
        this.enemyName = enemyName;
        this.enemyElement = enemyElement;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public ElementType getEnemyElement() {
        return enemyElement;
    }

    public void setEnemyElement(ElementType enemyElement) {
        this.enemyElement = enemyElement;
    }

    public void displayEnemy() {
        System.out.println(enemyName);
    }

    @Override
    public String toString() {
        return String.format(enemyName, enemyElement);
    }


}
