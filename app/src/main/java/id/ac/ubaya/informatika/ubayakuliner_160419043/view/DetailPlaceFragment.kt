package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import id.ac.ubaya.informatika.ubayakuliner_160419043.util.loadImage
import kotlinx.android.synthetic.main.fragment_detail_place.*
import kotlinx.android.synthetic.main.fragment_detail_place.view.*

class DetailPlaceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val name = DetailPlaceFragmentArgs.fromBundle(requireArguments()).nama
            val tempat = DetailPlaceFragmentArgs.fromBundle(requireArguments()).tempat
            val deskripsi = DetailPlaceFragmentArgs.fromBundle(requireArguments()).deskripsi
            val url = DetailPlaceFragmentArgs.fromBundle(requireArguments()).urlGambar

            textDetailNama.text = "$name"
            textDetailTempat.text = "$tempat"
            textDetailDeskripsi.text = "$deskripsi"
            view.imageView2.loadImage(url,view.progressBarDetail)

            buttonUbah.setOnClickListener {
                val action = DetailPlaceFragmentDirections.actionDetailPlaceFragmentToEditFragment(name,tempat,deskripsi,url)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}