package ru.geerbrains;



public class Main {
    public static void main(String[] args) {
        DataBase dataBase = new DataBase();
        dataBase.getConnectionToDB(DataBase.DB_URL, DataBase.USER, DataBase.PASSWORD, "log3");
    }
}