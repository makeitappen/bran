package ch.makeitappen.common.root

import ch.makeitappen.digipay.base.Presenter

class RootPresenter : Presenter<RootViewI>() {

    fun tabSelected(index: Int): Boolean {
        return view?.showTab(index) ?: false
    }

}