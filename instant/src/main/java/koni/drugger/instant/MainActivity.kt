package koni.drugger.instant

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import android.text.Layout
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                this.setTitle(R.string.title_home)
                innerView.removeAllViews()
//                innerView.addView(layoutInflater.inflate(R.layout.view_add, null))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_drug_wiki -> {
                this.setTitle(R.string.title_drug_wiki)
                innerView.removeAllViews()
                innerView.addView(layoutInflater.inflate(R.layout.view_add, null))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                this.setTitle(R.string.title_history)
                innerView.removeAllViews()
//                innerView.addView(layoutInflater.inflate(R.layout.view_add, null))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_forum -> {
                this.setTitle(R.string.title_forum)
                innerView.removeAllViews()
//                innerView.addView(layoutInflater.inflate(R.layout.view_add, null))
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
