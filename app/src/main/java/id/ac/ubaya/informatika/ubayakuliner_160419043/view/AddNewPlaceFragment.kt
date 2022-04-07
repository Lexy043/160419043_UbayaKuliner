package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import kotlinx.android.synthetic.main.fragment_add_new_place.*

class AddNewPlaceFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_new_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAdd.setOnClickListener {
            Toast.makeText(activity, "Tempat Baru Berhasil di tambah", Toast.LENGTH_SHORT).show()
        }
    }
}