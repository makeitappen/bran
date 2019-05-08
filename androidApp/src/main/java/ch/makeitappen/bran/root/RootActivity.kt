package ch.makeitappen.bran.root

import android.os.Bundle
import android.widget.TextView
import ch.makeitappen.bran.R
import ch.makeitappen.bran.base.PresenterActivity
import ch.makeitappen.common.root.RootPresenter
import ch.makeitappen.common.root.RootViewI
import ch.makeitappen.digipay.base.Presenter
import ch.makeitappen.digipay.base.ViewI
import com.google.android.material.bottomnavigation.BottomNavigationView

class RootActivity : PresenterActivity(), RootViewI {

    private val presenter = RootPresenter()

    private lateinit var textMessage: TextView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener presenter.tabSelected(item.itemId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: why do I need the cast?
        set(presenter as Presenter<ViewI>)

        presenter.tabSelected(0)

        setContentView(R.layout.activity_root)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    override fun showTab(index: Int): Boolean {
        when (index) {
            R.id.navigation_home -> {
                textMessage.setText(R.string.title_home)
                return true
            }
            R.id.navigation_dashboard -> {
                textMessage.setText(R.string.title_dashboard)
                return true
            }
            R.id.navigation_notifications -> {
                textMessage.setText(R.string.title_notifications)
                return true
            }
        }
        return false
    }
}
