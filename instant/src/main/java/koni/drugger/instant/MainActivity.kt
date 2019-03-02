package koni.drugger.instant

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
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

    private fun askPermission(perm: String) {
        if (ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    perm)) {
            } else {
                ActivityCompat.requestPermissions(this,
                    arrayOf(perm),
                    666)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addTripButton.setOnClickListener(addTripOnclick)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        askPermission(Manifest.permission.INTERNET)
        askPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }
}
