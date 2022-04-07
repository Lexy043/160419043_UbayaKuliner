package id.ac.ubaya.informatika.ubayakuliner_160419043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.ubaya.informatika.ubayakuliner_160419043.R
import id.ac.ubaya.informatika.ubayakuliner_160419043.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_kuliner_list.*

class KulinerListFragment : Fragment() {
    private lateinit var viewModel: ListViewModel
    private val kulinerListAdapter = KulinerListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kuliner_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = kulinerListAdapter

        observerViewModel()
    }

    fun observerViewModel() {
        viewModel.reviewLD.observe(viewLifecycleOwner, {
            kulinerListAdapter.updateKulinerList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, {
            textError.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, {
            if (it) {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
            } else {
                progressBar.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            }
        })
    }

}