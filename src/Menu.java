import mobs.Dragons;

import java.util.Scanner;

public class Menu {
    int balance = 20000;
    int energy = 10;
    Hero hero;
    Scanner scanner = new Scanner(System.in);

    public void glavMenu() {
        System.out.println("Balance " + balance);
        System.out.println("1 Создать персонажа");
        System.out.println("2 Начать сражения");
        System.out.println("3 Прокачка персонажа");
        String answer = scanner.nextLine();

        switch (answer) {
            case "1" -> {
                menuCreateHero();
            }
            case "2" -> {
                arena();
            }
            case "3" -> {
            }
            default -> {
                System.out.println("Выберите один из пунктов меню");
                glavMenu();
            }
        }
    }

    public void arena() {
        Dragons dragons = new Dragons();
        DarkKnight darkKnight = new DarkKnight();
        System.out.println("Выберите противника");
        System.out.println("1 Дракон - 500 золота");
        System.out.println("2 Темный Страж - 1000 золота ");
        System.out.println("----------------------------");
        String answer = scanner.nextLine();
        if (answer.equals("1")) {
            balance=balance-500;
            while (true) {
                dragons.hp -= hero.damage / 2; // 500-200
                System.out.println(hero.name + " атаковал дракона (нанес " + hero.damage / 2 + ")" + "хр дракона "
                        + dragons.hp);
                hero.setXp(dragons.attack / 2);
                System.out.println("\u001B[31m" + " Dragons атаковал Героя (нанес " + dragons.attack / 2 + ")" +
                        "xp героя " + hero.getXp() + "\u001B[0m");

                if (dragons.hp < 0) {
                    System.out.println(hero.name + " победил");
                    energy=energy-1;
                    System.out.println("Энергия: "+energy);
                    break;
                } else if (hero.getXp() < 0) {
                    System.out.println("победил дракон ");
                    energy=energy-2;
                    System.out.println("Энергия: "+energy);
                    break;
                }
            }
        } else if (answer.equals("2")) {
            balance=balance-1000;
            while (true) {
                darkKnight.hp -= hero.damage / 3;
                System.out.println(hero.name + " атаковал темного рыцаря (нанес " + hero.damage / 3 + ")" +
                        "хр темного рыцаря " + darkKnight.hp);
                hero.setXp(darkKnight.attack / 2);
                System.out.println("\u001B[31m" + " Тёмный рыцарь атаковал Героя (нанес " + darkKnight.attack / 3 + ")" +
                        "xp героя " + hero.getXp() + "\u001B[0m");

                if (darkKnight.hp < 0) {
                    balance=balance+200;
                    energy=energy-1;
                    System.out.println(hero.name + " победил");
                    break;
                } else if (hero.getXp() < 0) {
                    balance=balance-100;
                    energy=energy-1;
                    System.out.println("победил Темный рыцарь ");

                    break;
                }
            }

        } System.out.println("----------------------------");
        glavMenu();
    }

    public void menuCreateHero() {

        System.out.println("Выберите расу персонажа");
        System.out.println("1 Человек");
        System.out.println("2 Эльф");
        System.out.println("3 Орк");

        String answer = scanner.nextLine();

        if (answer.equals("1")) {
            toCreateHuman();
            glavMenu();
        } else if (answer.equals("2")) {
            toCreateElf();
            glavMenu();
        } else if (answer.equals("3")) {
            toCreateOrk();
            glavMenu();
        } else {
            menuCreateHero();
        }
    }

    public void toCreateHuman() {
        balance= balance-1000;
        System.out.println( "Энергия персонажа: " + energy);
        System.out.println("Введите имя героя ");
        String name = scanner.nextLine();

        while (true) {
            String raasa = choiceRace();
            if (raasa.equals("маг")) {
                hero = new Human(1, 100, 900, 50, name, raasa,energy);
                hero.info();
                break;
            } else if (raasa.equals("охотник")) {
                hero = new Human(1, 1150, 400, 300, name, raasa,energy);
                hero.info();
                break;
            } else if (raasa.equals("воин")) {
                hero = new Human(1, 300, 100, 600, name, raasa,energy);
                hero.info();
                break;
            } else {
                System.out.println("введите расу еще раз");
                toCreateHuman();

            }
        }
    }

    public void toCreateElf() {
        balance= balance-1000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя героя ");
        String name = scanner.nextLine();

        while (true) {
            String raasa = choiceRace();
            if (raasa.equals("маг")) {
                hero = new Elf(1, 100, 1000, 90, name, raasa,energy);
                hero.info();
                break;
            } else if (raasa.equals("охотник")) {
                hero = new Elf(1, 200, 700, 350, name, raasa,energy);
                hero.info();
                break;
            } else if (raasa.equals("воин")) {
                hero = new Elf(1, 300, 100, 700, name, raasa,energy);
                hero.info();
                break;
            } else {
                System.out.println("введите расу еще раз");
                toCreateElf();

            }
        }
    }

    public void toCreateOrk() {
        balance= balance-1000;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя героя ");
        String name = scanner.nextLine();

        while (true) {
            String raasa = choiceRace();
            if (raasa.equals("маг")) {
                hero = new Ork(1, 200, 600, 200, name, raasa,energy);
                hero.info();
                break;
            } else if (raasa.equals("охотник")) {
                hero = new Ork(1, 300, 400, 600, name, raasa, energy);
                hero.info();
                break;
            } else if (raasa.equals("воин")) {
                hero = new Ork(1, 400, 200, 1100, name, raasa,energy);
                hero.info();
                break;
            } else {
                System.out.println("введите специализацию еще раз");
            }
        }
    }

    public String choiceRace() {
        System.out.println("Выберите специализацию");
        System.out.println("1 охотник");
        System.out.println("2 маг");
        System.out.println("3 воин");

        String nameRasa = scanner.nextLine();
        if (nameRasa.equals("1")) {
            return "охотник";
        } else if (nameRasa.equals("2")) {
            return "маг";
        } else if (nameRasa.equals("3")) {
            return "воин";
        } else {
            return "";
        }
    }
}

