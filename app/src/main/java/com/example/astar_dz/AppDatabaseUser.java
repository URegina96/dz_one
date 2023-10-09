package com.example.astar_dz;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(version = 1, exportSchema = true, entities = {Users.class})
public abstract class AppDatabaseUser extends RoomDatabase {
    abstract UserDatabaseDao getUsersDao();

    public static AppDatabaseUser getInstance(Context context) {
        return Room.databaseBuilder(context, AppDatabaseUser.class, "database_example.db")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }
}
//    Давай разберем этот код поэтапно:
//
//        Аннотация @Database:
//        version = 2: указывает текущую версию базы данных (2 в данном случае).
//        exportSchema = false: отключает экспорт схемы базы данных.
//        entities = { User.class }: определяет классы-сущности, которые будут использоваться в базе данных. В данном случае, только класс User является сущностью в этой базе данных.
//
//        Абстрактный класс AppDatabase:
//        Наследуется от RoomDatabase, это абстрактный класс, предоставляемый библиотекой Room для работы с базами данных SQLite.
//
//      abstract UsersDao getUsersDao(): объявляет абстрактный метод getUsersDao(), который должен быть реализован в подклассе. Этот метод возвращает объект UsersDao, который используется для выполнения операций с таблицей пользователей.
//
//        Статический метод getInstance(Context context):
//        Создает и возвращает экземпляр AppDatabase с помощью Room.databaseBuilder(). Этот метод принимает три параметра: контекст приложения (context), класс базы данных (AppDatabase.class) и имя базы данных ("database_example.db").
//        .fallbackToDestructiveMigration(): указывает, что при изменении схемы базы данных следует использовать механизм "разрушительной миграции". Это означает, что старая база данных будет удалена, а затем создана новая схема базы данных. Все данные из предыдущей версии базы данных будут потеряны.
//        .allowMainThreadQueries(): разрешает выполнение запросов к базе данных на основном потоке. Это не рекомендуется для использования в производств
//        .build() - это метод, который завершает процесс создания экземпляра базы данных и возвращает готовый объект базы данных.
//        После вызова build(), все параметры, такие как имя базы данных, версия, настройки миграции и другие, будут применены к создаваемой базе данных и будет возвращен экземпляр AppDatabase, готовый к использованию.
//        Таким образом, .build() является заключительным шагом в создании базы данных с использованием библиотеки Room. Возвращаемый объект AppDatabase можно затем использовать для получения объекта UsersDao и выполнения операций с базой данных.