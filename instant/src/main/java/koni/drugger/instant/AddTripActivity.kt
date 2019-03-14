package koni.drugger.instant

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import koni.drugger.instant.dbapi.updateDb
import koni.drugger.instant.view.TileView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.view_tile.view.*

public const val DRUG_ID = "koni.drugger.DRUG_ID"

class AddTripActivity : AppCompatActivity() {

    var answerIntent = Intent()

    val tileOnClickListener = View.OnClickListener {_it ->
        val it = _it as TileView
//        println("OHH! I`d been clicked!!!!!!!!!!!!!!!!!")
        answerIntent.putExtra(DRUG_ID, it.getDrugId())
        setResult(Activity.RESULT_OK, answerIntent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        this.setTitle(R.string.title_add_trip)
        updateDb(this)
//        val drugs = getAllDrugs(this)
        val drugs = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)
        drugs.forEachIndexed { index, drugType ->
//            println("hello!!!!!!!!!!!!!!")
            var text_view = TileView(this)
            text_view.constraightLayout.imageView.clipToOutline = true
//            var params = text_view.layoutParams as RelativeLayout.LayoutParams
//            params.topMargin = 10
//            params.leftMargin = 10
//            params.height = 100
//            params.width = 100
//            text_view.layoutParams = params
            text_view.setTitle(resources.getString(R.string.app_name))
            text_view.setDrugId(index)
            text_view.setOnClickListener(tileOnClickListener)
            if (index.rem(2) == 0){
                text_view.setTitle(index.toString())
                column1.addView(text_view)
                println("1")
            } else {
                text_view.setTitle(index.toString())
                column2.addView(text_view)
                println("2")
            }
        }
    }
}