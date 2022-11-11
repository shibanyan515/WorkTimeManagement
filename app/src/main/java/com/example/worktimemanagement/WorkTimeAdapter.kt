package com.example.worktimemanagement

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter
import java.lang.reflect.Type
import java.text.DateFormat

class WorkTimeAdapter(data: OrderedRealmCollection<WorkTime>) :
    RealmRecyclerViewAdapter<WorkTime,WorkTimeAdapter.viewHolder>(data,true){

        init {
            setHasStableIds(true)
        }

    //text1 - text4　とされるものを適切に定義する必要。
    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell){
        val date: TextView = cell.findViewById(android.R.id.text1)
        val attendance: TextView = cell.findViewById(android.R.id.text2)
        val leave: TextView = cell.findViewById(android.R.id.text3)
        val workTime: TextView = cell.findViewById(android.R.id.text4)
    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ) :
            WorkTimeAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(android.R.layout.//text1 - text4を表示するリスト) p320いわく、infalteメソッド//
            ,parent, false)
        return ViewHolder(view)
    }

    // holder.の次のはなんなのか
    override fun onBindViewHolder ( holder: WorkTimeAdapter,position: Int ){
        val worktime: WorkTime? = getItem(position) //worktimeはここで作った変数。p319
        holder.date.text = android.text.format.DateFormat.format(
            "yyyy/MM/dd HH:mm", worktime?.date)
        holder.attendance.text = android.text.format.DateFormat.format(
            "yyyy/MM/dd HH:mm",worktime?.attendance)
        holder.leave.text = android.text.format.DateFormat.format(
            "yyyy/MM/dd HH:mm", worktime?.leaving)
        //文字列のためformat不要?
        holder.workTime.text = android.text.format.DateFormat.format(
            "yyyy/MM/dd HH:mm", worktime?.workTime)

    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: 0
    }
}