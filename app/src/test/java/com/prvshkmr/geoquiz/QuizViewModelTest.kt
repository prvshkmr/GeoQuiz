package com.prvshkmr.geoquiz

import org.junit.Assert.assertEquals
import org.junit.Test
import androidx.lifecycle.SavedStateHandle
import com.prvshkmr.geoquiz.R

class QuizViewModelTest {

    @Test
    fun provideExpectedQuestionText() {
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)

        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }

    @Test
    fun wrapsAroundQuestionBank() {
        val savedStateHandle = SavedStateHandle(mapOf("CURRENT_INDEX_KEY" to 49))
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(com.prvshkmr.geoquiz.R.string.question_fiji, quizViewModel.currentQuestionText)
        quizViewModel.moveToNext()
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }
}