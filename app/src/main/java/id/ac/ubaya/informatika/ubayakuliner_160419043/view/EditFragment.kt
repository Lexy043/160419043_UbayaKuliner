package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import kotlinx.android.synthetic.main.fragment_edit.*

class EditFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null){
            val nama = EditFragmentArgs.fromBundle(requireArguments()).nama
            val tempat = EditFragmentArgs.fromBundle(requireArguments()).tempat
            val deskripsi = EditFragmentArgs.fromBundle(requireArguments()).deskripsi
            val url = EditFragmentArgs.fromBundle(requireArguments()).url

            textEditNama.setText(nama)
            textEditTempat.setText(tempat)
            textEditDeskripsi.setText(deskripsi)
            textEditPhoto.setText(url)
        }
        buttonEdit.setOnClickListener {
            Toast.makeText(activity, "Recipe Berhasil di Ubah", Toast.LENGTH_SHORT).show()
        }
    }
}