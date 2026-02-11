package com.prvshkmr.geoquiz

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.prvshkmr.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_amazon, false), // Nile is usually considered longest
        Question(R.string.question_everest, true),
        Question(R.string.question_pacific, true),
        Question(R.string.question_sahara, false), // Antarctica is the largest desert
        Question(R.string.question_japan, true),
        Question(R.string.question_france, true),
        Question(R.string.question_egypt, true),
        Question(R.string.question_canada, true),
        Question(R.string.question_brazil, true),
        Question(R.string.question_russia, true),
        Question(R.string.question_china, false), // Not visible from the moon
        Question(R.string.question_india, true),
        Question(R.string.question_germany, true),
        Question(R.string.question_italy, true),
        Question(R.string.question_africa, false), // Asia is the largest continent
        Question(R.string.question_nile, true),
        Question(R.string.question_mexico, true),
        Question(R.string.question_greenland, true),
        Question(R.string.question_iceland, true),
        Question(R.string.question_spain, true),
        Question(R.string.question_uk, true),
        Question(R.string.question_greece, true),
        Question(R.string.question_turkey, true),
        Question(R.string.question_argentina, true),
        Question(R.string.question_chile, true),
        Question(R.string.question_peru, true),
        Question(R.string.question_thailand, true),
        Question(R.string.question_vietnam, true),
        Question(R.string.question_indonesia, true),
        Question(R.string.question_switzerland, true),
        Question(R.string.question_sweden, true),
        Question(R.string.question_norway, true),
        Question(R.string.question_finland, true),
        Question(R.string.question_denmark, true),
        Question(R.string.question_portugal, true),
        Question(R.string.question_poland, true),
        Question(R.string.question_austria, true),
        Question(R.string.question_belgium, true),
        Question(R.string.question_netherlands, true),
        Question(R.string.question_south_africa, true),
        Question(R.string.question_kenya, true),
        Question(R.string.question_egypt_capital, true),
        Question(R.string.question_morocco, true),
        Question(R.string.question_saudi_arabia, true),
        Question(R.string.question_iran, true),
        Question(R.string.question_iraq, true),
        Question(R.string.question_israel, true),
        Question(R.string.question_new_zealand, true),
        Question(R.string.question_fiji, true)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the binding object
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Now you can use binding.trueButton, etc.
        binding.trueButton.setOnClickListener { view: View ->
            checkAnswer(true)
        }

        binding.falseButton.setOnClickListener { view: View ->
            checkAnswer(false)
        }

        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }

        binding.previousButton.setOnClickListener {
            currentIndex = (currentIndex - 1 + questionBank.size) % questionBank.size
            updateQuestion()
        }
    }
    //checker

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        binding.questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean){
        val correctAnswer = questionBank[currentIndex].answer
        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show()
        currentIndex = (currentIndex + 1) % questionBank.size
        updateQuestion()
    }
}
