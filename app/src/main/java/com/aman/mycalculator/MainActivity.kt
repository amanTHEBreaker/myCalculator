package com.aman.mycalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var digit_on_screen = StringBuilder()
    private var operation: Char = ' '
    private var leftHandSide: Double = 0.0
    private var rightHandSide: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result_ids.text = "0"

        initializeButtons()
    }

    private fun initializeButtons() {
        functionalButtons()
        operationalButtons()
        numericalButtons()
    }

    //  initlializing the all the numericals buttons
    private fun numericalButtons() {

        one_btn.setOnClickListener {
            appendToDigitOnScreen("1")
        }

        two_btn.setOnClickListener {
            appendToDigitOnScreen("2")
        }

        three_btn.setOnClickListener {
            appendToDigitOnScreen("3")
        }

        four_btn.setOnClickListener {
            appendToDigitOnScreen("4")
        }

        five_btn.setOnClickListener {
            appendToDigitOnScreen("5")
        }

        six_btn.setOnClickListener {
            appendToDigitOnScreen("6")
        }

        seven_btn.setOnClickListener {
            appendToDigitOnScreen("7")
        }

        eight_btn.setOnClickListener {
            appendToDigitOnScreen("8")
        }

        nine_btn.setOnClickListener {
            appendToDigitOnScreen("9")
        }

        zero_btn.setOnClickListener {
            appendToDigitOnScreen("0")
        }

        dot_btn.setOnClickListener {
            appendToDigitOnScreen(".")
        }
    }

    private fun appendToDigitOnScreen(digits: String) {
        // appending all the strings to builder
        digit_on_screen.append(digits)

        // displaying the string builder on screen
        result_ids.text = digit_on_screen.toString()

    }

    // initlizing the operation keys in our calculator like
    // addition key, substraction key and the likes
    private fun operationalButtons() {
        addition_btn.setOnClickListener {
            selectOperation('A')
        }

        subtract_btn.setOnClickListener {
            selectOperation('B')
        }

        divide_btn.setOnClickListener {
            selectOperation('D')
        }

        multipy_btn.setOnClickListener {
            selectOperation('M')
        }

        percent_btn.setOnClickListener{
            selectOperation('P')
        }
        square_btn.setOnClickListener {
            selectOperation('S')
        }
    }

    // function to assign operational sign to our math calculations
    private fun selectOperation(c: Char) {
        operation = c
        // checks if there's any operan
        val lengthOfStrBuilder = digit_on_screen.length
        if(lengthOfStrBuilder != 0) {
            leftHandSide = digit_on_screen.toString().toDouble()
            digit_on_screen.clear()
            result_ids.text = "0"
        }

    }

    // handles functional operations like
    // clear button, backspace button and the clear button

    private fun functionalButtons() {


        clear_btn.setOnClickListener{
            completeClear()
        }

        backspace_btn.setOnClickListener{
            clearDigit()
        }

        equal_btn.setOnClickListener{
            performMathOperation()
        }

    }

    private fun completeClear() {
        digit_on_screen.clear()
    }

    // performs the mathematical operations which is then showed on
    // on the screen

    private fun performMathOperation() {
        // checks if there's any operand
        val lengthOfStrBuilder = digit_on_screen.length
        if(lengthOfStrBuilder != 0) {
            rightHandSide = digit_on_screen.toString().toDouble()
            digit_on_screen.clear()
        }

        when(operation) {
            'A' -> {

                val sum = OperationsHelper.add(leftHandSide, rightHandSide)
                result_ids.text = sum.toString()
                digit_on_screen.append(sum)
            }

            'B' -> {
                val subtract = OperationsHelper.subtract(leftHandSide, rightHandSide)
                result_ids.text = subtract.toString()
                digit_on_screen.append(subtract)
            }

            'D' -> {
                val divide = OperationsHelper.divide(leftHandSide, rightHandSide)
                result_ids.text = divide.toString()
                digit_on_screen.append(divide)
            }

            'M' -> {
                val multiply = OperationsHelper.multiply(leftHandSide, rightHandSide)
                result_ids.text = multiply.toString()
                digit_on_screen.append(multiply)
            }

            'P' -> {
                var percentage = OperationsHelper.percentage(digit_on_screen.toString().toDouble(),
                    0.0)
                result_ids.text = percentage.toString()
                digit_on_screen.append(percentage)
            }

            'S' -> {
                var square = OperationsHelper.square(digit_on_screen.toString().toDouble())
                result_ids.text = square.toString()
                digit_on_screen.append(square)
            }
        }
    }

    // remove the last digit on the screen
    private fun clearDigit() {
        val length = digit_on_screen.length
        val demo = digit_on_screen.length
        if(demo != 0) {
            digit_on_screen.deleteCharAt(length - 1)
        }
        result_ids.text = digit_on_screen.toString()
    }
}