package player;

public class Player implements Comparable<Player> {

    int id;
    String name;
    String surname;

    public Player (int id, String name, String surname){
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public int compareTo(Player player) {
        int result = this.surname.compareTo(player.surname);
        if (result == 0){
            result = this.name.compareTo(player.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return this.id + "|" + this.name + "|" + this.surname;
    }
}
