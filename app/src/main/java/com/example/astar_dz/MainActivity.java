package com.example.astar_dz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextAge;
    private ImageButton imageButton;
    private String name;
    private String age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        imageButton = findViewById(R.id.imageButton);

    }


    public void OnClickButton(View view) {
        String name = editTextName.getText().toString().trim();
        String age = editTextAge.getText().toString().trim();
        if (!name.isEmpty() && !age.isEmpty()) {
            Intent intent = new Intent(this, User.class);
            intent.putExtra("name", name);
            intent.putExtra("age", age);
            startActivity(intent);
        }
    }
}
//    Давайте разберем этот код поэтапно:
//
//public class MainActivity extends AppCompatActivity
//это объявление класса MainActivity, который является активити (Activity) в Android приложении. Он наследуется от класса AppCompatActivity, который предоставляет базовую функциональность для работы с пользовательским интерфейсом.
//
//private EditText editTextName;, private EditText editTextAge;, private ImageButton imageButton;, private String name;, private String age;
//        это объявления приватных переменных класса MainActivity, которые представляют элементы пользовательского интерфейса (поля ввода и кнопку) и строки для хранения имени и возраста.
//
//@Override protected void onCreate(Bundle savedInstanceState)
//        это аннотация, указывающая на переопределение метода onCreate() из класса AppCompatActivity. Метод onCreate() вызывается при создании активити.
//
//        super.onCreate(savedInstanceState);
//        это вызов метода onCreate() суперкласса AppCompatActivity, чтобы выполнить базовую инициализацию активити.
//
//        setContentView(R.layout.activity_main);
//        это метод, который устанавливает содержимое активити из макета, указанного в файле activity_main.xml.
//
//        editTextName = findViewById(R.id.editTextName);, editTextAge = findViewById(R.id.editTextAge);, imageButton = findViewById(R.id.imageButton);
//        это методы, которые находят и присваивают переменным ссылки на элементы пользовательского интерфейса (поля ввода и кнопку) с помощью их идентификаторов, указанных в файле макета.

//    public void OnClickButton(View view)
//    Этот код является обработчиком нажатия на кнопку. Давай я расскажу поэтапно, что здесь происходит:
//
//        В начале объявляются две переменные name и age, в которые будет сохраняться текст, введенный пользователем в соответствующие текстовые поля.
//
//        Затем происходит извлечение текста из текстовых полей с помощью метода getText().toString().trim(). Метод getText() возвращает объект типа CharSequence, поэтому применяется метод toString(), чтобы преобразовать его в строку. Метод trim() удаляет пробелы с начала и конца строки.
//
//        Далее выполняется проверка, что и name, и age не пустые строки, с помощью условного оператора if (!name.isEmpty() && !age.isEmpty()). Оператор ! означает отрицание, то есть проверяется, что переменные name и age не являются пустыми строками с помощью метода isEmpty().
//
//        Если строки не пустые, то создается новый объект Intent с указанием текущего контекста и класса User, в который будет осуществлен переход.
//
//        Затем через метод putExtra() в Intent добавляются значения name и age, которые будут переданы в активность User. Значения передаются в виде ключ-значение, где "name" и "age" - ключи, а name и age
//        значения переменных.
//
//        Наконец, с помощью метода startActivity(intent) происходит запуск активности User с переданными значениями.
