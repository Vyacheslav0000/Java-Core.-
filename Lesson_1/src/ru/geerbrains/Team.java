package ru.geerbrains;

public class Team {
    private Competitor[] members;

    public Competitor[] getMembers() {
        return members;
    }

    public Team(Competitor...members) {
        this.members = members;
    }

    public void showWinners(Competitor...members) {
        for(Competitor o: members) {
            if(o.isOnDistance()) {
                o.info();
            }
        }
    }

    public void showWinners() {
        for(Competitor o: members) {
            if(o.isOnDistance()) {
                o.info();
            }
        }
    }
}