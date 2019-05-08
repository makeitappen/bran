package ch.makeitappen.common

expect fun osVersion(): String

class DeviceInfo {
    val osVersion = osVersion()
}