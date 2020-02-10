package com.example.deprerisk

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RadioButton
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
        radio_group.setOnCheckedChangeListener { group, checkedId ->
            val radioButton = group.findViewById(checkedId) as RadioButton
            checkRadioButtons(radioButton)
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

    private fun checkRadioButtons(radioButton: RadioButton) {
        when {
            radioButton1 == radioButton -> {
                answer = radioButton1.text.toString()
                radioButton1.setBackgroundResource(R.drawable.option_button_selected)
                radioButton1.isChecked = true
                radioButton2.setBackgroundResource(R.drawable.action_button)
                radioButton2.isChecked = false
                radioButton3.setBackgroundResource(R.drawable.action_button)
                radioButton3.isChecked = false
                radioButton4.setBackgroundResource(R.drawable.action_button)
                radioButton4.isChecked = false
                radioButton5.setBackgroundResource(R.drawable.action_button)
                radioButton5.isChecked = false
                radioButton6.setBackgroundResource(R.drawable.action_button)
                radioButton6.isChecked = false
                radioButton7.setBackgroundResource(R.drawable.action_button)
                radioButton7.isChecked = false
            }
            radioButton2 == radioButton -> {
                answer = radioButton2.text.toString()
                radioButton2.setBackgroundResource(R.drawable.option_button_selected)
                radioButton2.isChecked = true
                radioButton1.setBackgroundResource(R.drawable.action_button)
                radioButton1.isChecked = false
                radioButton3.setBackgroundResource(R.drawable.action_button)
                radioButton3.isChecked = false
                radioButton4.setBackgroundResource(R.drawable.action_button)
                radioButton4.isChecked = false
                radioButton5.setBackgroundResource(R.drawable.action_button)
                radioButton5.isChecked = false
                radioButton6.setBackgroundResource(R.drawable.action_button)
                radioButton6.isChecked = false
                radioButton7.setBackgroundResource(R.drawable.action_button)
                radioButton7.isChecked = false
            }
            radioButton3 == radioButton -> {
                answer = radioButton3.text.toString()
                radioButton3.setBackgroundResource(R.drawable.option_button_selected)
                radioButton3.isChecked = true
                radioButton1.setBackgroundResource(R.drawable.action_button)
                radioButton1.isChecked = false
                radioButton2.setBackgroundResource(R.drawable.action_button)
                radioButton2.isChecked = false
                radioButton4.setBackgroundResource(R.drawable.action_button)
                radioButton4.isChecked = false
                radioButton5.setBackgroundResource(R.drawable.action_button)
                radioButton5.isChecked = false
                radioButton6.setBackgroundResource(R.drawable.action_button)
                radioButton6.isChecked = false
                radioButton7.setBackgroundResource(R.drawable.action_button)
                radioButton7.isChecked = false
            }
            radioButton4 == radioButton -> {
                answer = radioButton4.text.toString()
                radioButton4.setBackgroundResource(R.drawable.option_button_selected)
                radioButton4.isChecked = true
                radioButton1.setBackgroundResource(R.drawable.action_button)
                radioButton1.isChecked = false
                radioButton2.setBackgroundResource(R.drawable.action_button)
                radioButton2.isChecked = false
                radioButton3.setBackgroundResource(R.drawable.action_button)
                radioButton3.isChecked = false
                radioButton5.setBackgroundResource(R.drawable.action_button)
                radioButton5.isChecked = false
                radioButton6.setBackgroundResource(R.drawable.action_button)
                radioButton6.isChecked = false
                radioButton7.setBackgroundResource(R.drawable.action_button)
                radioButton7.isChecked = false
            }
            radioButton5 == radioButton -> {
                answer = radioButton5.text.toString()
                radioButton5.setBackgroundResource(R.drawable.option_button_selected)
                radioButton5.isChecked = true
                radioButton1.setBackgroundResource(R.drawable.action_button)
                radioButton1.isChecked = false
                radioButton2.setBackgroundResource(R.drawable.action_button)
                radioButton2.isChecked = false
                radioButton3.setBackgroundResource(R.drawable.action_button)
                radioButton3.isChecked = false
                radioButton4.setBackgroundResource(R.drawable.action_button)
                radioButton4.isChecked = false
                radioButton6.setBackgroundResource(R.drawable.action_button)
                radioButton6.isChecked = false
                radioButton7.setBackgroundResource(R.drawable.action_button)
                radioButton7.isChecked = false
            }
            radioButton6 == radioButton -> {
                answer = radioButton6.text.toString()
                radioButton6.setBackgroundResource(R.drawable.option_button_selected)
                radioButton6.isChecked = true
                radioButton1.setBackgroundResource(R.drawable.action_button)
                radioButton1.isChecked = false
                radioButton2.setBackgroundResource(R.drawable.action_button)
                radioButton2.isChecked = false
                radioButton3.setBackgroundResource(R.drawable.action_button)
                radioButton3.isChecked = false
                radioButton4.setBackgroundResource(R.drawable.action_button)
                radioButton4.isChecked = false
                radioButton5.setBackgroundResource(R.drawable.action_button)
                radioButton5.isChecked = false
                radioButton7.setBackgroundResource(R.drawable.action_button)
                radioButton7.isChecked = false
            }
            radioButton7 == radioButton -> {
                answer = radioButton7.text.toString()
                radioButton7.setBackgroundResource(R.drawable.option_button_selected)
                radioButton7.isChecked = true
                radioButton1.setBackgroundResource(R.drawable.action_button)
                radioButton1.isChecked = false
                radioButton2.setBackgroundResource(R.drawable.action_button)
                radioButton2.isChecked = false
                radioButton3.setBackgroundResource(R.drawable.action_button)
                radioButton3.isChecked = false
                radioButton4.setBackgroundResource(R.drawable.action_button)
                radioButton4.isChecked = false
                radioButton5.setBackgroundResource(R.drawable.action_button)
                radioButton5.isChecked = false
                radioButton6.setBackgroundResource(R.drawable.action_button)
                radioButton6.isChecked = false
            }
        }
    }

    private fun clearFields() {
        radioButton1.setBackgroundResource(R.drawable.action_button)
        radioButton2.setBackgroundResource(R.drawable.action_button)
        radioButton3.setBackgroundResource(R.drawable.action_button)
        radioButton4.setBackgroundResource(R.drawable.action_button)
        radioButton5.setBackgroundResource(R.drawable.action_button)
        radioButton6.setBackgroundResource(R.drawable.action_button)
        radioButton7.setBackgroundResource(R.drawable.action_button)
        radioButton1.isChecked = false
        radioButton2.isChecked = false
        radioButton3.isChecked = false
        radioButton4.isChecked = false
        radioButton5.isChecked = false
        radioButton6.isChecked = false
        radioButton7.isChecked = false
    }

}




