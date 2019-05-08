package ch.makeitappen.common

import android.os.Build

actual fun osVersion(): String {
    return "Android ${Build.VERSION.RELEASE}"
}