package com.example.astar_dz;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDatabaseDao {
    void addUser(Users users);

    @Query("SELECT * FROM users")
    List<User> getUsers();
}
//Этот код представляет интерфейс UsersDao, который определяет методы для доступа к данным пользователей. Давайте распишем, что здесь происходит:
//
//@Dao
//это аннотация, которая помечает интерфейс как объект доступа к данным (Data Access Object).
//
//public interface UsersDao
//это объявление интерфейса UsersDao, который будет использоваться для взаимодействия с таблицей пользователей в базе данных.
//
//@Insert void addUser(User user)
// это объявление метода addUser, который используется для добавления нового пользователя в базу данных. Аннотация @Insert указывает, что этот метод должен выполнять операцию вставки данных.
//
//@Query("SELECT * FROM users")
//это объявление метода getUsers, который используется для получения списка всех пользователей из базы данных. Аннотация @Query указывает, что этот метод должен выполнить запрос на выборку данных. Здесь указан запрос "SELECT * FROM users", который выбирает все столбцы из таблицы "users".
//
//List<User> getUsers()
//это объявление возвращаемого типа метода getUsers. Он возвращает список объектов типа User, которые представляют записи пользователей из таблицы базы данных.
