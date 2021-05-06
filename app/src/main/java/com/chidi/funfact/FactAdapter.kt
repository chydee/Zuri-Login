package com.chidi.funfact

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class FactAdapter(context: Context, facts: List<FactModel>) : ArrayAdapter<FactModel>(context, 0, facts) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val fact = getItem(position)
        if (view == null) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_fact, parent, false)
        }
        val itemLogo = view?.findViewById<ImageView>(R.id.itemLogo)
        val itemName = view?.findViewById<TextView>(R.id.itemName)

        fact?.logo?.let { itemLogo?.setImageResource(it) }
        fact?.name?.let { itemName?.setText(it) }

        //Handle clicks on items here
        view?.setOnClickListener {
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra(LOGO_EXTRAS, fact?.logo)
            intent.putExtra(NAME_EXTRAS, fact?.name)
            intent.putExtra(FACT_EXTRAS, fact?.fact)
            parent.context.startActivity(intent)
        }
        return view ?: super.getView(position, convertView, parent)
    }

    companion object {
        val LOGO_EXTRAS = "logo_extras"
        val NAME_EXTRAS = "name_extras"
        val FACT_EXTRAS = "fact_extras"
    }


}