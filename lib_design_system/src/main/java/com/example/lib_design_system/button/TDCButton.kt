package com.example.lib_design_system.button

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatButton
import com.example.lib_design_system.R
import com.example.lib_design_system.button.TDCButtonType.Companion.TYPE_CONTAINED
import com.example.lib_design_system.button.TDCButtonType.Companion.TYPE_OUTLINED

class TDCButton(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    FrameLayout(context, attrs, defStyleAttr) {

    var text: String
        get() = button.text.toString()
        set(value) {
            button.text = value
        }

    var type: Int
        get() = buttonType
        set(value) {
            setupButtonStyle(value)
        }

    private var button: AppCompatButton
    private var buttonType: Int = TYPE_CONTAINED
    private var buttonText: String = ""
    private var buttonEnabled: Boolean = true

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, NOT_STYLE_ATTR)

    init {
        if (attrs != null) {
            val attr = context.obtainStyledAttributes(
                attrs,
                R.styleable.TDCButton,
                defStyleAttr,
                NOT_STYLE_ATTR
            )

            setupAttribute(attr)
        }
        this.type = buttonType

        button = findViewById(R.id.tdc_ds_button)
        this.text = buttonText
        this.isEnabled = buttonEnabled
        this.height
    }

    private fun setupAttribute(attr: TypedArray) {
        buttonType = attr.getInt(R.styleable.TDCButton_buttonType, TYPE_CONTAINED)

        buttonText = attr.getString(R.styleable.TDCButton_text) ?: ""

        buttonEnabled = attr.getBoolean(R.styleable.TDCButton_enabled, true)

        attr.recycle()
    }

    private fun setupButtonStyle(type: Int) {
        when (type) {
            TYPE_CONTAINED -> setLayout(R.layout.layout_button_contained_regular)
            TYPE_OUTLINED -> setLayout(R.layout.layout_button_outlined_regular)
        }
    }

    private fun setLayout(resource: Int) {
        View.inflate(context, resource, this)
    }

    override fun isEnabled(): Boolean {
        return button.isEnabled
    }

    override fun setEnabled(enabled: Boolean) {
        button.isEnabled = enabled
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

    companion object {
        private const val NOT_STYLE_ATTR = 0
    }
}