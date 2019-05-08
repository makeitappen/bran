package ch.makeitappen.common.root

import ch.makeitappen.digipay.base.ViewI

interface RootViewI: ViewI {

    fun show(view: ViewI, modal: Boolean)
}
