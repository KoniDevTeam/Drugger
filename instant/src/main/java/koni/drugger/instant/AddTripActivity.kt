package koni.drugger.instant

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*


class AddTripActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        this.setTitle(R.string.title_add_trip)
        print("LOL")
        this.textView.text = "lol"
    }
}