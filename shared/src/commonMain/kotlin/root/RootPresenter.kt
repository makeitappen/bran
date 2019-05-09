package ch.makeitappen.common.root

import ch.makeitappen.bran.base.Presenter

class RootPresenter : Presenter<RootViewI>() {

    fun tabSelected(index: Int): Boolean {
        return view?.showTab(index) ?: false
    }
}