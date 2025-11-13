package com.example.kmp.myapplication

import com.tencent.kuikly.core.annotations.Page
import com.tencent.kuikly.core.base.*
import com.tencent.kuikly.core.directives.vif
import com.tencent.kuikly.core.module.RouterModule
import com.tencent.kuikly.core.module.SharedPreferencesModule
import com.tencent.kuikly.core.nvi.serialization.json.JSONObject
import com.tencent.kuikly.core.utils.urlParams
import com.tencent.kuikly.core.views.*
import com.tencent.kuikly.core.views.compose.Button
import com.tencent.kuikly.core.reactive.handler.*
import com.example.kmp.myapplication.base.BasePager
import com.example.kmp.myapplication.base.BridgeModule
import com.example.kmp.myapplication.base.bridgeModule
import com.example.kmp.myapplication.widget.HBKEmojiText
import com.tencent.kuikly.core.base.attr.ImageUri

@Page("router", supportInLocal = true)
internal class RouterPage : BasePager() {

    var inputText: String = ""
    lateinit var inputRef: ViewRef<InputView>

    override fun body(): ViewBuilder {
        val ctx = this
        return {
            attr {
                backgroundColor(Color.WHITE)
                padding(100F)
            }
            Text {
                attr {
                    text("测试内容1")
                }
            }
            HBKEmojiText {
                attr {
                    minHeight(1f)
                    text("测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2测试内容2")
                }
            }
        }

    }

    override fun created() {
        super.created()
        acquireModule<BridgeModule>(BridgeModule.MODULE_NAME).log(">>>>>>>>>>>> 测试")
    }

    override fun viewDidLoad() {
        super.viewDidLoad()
        val cacheInputText =
            acquireModule<SharedPreferencesModule>(SharedPreferencesModule.MODULE_NAME).getItem(
                CACHE_KEY
            )
        if (cacheInputText.isNotEmpty()) {
            inputRef.view?.setText(cacheInputText)
        }
    }

    private fun jumpPage(inputText: String) {
        val params = urlParams("pageName=$inputText")
        val pageData = JSONObject()
        params.forEach {
            pageData.put(it.key, it.value)
        }
        val pageName = pageData.optString("pageName")
        acquireModule<RouterModule>(RouterModule.MODULE_NAME).openPage(pageName, pageData)
    }

    companion object {
        const val PLACEHOLDER = "输入pageName"
        const val TIP = "输入规则：router 或者 router&key=value (&后面为页面参数)"
        const val CACHE_KEY = "router_last_input_key2"
        const val BG_URL =
            "https://sqimg.qq.com/qq_product_operations/kan/images/viola/viola_bg.jpg"
        const val LOGO = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/Dfnp7Q9F.png"
        const val JUMP_TEXT = "跳转"
        const val TEXT_KEY = "text"
        const val TITLE = "Kuikly页面路由"
        private const val AAR_MODE_TIP = "如：router 或者 router&key=value （&后面为页面参数）"
    }

}