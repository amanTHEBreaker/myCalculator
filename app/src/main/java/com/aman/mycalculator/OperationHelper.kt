package com.aman.mycalculator;

class OperationsHelper {
    companion object {


        // addition function
        fun add(left_hand_side: Double, right_hand_side: Double) :Double {
            val s = left_hand_side + right_hand_side
            return s
        }
        // subtraction function
        fun subtract(left_hand_side: Double, right_hand_side: Double) :Double {
            val data = left_hand_side - right_hand_side
            return data
        }
        // divide function
        fun divide(left_hand_side: Double, right_hand_side: Double) :Double {
            val di = left_hand_side / right_hand_side
            return di
        }
        // multiplication function
        fun multiply(left_hand_side: Double, right_hand_side: Double) :Double {
            val mul = left_hand_side * right_hand_side
            return mul
        }
        // percentage function
        fun percentage(left_hand_side: Double, right_hand_side: Double) :Double {
            val per = left_hand_side / 100
            return per
        }
        // square function
        fun square(left_hand_side: Double) :Double {
            val per = left_hand_side * left_hand_side
            return per
        }
    }
}
