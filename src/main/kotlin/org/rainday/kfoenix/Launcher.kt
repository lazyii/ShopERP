package org.rainday.kfoenix

import javafx.application.Application
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.input.MouseEvent
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.text.Text
import javafx.stage.Stage
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.actor
import kotlinx.coroutines.javafx.JavaFx


/**
 *
 * @author wyd
 * @time  2021/6/1 9:07 下午
 * @description
 */
class Launcher : Application() {
    override fun start(stage: Stage) {
        val hello = Text("Hello World!").apply {
            fill = Color.valueOf("#C0C0C0")
        }

        val fab = Circle(20.0, Color.valueOf("#FF4081"))

        val root = StackPane().apply {
            children += hello
            children += fab
            StackPane.setAlignment(hello, Pos.CENTER)
            StackPane.setAlignment(fab, Pos.BOTTOM_RIGHT)
            StackPane.setMargin(fab, Insets(15.0))
        }

        val scene = Scene(root, 240.0, 380.0).apply {
            fill = Color.valueOf("#303030")
        }

        stage.title = "Example"
        stage.scene = scene
        stage.show()
        setup(hello, fab)
    }
}

fun Node.onClick(action: suspend (MouseEvent) -> Unit) {
    val eventActor = GlobalScope.actor<MouseEvent>(Dispatchers.Main, capacity = Channel.CONFLATED) {
        for (event in channel) action(event) // pass event to action
    }
    onMouseClicked = EventHandler { event ->
        eventActor.trySend(event)
    }
}

fun setup(hello: Text, fab: Circle) {
    var result = "none" // the last result
    // counting animation
    GlobalScope.launch(Dispatchers.Main) {
        var counter = 0
        while (true) {
            hello.text = "${++counter}: $result"
            // update the text every 100ms
            delay(100)
        }
    }
    // compute next fibonacci number of each click
    var x = 1
    fab.onClick {
        result = "fib($x) = ${fib(x)}"
        x++
    }
}

suspend fun fib(x: Int): Int = withContext(Dispatchers.Main) {
    if (x <= 1) x else fib(x - 1) + fib(x - 2)
}

fun main(args: Array<String>) {
    Application.launch(Launcher::class.java, *args)
}
