package ch.makeitappen.digipay.base

open class Presenter<View : ViewI> {

    protected var view: View? = null

    fun attach(view: View) {
        this.view = view
    }

    fun detach() {
        view = null
    }

}