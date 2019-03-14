package koni.drugger.instant.view

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import koni.drugger.instant.R
import kotlinx.android.synthetic.main.view_tile.view.*

class TileView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    var title = "hey" as CharSequence
    var drug_id = 0
    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_tile, this, true)

        orientation = VERTICAL

        attrs?.let {
            val typedArray = context.theme.obtainStyledAttributes(it, R.styleable.TileView, 0, 0)
            typedArray.apply {
                try {
                    title = getText(R.styleable.TileView_view_tile_title)
                    drug_title.text = title
                    drug_id = getInt(R.styleable.TileView_view_tile_drug_id, 0)
                } finally {
                    recycle()
                }
            }
//            val title = resources.getText(typedArray
//                .getResourceId(R.styleable
//                    .TileView_view_tile_title,
//                    R.string.app_name))
//            drug_title.text = title
//            typedArray.recycle()
        }
    }

    fun setTitle(newTitle: String): Boolean {
        title = newTitle
        drug_title.text = title
        return true
    }

    fun getDrugId(): Int {
        return this.drug_id
    }

    fun setDrugId(newId: Int): Boolean {
        drug_id = newId
        return true
    }
}