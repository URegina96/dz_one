package com.example.astar_dz;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Users {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String nameUsers;
    public int ageUsers;

    public Users(String nameUsers, int ageUsers) {
        this.nameUsers = nameUsers;
        this.ageUsers = ageUsers;
    }

    @Override
    public String toString() {
        return "Users{" +
                "name=" + nameUsers +
                ", age=" + ageUsers +
                '}';
    }
}
//    Давайте разберем этот код поэтапно:
//
//@Entity(tableName = "users")
//это аннотация, которая помечает класс User как сущность, представляющую таблицу в базе данных. Аннотация @Entity указывает имя таблицы, которая будет называться "users".
//
//public class User
//это объявление класса User, который представляет модель данных пользователя.
//
//@PrimaryKey(autoGenerate = true)
//это аннотация, которая указывает, что поле id является первичным ключом для таблицы. autoGenerate = true означает, что значения для id будут автоматически генерироваться при вставке нового пользователя в базу данных.
//
//public long id;
//        это объявление поля id, которое будет использоваться как первичный ключ в базе данных.
//
//public String name;
//        это объявление поля name, которое представляет имя пользователя.
//
//public int age;
//        это объявление поля age, которое представляет возраст пользователя.
//
//public User(String name, int age)
//        это объявление конструктора класса User, который принимает параметры name и age для инициализации полей объекта.
//
//@Override public String toString()
//        это аннотация, указывающая на переопределение метода toString() из класса Object. Метод toString() возвращает строковое представление объекта User.
//
//        return "User{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + '}';
//        это строковое представление объекта User, которое включает значения полей id, name и age.
