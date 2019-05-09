package ch.makeitappen.bran.root

import android.os.Bundle
import android.widget.TextView
import ch.makeitappen.bran.R
import ch.makeitappen.bran.base.PresenterActivity
import ch.makeitappen.bran.news.NewsFragment
import ch.makeitappen.common.root.RootPresenter
import ch.makeitappen.common.root.RootViewI
import com.google.android.material.bottomnavigation.BottomNavigationView

class RootActivity : PresenterActivity(), RootViewI {

    private val presenter = RootPresenter()

//    private lateinit var textMessage: TextView

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        return@OnNavigationItemSelectedListener presenter.tabSelected(item.itemId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        set(presenter)

        presenter.tabSelected(0)

        setContentView(R.layout.activity_root)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

//        textMessage = findViewById(R.id.message)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        supportFragmentManager.beginTransaction().add(R.id.frameLayout, NewsFragment.newInstance(1)).commit()
//        fm.beginTransaction().add(R.id.main_container, fragment3, "3").hide(fragment3).commit();
//        fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
//        fm.beginTransaction().add(R.id.main_container,fragment1, "1").commit();
    }

    override fun showTab(index: Int): Boolean {
        when (index) {
            R.id.navigation_home -> {
//                textMessage.setText(R.string.title_home)
                return true
            }
            R.id.navigation_dashboard -> {
//                textMessage.setText(R.string.title_dashboard)
                return true
            }
            R.id.navigation_notifications -> {
//                textMessage.setText(R.string.title_notifications)
                return true
            }
        }
        return false
    }
}
