package pl.marchuck.parki.ui.trending

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import pl.marchuck.parki.R

class TrendingViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    private var textView: TextView? = null

    init {
        textView = itemView?.findViewById(R.id.text1)
    }

    fun bind(str: String) {
        textView?.text = str
    }
}