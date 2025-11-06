package com.example.kmp.myapplication.widget

import com.tencent.kuikly.core.base.DeclarativeBaseView
import com.tencent.kuikly.core.base.ViewContainer

class HBKEmojiTextView : DeclarativeBaseView<HBKEmojiTextAttr, HBKEmojiTextEvent>() {

    override fun createAttr(): HBKEmojiTextAttr {
        return HBKEmojiTextAttr()
    }

    override fun createEvent(): HBKEmojiTextEvent {
        return HBKEmojiTextEvent()
    }

    override fun viewName(): String {
        return "HBKEmojiText"
    }
}

fun ViewContainer<*, *>.HBKEmojiText(init: HBKEmojiTextView.() -> Unit) {
    addChild(HBKEmojiTextView(), init)
}