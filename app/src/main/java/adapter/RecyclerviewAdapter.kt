package adapter

import android.app.DownloadManager
import android.app.VoiceInteractor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresOptIn
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sample.test.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_row.view.*
import model.UserData

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    private var  listData: List<UserData.Data>?= null

    fun setUpdatedData(listData: List<UserData.Data>){
        this.listData = listData
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        listData?.let { holder.bind(it.get(position)) }
    }

    override fun getItemCount(): Int {
       /* if(listData == null) return  0
        else return listData?.size!!*/
        return listData?.size ?: 0
    }



    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val imageView = view.imageView
        val nameText = view.textviewName
        val descText = view.textviewDescription
        fun bind(data: UserData.Data){

            nameText.text = data.first_name
            descText.text = data.email
            Glide.with(imageView)
                .load(data.avatar)
                .apply(RequestOptions.centerCropTransform())
                .into(imageView)

        }
    }
}