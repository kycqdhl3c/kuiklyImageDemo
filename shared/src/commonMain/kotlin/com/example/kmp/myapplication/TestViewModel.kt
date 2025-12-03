package com.example.kmp.myapplication

import com.tencent.kuikly.core.base.PagerScope
import com.tencent.kuikly.core.reactive.handler.observableList
import com.tencent.kuikly.core.timer.setTimeout

class TestViewModel(override var pagerId: String) : PagerScope {

    var list by observableList<TestBean>()

    init {
        val list = arrayListOf<TestBean>()
        for (index in 0..5) {
            val testBean = TestBean()
            testBean.index = index.toString()
            list.add(testBean)
        }
        this.list.clear()
        this.list.addAll(list)
    }

    fun deleteItem(item: TestBean) {
        list.removeAt(list.size - 1)
    }
}

class TestBean {
    var index: String = ""
}