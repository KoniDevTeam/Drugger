package koni.drugger.instant

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private fun changeView(view: LinearLayout, targetView: Any): Unit {
//        var _view = view
//        _view = targetView as LinearLayout;
//    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                this.setTitle(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_drug_wiki -> {
                this.setTitle(R.string.title_drug_wiki)
//                changeView(innerView, findViewById(R.id.view_add))
//                this.innerView = findViewById()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                this.setTitle(R.string.title_history)

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_forum -> {
                this.setTitle(R.string.title_forum)

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
//        var inner = innerView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        inner = findViewById(R.id.view_home)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
