package com.example.demo.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val appSizeRule by cssclass()
    }

    init {
        select(appSizeRule) {
            minHeight = 200.px
            minWidth = 300.px
        }
    }
}