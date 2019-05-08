package ch.makeitappen.bran.base

import androidx.appcompat.app.AppCompatActivity
import ch.makeitappen.digipay.base.Presenter
import ch.makeitappen.digipay.base.ViewI

open class PresenterActivity : AppCompatActivity(), ViewI {

    private lateinit var _presenter: Presenter<ViewI>

    fun set(presenter: Presenter<ViewI>) {
        _presenter = presenter
    }

    override fun onStart() {
        super.onStart()
        _presenter.attach(this)
    }

    override fun onStop() {
        super.onStop()
        _presenter.detach()
    }

}