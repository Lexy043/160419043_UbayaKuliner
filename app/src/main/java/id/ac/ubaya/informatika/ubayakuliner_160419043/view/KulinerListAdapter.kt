package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import id.ac.ubaya.informatika.ubayakuliner_160419043.model.Review
import id.ac.ubaya.informatika.ubayakuliner_160419043.util.loadImage
import kotlinx.android.synthetic.main.kuliner_list_item.view.*

class KulinerListAdapter (val kulinerList: ArrayList<Review>): RecyclerView.Adapter<KulinerListAdapter.KulinerViewHolder>() {
    class KulinerViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun updateKulinerList(newKulinerList: List<Review>) {
        kulinerList.clear()
        kulinerList.addAll(newKulinerList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KulinerViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val v = inflate.inflate(R.layout.kuliner_list_item, parent, false)
        return KulinerViewHolder(v)
    }

    override fun onBindViewHolder(holder: KulinerViewHolder, position: Int) {
        holder.view.textDetailNamaKuliner.text = kulinerList[position].placeName
        holder.view.imageKuliner.loadImage(
            kulinerList[position].photoUrl.toString(),
            holder.view.progressBar2
        )

        holder.view.buttonDetail.setOnClickListener {
            val placename = kulinerList[position].placeName
            val tempat = kulinerList[position].tempat
            val deskripsi = kulinerList[position].deskripsi
            val url = kulinerList[position].photoUrl

            val action = KulinerListFragmentDirections.actionDetail(
                placename.toString(),
                tempat.toString(),
                deskripsi.toString(),
                url.toString()
            )
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return kulinerList.size
    }
}