package com.example.jquize

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.jquize.databinding.ActivityQuizBinding
import com.example.jquize.databinding.ScoreDialogBinding
import java.util.Objects

class QuizActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        var questionModelList : List<QuestionModel> = listOf()
        var time : String = ""
    }

    lateinit var binding : ActivityQuizBinding

    var currentQuestionIndex = 0;
    var selectedOption = ""
    var score = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn0.setOnClickListener(this@QuizActivity)
            btn1.setOnClickListener(this@QuizActivity)
            btn2.setOnClickListener(this@QuizActivity)
            btn3.setOnClickListener(this@QuizActivity)
            nextBtn.setOnClickListener(this@QuizActivity)
        }
        loadQuestion()
        startTimer()
    }

    private fun startTimer() {
        val totalTImeInMillis = time.toInt() * 60 * 1000L
        object : CountDownTimer(totalTImeInMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished/1000
                val minutes = seconds/60
                val remainingSeconds = seconds%60
                binding.timerIndicatorTextview.text = String.format("%02d:%02d", minutes, remainingSeconds)
            }

            override fun onFinish() {
                // finish the quiz
            }
        }.start()
    }

    private fun loadQuestion() {
        selectedOption = ""
        if(currentQuestionIndex == questionModelList.size) {
            finishQuiz()
            return
        }

        binding.apply {
            questionIndicatorTextview.text = "Question ${currentQuestionIndex + 1}/${questionModelList.size}"
            questionProgressIndicator.progress =
                (currentQuestionIndex.toFloat() / questionModelList.size.toFloat() * 100).toInt()
            questionTextview.text = questionModelList[currentQuestionIndex].question
            btn0.text = questionModelList[currentQuestionIndex].options[0]
            btn1.text = questionModelList[currentQuestionIndex].options[1]
            btn2.text = questionModelList[currentQuestionIndex].options[2]
            btn3.text = questionModelList[currentQuestionIndex].options[3]

        }
    }

    override fun onClick(view: View?) {

        binding.apply {
            btn0.setBackgroundColor(getColor(R.color.lgreen))
            btn1.setBackgroundColor(getColor(R.color.lgreen))
            btn2.setBackgroundColor(getColor(R.color.lgreen))
            btn3.setBackgroundColor(getColor(R.color.lgreen))
        }

        val clickedBtn = view as Button
        if(clickedBtn.id == R.id.next_btn) {
            if(selectedOption == questionModelList[currentQuestionIndex].correct) {
                score++
                Log.i("Score of quiz",score.toString())
            }
            currentQuestionIndex++
            loadQuestion()
        }
        else {
            selectedOption = clickedBtn.text.toString()
            clickedBtn.setBackgroundColor(getColor(R.color.lgreen2))
        }
    }

    private fun finishQuiz() {
        val totalQuestions = questionModelList.size
        val percentage = ((score.toFloat() / totalQuestions.toFloat()) * 100).toInt()

        val dialogBinding = ScoreDialogBinding.inflate(layoutInflater)
        dialogBinding.apply {
            scoreProgressIndicator.progress = percentage
            scoreProgressText.text = "$percentage%"
            if(percentage <= 40) {
                scoreTitle.text = "Oops! you have failed"
                scoreTitle.setTextColor(Color.RED)
            }
            else if (percentage >= 60) {
                scoreTitle.text = "Congrats! you have passed"
                scoreTitle.setTextColor(Color.GREEN)
            }
            else {
                scoreTitle.text = "Keep improving!"
                scoreTitle.setTextColor(Color.GREEN)
            }
            scoreSubtitle.text = "$score out of $totalQuestions questions are correct"
            finishBtn.setOnClickListener {
                finish()
            }
        }

        AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .show()
    }
}