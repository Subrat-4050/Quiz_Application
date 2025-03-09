package com.example.jquize
 
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jquize.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quizeModelList: MutableList<QuizModel>
    lateinit var adapter: QuizListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quizeModelList = mutableListOf()
        getDataFromFirebase()
    }

    private fun setupRecyclerView() {
        adapter = QuizListAdapter(quizeModelList)
        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
    }

    private fun getDataFromFirebase() {
        // dummy data

        val listQuestionModelJava = mutableListOf<QuestionModel>()
        listQuestionModelJava.add(QuestionModel("What is Java?", mutableListOf("Programming Language", "Operating System", "Database", "Web Browser"), "Programming Language"))
        listQuestionModelJava.add(QuestionModel("Which keyword is used to define a class in Java?", mutableListOf("class", "struct", "define", "function"), "class"))
        listQuestionModelJava.add(QuestionModel("Which of the following is not a Java primitive data type?", mutableListOf("int", "float", "boolean", "string"), "string"))
        listQuestionModelJava.add(QuestionModel("What is the default value of an int variable in Java?", mutableListOf("0", "1", "null", "undefined"), "0"))
        listQuestionModelJava.add(QuestionModel("Which method is used to start a Java program?", mutableListOf("init()", "main()", "start()", "run()"), "main()"))
        listQuestionModelJava.add(QuestionModel("Which keyword is used to inherit a class in Java?", mutableListOf("extend", "implements", "inherits", "super"), "extends"))
        listQuestionModelJava.add(QuestionModel("Which access modifier makes a variable/method visible only within the same class?", mutableListOf("private", "public", "protected", "default"), "private"))
        listQuestionModelJava.add(QuestionModel("Which of these is not a Java loop?", mutableListOf("for", "while", "do-while", "repeat"), "repeat"))
        listQuestionModelJava.add(QuestionModel("What is the purpose of the 'super' keyword in Java?", mutableListOf("Call parent class methods", "Define a subclass", "Create an object", "Override a method"), "Call parent class methods"))
        listQuestionModelJava.add(QuestionModel("Which Java collection allows storing key-value pairs?", mutableListOf("List", "Set", "Map", "Queue"), "Map"))

        val listQuestionModelPython = mutableListOf<QuestionModel>()
        listQuestionModelPython.add(QuestionModel("What is Python?", mutableListOf("Programming Language", "Operating System", "Database", "Web Server"), "Programming Language"))
        listQuestionModelPython.add(QuestionModel("Which keyword is used to define a function in Python?", mutableListOf("def", "function", "define", "func"), "def"))
        listQuestionModelPython.add(QuestionModel("Which data type is mutable in Python?", mutableListOf("Tuple", "List", "String", "Integer"), "List"))
        listQuestionModelPython.add(QuestionModel("How do you declare a variable in Python?", mutableListOf("int x = 5;", "x = 5;", "declare x = 5;", "var x = 5;"), "x = 5;"))
        listQuestionModelPython.add(QuestionModel("Which of the following is used to read input from the user in Python?", mutableListOf("scanf()", "cin", "input()", "readline()"), "input()"))
        listQuestionModelPython.add(QuestionModel("What will be the output of `print(3 * 'Hello')`?", mutableListOf("'HelloHelloHello'", "'Hello * 3'", "Error", "'3Hello'"), "'HelloHelloHello'"))
        listQuestionModelPython.add(QuestionModel("Which symbol is used for single-line comments in Python?", mutableListOf("//", "#", "/* */", "--"), "#"))
        listQuestionModelPython.add(QuestionModel("Which module in Python is used for regular expressions?", mutableListOf("regex", "re", "regexp", "pyregex"), "re"))
        listQuestionModelPython.add(QuestionModel("How do you start a loop in Python?", mutableListOf("for", "foreach", "loop", "iterate"), "for"))
        listQuestionModelPython.add(QuestionModel("Which function is used to open a file in Python?", mutableListOf("open()", "read()", "file()", "openfile()"), "open()"))

        val listQuestionModelDatabase = mutableListOf<QuestionModel>()
        listQuestionModelDatabase.add(QuestionModel("What is a database?", mutableListOf("A collection of data", "A type of software", "A programming language", "A file system"), "A collection of data"))
        listQuestionModelDatabase.add(QuestionModel("Which language is used to interact with databases?", mutableListOf("HTML", "SQL", "Python", "Java"), "SQL"))
        listQuestionModelDatabase.add(QuestionModel("Which of the following is NOT a type of database?", mutableListOf("Relational", "NoSQL", "Hierarchical", "Variable"), "Variable"))
        listQuestionModelDatabase.add(QuestionModel("Which SQL command is used to retrieve data?", mutableListOf("SELECT", "FETCH", "GET", "RETRIEVE"), "SELECT"))
        listQuestionModelDatabase.add(QuestionModel("What is a primary key in a database?", mutableListOf("A unique identifier for records", "A foreign key", "A type of query", "A table name"), "A unique identifier for records"))
        listQuestionModelDatabase.add(QuestionModel("Which SQL clause is used to filter results?", mutableListOf("ORDER BY", "WHERE", "GROUP BY", "JOIN"), "WHERE"))
        listQuestionModelDatabase.add(QuestionModel("Which type of database stores data in tables?", mutableListOf("NoSQL", "Relational", "Hierarchical", "Graph"), "Relational"))
        listQuestionModelDatabase.add(QuestionModel("What does ACID stand for in databases?", mutableListOf("Atomicity, Consistency, Isolation, Durability", "Addition, Computation, Integration, Data", "Automated, Centralized, Indexed, Distributed", "Access, Control, Integrity, Dependency"), "Atomicity, Consistency, Isolation, Durability"))
        listQuestionModelDatabase.add(QuestionModel("What is the function of the JOIN clause in SQL?", mutableListOf("Combining rows from two or more tables", "Filtering results", "Sorting data", "Creating a new table"), "Combining rows from two or more tables"))
        listQuestionModelDatabase.add(QuestionModel("Which database is an example of NoSQL?", mutableListOf("MySQL", "MongoDB", "PostgreSQL", "SQLite"), "MongoDB"))


        val listQuestionModelAndroid = mutableListOf<QuestionModel>()
        listQuestionModelAndroid.add(QuestionModel("What is Android ?", mutableListOf("Mobile Application", "Hardware", "Operating System", "Programming Language"), "Operating System" ))
        listQuestionModelAndroid.add(QuestionModel("Which language is primarily used for Android development?", mutableListOf("Java", "Python", "Kotlin", "C++"), "Kotlin"))
        listQuestionModelAndroid.add(QuestionModel("What is an APK file?", mutableListOf("Android Package Kit", "Application Programming Key", "Advanced Programming Kernel", "Android Process Kit"), "Android Package Kit"))
        listQuestionModelAndroid.add(QuestionModel("What is the role of the Android SDK?", mutableListOf("System Design Kernel", "Security Data Key", "Service Deployment Kit", "Software Development Kit"), "Software Development Kit"))
        listQuestionModelAndroid.add(QuestionModel("What is an Activity in Android?", mutableListOf("A background service", "A single screen in an app", "A database table", "A network connection"), "A single screen in an app"))
        listQuestionModelAndroid.add(QuestionModel("What is a Fragment in Android?", mutableListOf("A complete app", "A type of database", "A network protocol", "A portion of an Activity's UI"), "A portion of an Activity's UI"))
        listQuestionModelAndroid.add(QuestionModel("What is the purpose of the Android Manifest file?", mutableListOf("Describes the app's structure and components", "Stores user data", "Handles network requests", "Manages app updates"), "Describes the app's structure and components"))
        listQuestionModelAndroid.add(QuestionModel("What is a Layout in Android?", mutableListOf("Manages background tasks", "Defines the UI structure", "Stores app data", "Handles user authentication"), "Defines the UI structure"))
        listQuestionModelAndroid.add(QuestionModel("What is the role of Gradle in Android development?", mutableListOf("UI design tool", "Database management system", "Build automation system", "Network monitoring tool"), "Build automation system"))
        listQuestionModelAndroid.add(QuestionModel("What is an Intent in Android?", mutableListOf("A messaging object to request an action", "A data storage unit", "A UI element", "A security protocol"), "A messaging object to request an action"))

        quizeModelList.add(QuizModel("1", "Java", "10 Java Questions", "10", listQuestionModelJava))
        quizeModelList.add(QuizModel("2", "Python", "10 Python Questions", "10", listQuestionModelPython))
        quizeModelList.add(QuizModel("3", "Database", "10 Database Questions", "12", listQuestionModelDatabase))
        quizeModelList.add(QuizModel("4", "Android", "10 Android Questions", "15", listQuestionModelAndroid))

        setupRecyclerView()
    }
}