package ru.geerbrains;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Vlad"), new Cat("Murka"), new Dog("Sharik")};
        Team team = new Team(competitors);
        Course course = new Course(new Cross(100), new Wall(4), new Wall(6), new Cross(120));
        course.doIt(team);
        team.showWinners();
    }
}