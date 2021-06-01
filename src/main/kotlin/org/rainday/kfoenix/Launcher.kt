package org.rainday.kfoenix

import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.layout.BorderPane
import javafx.scene.layout.StackPane
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.runBlocking


/**
 *
 * @author wyd
 * @time  2021/6/1 9:07 下午
 * @description
 */
class Launcher : Application() {
    override fun start(primaryStage: Stage) {
        println("start")
        // TODO("Not yet implemented")
        // Create a scene and place a button in the scene
        primaryStage.title = "Hello World!"
        val btn = Button()
        btn.text = "Say 'Hello World'"
        /*btn.setOnAction(object : EventHandler<ActionEvent?>() {
            override fun handle(event: ActionEvent?) {
                println("Hello World!")
            }
        })*/

        val root = BorderPane()
        root.children.add(btn)
        primaryStage.scene = Scene(root, 300.0, 250.0)
        primaryStage.show()
    }

    override fun init() {
        super.init()
        println("init ")
    }
}

fun main(args: Array<String>) {
    Application.launch(Launcher::class.java, *args)
}
