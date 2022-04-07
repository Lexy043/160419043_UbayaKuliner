package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import id.ac.ubaya.informatika.ubayakuliner_160419043.util.loadImage
import kotlinx.android.synthetic.main.fragment_profil.*
import kotlinx.android.synthetic.main.fragment_profil.view.*

class ProfilFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        txtName.setText("Alexander Calvin")
        textTanggal.setText("12/03/2002")
        textEmail.setText("alexandercalvin43@gmail.com")
        textNomor.setText("081233692394")

        view.imageView.loadImage("https://i.pinimg.com/564x/c0/f4/e7/c0f4e7315ee50243d43a5a30e869d282.jpg",view.progressBar3)
    }
}