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
    RealmRecyclerViewAdapter<WorkTime,WorkTimeAdapter.ViewHolder>(data,true){

        init {
            setHasStableIds(true)
        }
    //セルの中身
    //text1 - text4　とされるものを適切に定義する必要。
    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell){
        val date:       TextView = cell.findViewById(R.id.textView)           // 11/11 18:04 ここも読んでくれた。
        val attendance: TextView = cell.findViewById(R.id.textView2)
        val leave:      TextView = cell.findViewById(R.id.textView3)
        val workTime:   TextView = cell.findViewById(R.id.textView4)
    }

    //セルが必要になるたびに呼び出される
    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ) :
            WorkTimeAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.calender_cell // 11/11 text1 - text4を表示するリスト) p320いわく、inflateメソッド//
                                                            // 11/11/18:00 calender_cell.xml作って、android.R.layout~　をR.layoutにしたら読んでくれた
            ,parent, false)
        return ViewHolder(view)
    }

    // holder.の次のはなんなのか
    //日にちの表示もここでやるか？
    override fun onBindViewHolder ( holder: WorkTimeAdapter.ViewHolder,position: Int ){
        val worktime: WorkTime? = getItem(position) // 11/11 worktimeはここで作った変数。p319
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