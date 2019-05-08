package ch.makeitappen.digipay.base

open class Presenter<View : ViewI> {

    protected var view: View? = null

    open fun attach(view: View) {
        this.view = view
    }

    open fun detach() {
        view = null
    }

}