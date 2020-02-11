package com.example.deprerisk

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.deprerisk.persistence.room.entity.BeckInventoryEntity
import com.example.deprerisk.persistence.room.entity.QuestionnaireAnswersEntity
import com.example.deprerisk.viewmodel.DepressionRiskViewModel
import kotlinx.android.synthetic.main.activity_main.*


class DepressionRiskActivity : AppCompatActivity() {
    private lateinit var viewModel: DepressionRiskViewModel

    private lateinit var questions: List<BeckInventoryEntity>

    private var index = 0

    private var answer = ""

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        viewModel = ViewModelProvider(this).get(DepressionRiskViewModel::class.java)

        viewModel.allQuestions.observe(this, Observer<List<BeckInventoryEntity>> { list ->
            questions = list
            if (questions.isNotEmpty()) {
                nextQuestion(questions.first())
                index++
            }
        })

        activateButton(false)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            checkRadioButtons(checkedId)
        }

        //Next Button
        next_button.setOnClickListener {
            if (index < 21) {
                viewModel.saveAnswer(index, answer)
                clearFields()
                nextQuestion(questions[index])
                answer = ""
                index++
            } else {
                showDialog()
                viewModel.finishQuestionnaire()
                    .observe(this, Observer<List<QuestionnaireAnswersEntity>> { answer ->
                        viewModel.sendMessage(answer)
                        index = 0
                        clearFields()
                        nextQuestion(questions[index])
                    })
                answer = ""
            }

        }
    }

    private fun showDialog() {
        AlertDialog.Builder(this)
            .setTitle("Cuetionario Finalizado")
            .setMessage("Sus respuestas estan siendo valoradas")
            .setPositiveButton(android.R.string.yes) { dialog, which ->
                viewModel.deleteAnswers()

            }
            .setNegativeButton(android.R.string.no, null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

    private fun nextQuestion(question: BeckInventoryEntity) {
        tx_questions.text = question.question
        radioButton1.text = question.answerOne
        radioButton2.text = question.answerTwo
        radioButton3.text = question.answerThree
        radioButton4.text = question.answerFour

        if (question.answerFive.isNotEmpty()) {
            radioButton5.visibility = View.VISIBLE
            radioButton5.text = question.answerFive
        } else {
            radioButton5.visibility = View.GONE
            radioButton5.text = ""
        }

        if (question.answerSix.isNotEmpty()) {
            radioButton6.visibility = View.VISIBLE
            radioButton6.text = question.answerSix
        } else {
            radioButton6.visibility = View.GONE
            radioButton6.text = ""
        }
        if (question.answerSeven.isNotEmpty()) {
            radioButton7.visibility = View.GONE
            radioButton7.text = ""
        } else {
            radioButton7.visibility = View.GONE
            radioButton7.text = ""
        }
    }

    private fun checkRadioButtons(checkId: Int) {
        answer = when (checkId) {
            R.id.radioButton1 -> radioButton1.text.toString()
            R.id.radioButton2 -> radioButton2.text.toString()
            R.id.radioButton3 -> radioButton3.text.toString()
            R.id.radioButton4 -> radioButton4.text.toString()
            R.id.radioButton5 -> radioButton5.text.toString()
            R.id.radioButton6 -> radioButton6.text.toString()
            R.id.radioButton7 -> radioButton7.text.toString()
            else -> ""
        }
        activateButton(answer.isNotEmpty())
    }

    private fun clearFields() {
        radioGroup.clearCheck()
        activateButton(false)
    }

    private fun activateButton(active: Boolean) {
        next_button.isClickable = active
        next_button.alpha = if (active) {
            1f
        } else {
            0.5f
        }
    }

}




