package com.example.astar_dz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class User extends MainActivity {
    private AppDatabaseUser database;
    private String name;
    private String age;
    private TextView textViewUserName;
    private TextView textViewUserAge;
    private TextView textViewNewUsersGenerate;
    private ImageButton imageButtonGenerate;
    private final String[] names = {"Эмили, Шарлотта, София, Руби, Патрисия, Маргарет, Линда, Камилла, Ив, Диана, Джессика, Грейс, Белла, Анжелина,Чарльз, Ричард, Патрик, Оскар, Оливер, Лукас, Джордж, Вильям, Артур, Александр"};

    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        textViewUserName = findViewById(R.id.textViewUserName);
        textViewUserAge = findViewById(R.id.textViewUserAge);
        Intent intent = getIntent();
        String userName = String.format(getString(R.string.user_name), name);
        textViewUserName.setText(userName);
        String userAge = String.format(getString(R.string.user_age), age);
        textViewUserAge.setText(userAge);
        /////////////
        textViewNewUsersGenerate = findViewById(R.id.textViewNewUsersGenerate);
        imageButtonGenerate = findViewById(R.id.imageButtonGenerate);
        imageButtonGenerate.setOnClickListener(v -> {
            createNewUsers();
        });
        database = AppDatabaseUser.getInstance(this);
        //Строка database = AppDatabaseUser.getInstance(this); используется для получения экземпляра базы данных в приложении.
        // Это делается с помощью вызова статического метода getInstance() из класса AppDatabaseUser.
        // Затем полученный экземпляр базы данных может быть использован для выполнения операций чтения и записи данных в базу данных
        showAllUsers();//метод, который отображает всех пользователей.
        // Скорее всего, он извлекает информацию о пользователях из базы данных и отображает ее на экране или выполняет другую операцию, связанную с отображением информации о пользователях
    }

    ///////////
    private void createNewUsers() {
        Random random = new Random();
        int nameIndex = random.nextInt(names.length);
        String nameUsers = names[nameIndex];
        int ageUsers = random.nextInt(177);
        Users users = new Users(nameUsers, ageUsers);
        database.getUsersDao().addUser(users);
        showAllUsers();
    }
    /////////////

    private void showAllUsers() {
        List<User> users = database.getUsersDao().getUsers();

        String buffer = "";
        for (User user : users) {
            buffer += "Name: " + user.name + "\n" +
                    "Age:  " + user.age + "\n";
        }
        textViewNewUsersGenerate.setText(buffer);
    }
///////// не нужно переходить в другую активность
//    public void imageButtonGenerate(View view) {
//        Intent intent = new Intent(this, UserNewNameAndAge.class);
//        startActivity(intent);
//    }
}
//
//@SuppressLint({"MissingInflatedId", "ResourceType"})
//объявлены две переменные textViewYourName и textViewYourAge для отображения имени и возраста пользователя.
//
//        Далее, в методе onCreate(), вызывается родительский метод super.onCreate(savedInstanceState) и устанавливается контент для активности с помощью метода setContentView(R.layout.activity_user). Здесь используется макет activity_user, который содержит в себе элементы пользовательского интерфейса.
//
//        Затем, в коде, который вы предоставили, закомментирована строка, которая должна инициализировать textViewYourName. Возможно, это было сделано по ошибке, поскольку textViewYourName объявлен, но не инициализирован. Если вам нужно использовать textViewYourName, раскомментируйте эту строку и укажите правильный идентификатор для textViewUserName.
//
//        Далее, инициализируется textViewYourAge с помощью метода findViewById(R.id.textViewUserAge). Этот метод находит элемент с указанным идентификатором из макета activity_user и присваивает его textViewYourAge.
//
//        После этого, с помощью метода getIntent() получаем объект Intent, который был использован для запуска этой активности.
//
//        Затем, с помощью метода String.format(), форматируется строка, используя ресурс строки R.string.user_name и значение переменной name. Результат форматирования сохраняется в переменную userName.
//
//        Наконец, с помощью метода setText() устанавливается текст для textViewYourName и textViewYourAge с помощью переменных userName и age соответственно.
///////////
//        Код createUserButton.setOnClickListener(v -> {createNewUser();}); выполняет следующее:
//        Когда кнопка createUserButton нажимается, это устанавливает слушатель событий на эту кнопку.
//        Когда слушатель активируется, вызывается метод createNewUser(). То есть, каждый раз, когда пользователь нажимает на кнопку "Создать пользователя", будет создаваться новый пользователь.
//        Это очень полезный код для добавления функциональности создания нового пользователя в вашем приложении.
//////////
//    Вот расшифровка кода метода createNewUser():
//    Создается экземпляр класса Random. Он используется для генерации случайных чисел в дальнейшем.
//    Генерируется случайное число nameIndex с использованием метода nextInt(). names.length используется в качестве верхней границы диапазона случайных чисел, чтобы получить случайный индекс из массива names.
//    Случайный индекс nameIndex используется для получения случайного имени из массива names.
//    Генерируется случайное число age с использованием метода nextInt(). Здесь 30 используется в качестве верхней границы диапазона случайных чисел, чтобы получить случайный возраст для пользователя.
//    Создается новый объект User с использованием полученного случайного имени и возраста.
//    Вызывается метод addUser() в объекте UsersDao, который добавляет нового пользователя в базу данных.
//    Затем вызывается метод showAllUsers(), который, вероятно, отображает список всех пользователей на экране или выполняет какую-то другую операцию.
//    Таким образом, код метода createNewUser() генерирует случайное имя и возраст для нового пользователя, добавляет его в базу данных и затем, вероятно, отображает список всех пользователей.
/////////
//    В методе showAllUsers() сначала из базы данных получается список пользователей с помощью метода getUsers() из объекта usersDao.
//    Затем происходит итерация по списку пользователей и формируется строка buffer, содержащая информацию о каждом пользователе (ID, имя и возраст).
//    В конце строки добавляется разделитель -=-=-=-=-=-=-=-=-=-= для наглядности.
//    После этого, полученная строка buffer устанавливается в textView, предположительно текстовый виджет на экране, чтобы пользователь мог видеть информацию о всех пользователях.
//    Это код, который отображает информацию о всех пользователях в удобном формате на экране.
//////////////
//Строка textViewNewUsersGenerate.setText(buffer); используется для установки текстового значения в определенном TextView компоненте пользовательского интерфейса.
//
//        Предположим, у вас есть переменная textViewNewUsersGenerate, которая является объектом класса TextView (например, это может быть текстовое поле в вашем макете пользовательского интерфейса). Вы хотите установить определенный текст в этом TextView.
//
//        Используя метод setText(), вы передаете значение buffer в качестве аргумента. Значение buffer будет отображаться в TextView, заменяя предыдущий текст (если таковой имелся).
//
//        Таким образом, строка textViewNewUsersGenerate.setText(buffer); просто устанавливает текст в TextView, чтобы отобразить содержимое переменной buffer.
///////////////
//Чтобы импортировать класс User, вы должны указать полное имя пакета и имени класса в вашем коде.
//
//        Предположим, класс User находится в пакете com.example.models, тогда вам нужно добавить следующую строку в начало вашего кода:
//
//        import com.example.models.User;
//        Это позволит вашему коду использовать класс User без необходимости указывать полное имя класса каждый раз.
//
//        Если класс User находится в другом пакете, убедитесь, что вы правильно указываете путь к файлу класса в операторе импорта.
//
//        Например, если класс User находится в пакете com.example.models.users, то импорт будет выглядеть так:
//
//        import com.example.models.users.User;
//        Не забудьте также убедиться, что вы правильно настроили зависимости и пути к вашему проекту, чтобы класс User был доступен в вашем коде.



