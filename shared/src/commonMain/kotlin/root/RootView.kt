package ch.makeitappen.common.root

import ch.makeitappen.digipay.base.ViewI

expect class RootView {

    fun show(view: ViewI, modal: Boolean)
}

class RootViewImplementation(private val rootView: RootView) : RootViewI {
    override fun show(view: ViewI, modal: Boolean) {
        rootView.show(view, modal)
    }

}