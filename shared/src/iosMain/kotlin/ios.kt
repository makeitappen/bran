package ch.makeitappen.common

import platform.UIKit.UIDevice

actual fun osVersion(): String {
    val device = UIDevice.currentDevice
    return "${device.systemName} ${device.systemVersion}"
}