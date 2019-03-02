package koni.drugger.instant

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val addTripOnclick = View.OnClickListener {
        //        view.visibility = View.INVISIBLE
        val addTripIntent = Intent(this, AddTripActivity::class.java)
        startActivity(addTripIntent)
//        this.setTitle(R.string.title_add_trip)
//        innerView.removeAllViews()
//        innerView.addView(layoutInflater.inflate(R.layout.view_add, null))
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        bottomNavigation.menu.findItem(R.id.navigation_dashboard).icon = getDrawable(R.drawable.dashboard_outline)
        bottomNavigation.menu.findItem(R.id.navigation_drug_wiki).icon = getDrawable(R.drawable.help_outline)
        bottomNavigation.menu.findItem(R.id.navigation_forum).icon = getDrawable(R.drawable.forum_outline)
        when (item.itemId) {
            R.id.navigation_dashboard -> {
                this.setTitle(R.string.title_home)
                item.icon = getDrawable(R.drawable.dashboard)
                innerView.removeAllViews()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_drug_wiki -> {
                this.setTitle(R.string.title_drug_wiki)
                item.icon = getDrawable(R.drawable.help)
                innerView.removeAllViews()
                //innerView.addView(layoutInflater.inflate(R.layout.activity_add, null))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                this.setTitle(R.string.title_history)
                innerView.removeAllViews()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_forum -> {
                this.setTitle(R.string.title_forum)
                item.icon = getDrawable(R.drawable.forum)
                innerView.removeAllViews()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addTripButton.setOnClickListener(addTripOnclick)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
