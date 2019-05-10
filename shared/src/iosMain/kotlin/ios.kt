package ch.makeitappen.common

import platform.UIKit.UIDevice

//import kotlinx.coroutines.*

//class UI : CoroutineDispatcher() {
//    override fun dispatch(context: CoroutineContext, block: Runnable) {
//        val queue = dispatch_get_main_queue()
//        dispatch_async(queue) {
//            block.run()
//        }
//    }
//}

actual fun osVersion(): String {
    val device = UIDevice.currentDevice
    return "${device.systemName} ${device.systemVersion}"
}

//
//private class MainDispatcher : CoroutineDispatcher() {
//    override fun dispatch(context: CoroutineContext, block: Runnable) {
//        dispatch_async(dispatch_get_main_queue()) { block.run() }
//    }
//}
//
//internal class MainScope : CoroutineScope {
//    private val dispatcher = MainDispatcher()
//    private val job = Job()
//
//    override val coroutineContext: CoroutineContext
//        get() = dispatcher + job
//}