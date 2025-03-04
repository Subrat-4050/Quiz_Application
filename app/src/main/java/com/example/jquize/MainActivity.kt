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

        val listQuestionModel = mutableListOf<QuestionModel>()
        listQuestionModel.add(QuestionModel("What is Android ?", mutableListOf("Mobile Application", "Hardware", "Operating System", "Programming Language"), "Operating System" ))
        listQuestionModel.add(QuestionModel("Which language is primarily used for Android development?", mutableListOf("Java", "Python", "Kotlin", "C++"), "Kotlin"))
        listQuestionModel.add(QuestionModel("What is an APK file?", mutableListOf("Android Package Kit", "Application Programming Key", "Advanced Programming Kernel", "Android Process Kit"), "Android Package Kit"))
        listQuestionModel.add(QuestionModel("What is the role of the Android SDK?", mutableListOf("System Design Kernel", "Security Data Key", "Service Deployment Kit", "Software Development Kit"), "Software Development Kit"))
        listQuestionModel.add(QuestionModel("What is an Activity in Android?", mutableListOf("A background service", "A single screen in an app", "A database table", "A network connection"), "A single screen in an app"))
        listQuestionModel.add(QuestionModel("What is a Fragment in Android?", mutableListOf("A complete app", "A type of database", "A network protocol", "A portion of an Activity's UI"), "A portion of an Activity's UI"))
        listQuestionModel.add(QuestionModel("What is the purpose of the Android Manifest file?", mutableListOf("Describes the app's structure and components", "Stores user data", "Handles network requests", "Manages app updates"), "Describes the app's structure and components"))
        listQuestionModel.add(QuestionModel("What is a Layout in Android?", mutableListOf("Manages background tasks", "Defines the UI structure", "Stores app data", "Handles user authentication"), "Defines the UI structure"))
        listQuestionModel.add(QuestionModel("What is the role of Gradle in Android development?", mutableListOf("UI design tool", "Database management system", "Build automation system", "Network monitoring tool"), "Build automation system"))
        listQuestionModel.add(QuestionModel("What is an Intent in Android?", mutableListOf("A messaging object to request an action", "A data storage unit", "A UI element", "A security protocol"), "A messaging object to request an action"))

//        quizeModelList.add(QuizModel("1", "Java", "10 Java Questions", "10"))
//        quizeModelList.add(QuizModel("2", "Python", "10 Python Questions", "10"))
//        quizeModelList.add(QuizModel("3", "Database", "10 Database Questions", "12"))
        quizeModelList.add(QuizModel("4", "Android", "10 Android Questions", "15", listQuestionModel))

        setupRecyclerView()
    }
}