package pl.dabrowicz;

import java.util.*;

public class Game implements Task {
    Random random = new Random();

    List<String> enemyNames = Arrays.asList("Cumberbatch", "Custardbath", "Bennedict", "Wellington", "Lumberjack", "Bumbleshack", "Toodlesnoot", "Blenderdick",
            "Bentobox", "Charizard", "Bonaparte", "Crimpysnitch", "Rinkydink", "Commonwealth", "Buffalo", "Banglesnatch", "Ardo", "Fresher", "Zyxen", "Arek",
            "Adam", "Karol", "Jakub", "Miłosz", "Paweł", "Jasiek", "Mccon");
    List<ElementType> elements = new ArrayList<>();
    List<Enemy> enemies = new ArrayList<>();

    Player player = new Player();

    int level = 1;

    ElementType fire = ElementType.FIRE;
    ElementType water = ElementType.WATER;
    ElementType air = ElementType.AIR;
    ElementType dirt = ElementType.DIRT;


    @Override
    public void run() {
        elements.add(fire);
        elements.add(water);
        elements.add(air);
        elements.add(dirt);

        startGame();
       /* chooseElement();
        player.displayPlayer();
        chooseEnemy();
        fight();*/

    }


    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*********************************");
        System.out.println("        *** ELEMENTS ***");
        System.out.println("*********************************");
        System.out.println();
        System.out.println("Welcome to Elements. What's your name?");

        player.setName(scanner.nextLine());

        chooseElement();
    }

    public void chooseElement() {
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("Choose the element, that you want to posess:");
        System.out.println("1. Fire");
        System.out.println("2. Water");
        System.out.println("3. Air");
        System.out.println("4. Dirt");

        int choosenElement = scanner.nextInt();

        switch (choosenElement) {
            case 1:
                System.out.println("You chose Fire." + "\n");
                player.setElement(ElementType.FIRE);
                break;
            case 2:
                System.out.println("You chose Water." + "\n");
                player.setElement(ElementType.WATER);
                break;
            case 3:
                System.out.println("You chose Air." + "\n");
                player.setElement(ElementType.AIR);
                break;
            case 4:
                System.out.println("You chose Dirt." + "\n");
                player.setElement(ElementType.DIRT);
                break;
        }
        chooseEnemy();
    }

    public void chooseEnemy() {
        Scanner scanner = new Scanner(System.in);
        Enemy enemy1 = new Enemy();
        Enemy enemy2 = new Enemy();

        System.out.println("***********" + "\n" + "* Level " + level + " *" + "\n" + "***********" + "\n");
        System.out.println("You are ready to fight. Time to choose your opponent: ");

        enemy1.setEnemyElement(elements.get(random.nextInt(elements.size())));
        enemy1.setEnemyName(enemyNames.get(random.nextInt(enemyNames.size())));
        enemy2.setEnemyElement(elements.get(random.nextInt(elements.size())));
        enemy2.setEnemyName(enemyNames.get(random.nextInt(enemyNames.size())));

        while ((enemy1.getEnemyName() == enemy2.getEnemyName()) || (enemy1.getEnemyElement() == enemy2.getEnemyElement())) {
            enemies.clear();
            enemy2.setEnemyName(enemyNames.get(random.nextInt(enemyNames.size())));
            enemy2.setEnemyElement(elements.get(random.nextInt(elements.size())));
        }

        System.out.println("Enemy number one is: ");
        enemy1.displayEnemy();
        System.out.println("While enemy number two's name is: ");
        enemy2.displayEnemy();

        int enemyChoice = scanner.nextInt();

        switch (enemyChoice) {
            case 1:
                System.out.println("You choose " + enemy1 + ". Let's go!" + "\n");
                enemies.add(enemy1);
                break;
            case 2:
                System.out.println("You choose " + enemy2 + ". Let's see who is gonna win." + "\n");
                enemies.add(enemy2);
                break;
        }
        fight();
    }

    public void fight() {
        Enemy enemy = enemies.get(0);

        ElementType playerElement = player.getElement();
        ElementType enemyElement = enemy.getEnemyElement();


        System.out.println("Your element is: " + playerElement);
        System.out.println("Your enemy's element is: " + enemyElement);

        System.out.println("Let the fight begin!" + "\n" + "\n");
        System.out.println("**********    " + player.getName() + "    vs    " + enemy.getEnemyName() + "    **********" + "\n" + "\n");



        if ((playerElement == ElementType.FIRE && (enemyElement == ElementType.DIRT || enemyElement == ElementType.WATER))
                || (playerElement == ElementType.WATER && enemyElement == ElementType.AIR)
                || (playerElement == ElementType.AIR && (enemyElement == ElementType.FIRE || enemyElement == ElementType.DIRT))
                || (playerElement == ElementType.DIRT && enemyElement == ElementType.WATER)) {
            loose();
        } else if ((playerElement == ElementType.FIRE && enemyElement == ElementType.AIR)
                || (playerElement == ElementType.WATER && (enemyElement == ElementType.FIRE || enemyElement == ElementType.DIRT))
                || (playerElement == ElementType.AIR && enemyElement == ElementType.WATER)
                || (playerElement == ElementType.DIRT && (enemyElement == ElementType.FIRE || enemyElement == ElementType.AIR))) {
            win();
        } else if ((playerElement == ElementType.FIRE && enemyElement == ElementType.FIRE)
                || (playerElement == ElementType.WATER && enemyElement == ElementType.WATER)
                || (playerElement == ElementType.AIR && enemyElement == ElementType.AIR)
                || (playerElement == ElementType.DIRT && enemyElement == ElementType.DIRT)) {
            draw();
        }
    }


    public void win() {
        Scanner scanner = new Scanner(System.in);
        Enemy enemy = enemies.get(0);
        String playerName = player.getName();
        System.out.println(playerName + " won! " + enemy + " Had no chance. Battle is done." + "\n" +
                "It's your choice now. You want to fight again, or end the journey here?");
        System.out.println("1 - Next fight");
        System.out.println("2 - Quit game");

        int userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
//                System.out.println("Choose next enemy:" + "\n");
                enemies.clear();
                level++;
                chooseEnemy();
                break;
            case 2:
                loose();
                break;
        }
    }

    public void loose() {
        System.out.println("You loose! Fight was tight, but you enemy was better. You can start over." + "\n" +
                "You reached level " + level + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n"
                + "\n" + "\n" + "\n");
        level = 1;
        enemies.clear();
        startGame();
    }

    public void draw() {
        System.out.println("It's the draw!" + "\n" + "You have to choose your opponent once again.");
        System.out.println();
        enemies.clear();
        chooseEnemy();
    }
}
