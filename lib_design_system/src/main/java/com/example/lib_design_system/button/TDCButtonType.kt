package com.example.lib_design_system.button

import androidx.annotation.IntDef
import com.example.lib_design_system.button.TDCButtonType.Companion.TYPE_CONTAINED
import com.example.lib_design_system.button.TDCButtonType.Companion.TYPE_OUTLINED

@IntDef(TYPE_CONTAINED, TYPE_OUTLINED)
@Retention(AnnotationRetention.SOURCE)
annotation class TDCButtonType {
    companion object {
        const val TYPE_CONTAINED = 0
        const val TYPE_OUTLINED = 1
    }
}