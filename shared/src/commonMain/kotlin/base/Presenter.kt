package ch.makeitappen.bran.base


abstract class Presenter<V : ViewI> {


    // needs to be nullable for iOS memory management
    protected var view: V? = null
        private set

    fun attach(view: V) {
        if (this.view != view) {
            this.view = view
            onViewAttached()
        }
    }

    fun detach() {
        this.view = null
        onViewDetached()
    }

    open fun onViewAttached() {

    }

    open fun onViewDetached() {

    }
}