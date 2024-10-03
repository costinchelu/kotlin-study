package ch14.StartingANewThread

import kotlin.concurrent.thread

fun main() {

    println("M. I'm on ${Thread.currentThread().name}")

    thread {
        println("0. And I'm on ${Thread.currentThread().name}")

        thread {
            println("1. And I'm on ${Thread.currentThread().name}")
        }
    }

    thread {
        println("2. And I'm on ${Thread.currentThread().name}")
    }
}


/*
M. I'm on main
0. And I'm on Thread-0
2. And I'm on Thread-1
1. And I'm on Thread-2
 */