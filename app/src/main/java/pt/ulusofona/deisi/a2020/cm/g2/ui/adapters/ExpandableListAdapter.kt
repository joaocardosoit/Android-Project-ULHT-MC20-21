package pt.ulusofona.deisi.a2020.cm.g2.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import pt.ulusofona.deisi.a2020.cm.g2.grupo2.R

class ExpandableListAdapter (var context: Context, var assunto: MutableList<String>, var conteudo: MutableList<MutableList<String>>) : BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String {
        return assunto[groupPosition]
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_group, null)
        }
        val title = convertView?.findViewById<TextView>(R.id.contactos_title)
        title?.text = getGroup(groupPosition)
        return convertView
    }

    override fun getChildrenCount(groupPosition: Int): Int {
        return conteudo[groupPosition].size
    }

    override fun getChild(groupPosition: Int, childPosition: Int): String {
        return conteudo[groupPosition][childPosition]
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var convertView = convertView
        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.layout_child, null)
        }
        val title = convertView?.findViewById<TextView>(R.id.contactos_title)
        title?.text = getChild(groupPosition, childPosition)
        return convertView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {
        return assunto.size
    }
}