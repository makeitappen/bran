package ch.makeitappen.bran.base

import androidx.fragment.app.Fragment

abstract class PresenterFragment : Fragment(), ViewI {

    // subclass must set this variable
    private lateinit var presenter: Presenter<ViewI>

    fun set(presenter: Presenter<*>) {
        // TODO is there a better solution for this, to avoid suppressing the warning?
//        @Suppress("UNCHECKED_CAST")
        this.presenter = presenter as Presenter<ViewI>
    }

    override fun onStart() {
        super.onStart()
        presenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detach()
    }

}