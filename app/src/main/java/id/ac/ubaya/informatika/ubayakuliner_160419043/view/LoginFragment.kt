package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionListView()
            Navigation.findNavController(it).navigate(action)
        }

        buttonRegister.setOnClickListener {
            val action = LoginFragmentDirections.actionRegis()
            Navigation.findNavController(it).navigate(action)
        }
    }
}