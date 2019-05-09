package ch.makeitappen.common.root

import ch.makeitappen.bran.base.ViewI

interface RootViewI : ViewI {

    fun showTab(index: Int): Boolean

}
