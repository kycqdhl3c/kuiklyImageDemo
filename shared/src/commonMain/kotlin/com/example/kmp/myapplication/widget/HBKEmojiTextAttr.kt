package com.example.kmp.myapplication.widget

import com.tencent.kuikly.core.base.Attr
import com.tencent.kuikly.core.base.Color

open class HBKEmojiTextAttr : Attr() {

    open fun text(text: String): HBKEmojiTextAttr {
        EmojiTextConst.VALUE with text
        return this
    }

    open fun fontSize(size: Float): HBKEmojiTextAttr {
        EmojiTextConst.FONT_SIZE with size
        return this
    }

    open fun color(color: Long): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_COLOR with Color(color).toString()
        return this
    }

    open fun color(color: Color): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_COLOR with color.toString()
        return this
    }

    open fun fontWeightNormal(): HBKEmojiTextAttr {
        EmojiTextConst.FONT_WEIGHT with EmojiFontWeight.NORMAL.value
        return this
    }

    open fun fontWeightBold(): HBKEmojiTextAttr {
        EmojiTextConst.FONT_WEIGHT with EmojiFontWeight.BOLD.value
        return this
    }

    open fun fontWeightMedium(): HBKEmojiTextAttr {
        EmojiTextConst.FONT_WEIGHT with EmojiFontWeight.MEDIUM.value
        return this
    }

    open fun fontWeightSemiBold(): HBKEmojiTextAttr {
        EmojiTextConst.FONT_WEIGHT with EmojiFontWeight.SEMISOLID.value
        return this
    }

    open fun textAlignCenter(): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_ALIGN with EmojiTextAlign.CENTER.value
        return this
    }

    open fun textAlignLeft(): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_ALIGN with EmojiTextAlign.LEFT.value
        return this
    }

    open fun textAlignRight(): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_ALIGN with EmojiTextAlign.RIGHT.value
        return this
    }

    open fun textOverFlowMiddle(): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_OVERFLOW with "middle"
        return this
    }

    open fun textOverFlowTail(): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_OVERFLOW with "tail"
        return this
    }

    open fun textOverFlowClip(): HBKEmojiTextAttr {
        EmojiTextConst.TEXT_OVERFLOW with "clip"
        return this
    }

    open fun fontStyleNormal(): HBKEmojiTextAttr {
        EmojiTextConst.FONT_STYLE with EmojiFontStyle.NORMAL.value
        return this
    }

    open fun fontStyleItalic(): HBKEmojiTextAttr {
        EmojiTextConst.FONT_STYLE with EmojiFontStyle.ITALIC.value
        return this
    }

    open fun lines(lines: Int): HBKEmojiTextAttr {
        EmojiTextConst.LINES with lines
        return this
    }

    open fun lineSpacing(value: Float): HBKEmojiTextAttr {
        EmojiTextConst.LINE_SPACING with value
        return this
    }

    // 自适应高度（必须设置maxTextWidth）
    open fun autoHeight(isAutoHeight: Boolean): HBKEmojiTextAttr {
//        EmojiTextConst.AUTO_WIDTH with isAutoWidth
        EmojiTextConst.AUTO_HEIGHT with isAutoHeight
        return this
    }

    // 最大文本宽度，自适应高度必须设置
    open fun maxTextWidth(value: Float): HBKEmojiTextAttr {
        EmojiTextConst.MAX_TEXT_WIDTH with value
        return this
    }
}

object EmojiTextConst {
    const val VALUE = "text"
    const val FONT_SIZE = "fontSize"
    const val FONT_WEIGHT = "fontWeight"
    const val FONT_STYLE = "fontStyle"
    const val TEXT_OVERFLOW = "lineBreakMode"
    const val TEXT_COLOR = "color"
    const val LINES = "numberOfLines"
    const val LINE_SPACING = "lineSpacing"
    const val TEXT_ALIGN = "textAlign"
    const val AUTO_WIDTH = "autoWidth"
    const val AUTO_HEIGHT = "autoHeight"
    const val SYNC_VIEW_SIZE = "syncViewSize"
    const val MAX_TEXT_WIDTH = "maxTextWidth"
}

enum class EmojiTextAlign(val value: String) {
    LEFT("left"),
    CENTER("center"),
    RIGHT("right")
}

enum class EmojiFontStyle(val value: String) {
    NORMAL("normal"),
    ITALIC("italic")
}

enum class EmojiFontWeight(val value: String) {
    NORMAL("400"),
    MEDIUM("500"),
    SEMISOLID("600"),
    BOLD("700")
}