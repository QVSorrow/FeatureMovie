package com.featmov.serles.featuremovie.presentation.main.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.featmov.serles.featuremovie.R
import com.featmov.serles.featuremovie.base.BaseVMFragment
import com.featmov.serles.featuremovie.databinding.FragmentMainBinding
import com.featmov.serles.featuremovie.presentation.main.adapter.MainAdapter
import com.featmov.serles.featuremovie.presentation.main.MovieClick
import com.featmov.serles.featuremovie.presentation.main.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import kotlin.reflect.KClass


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val MOVIE_ID = "MOVIE_ID"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentMain.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FragmentMain.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentMain : BaseVMFragment<MovieViewModel, FragmentMainBinding>(), MovieClick {

    override fun getViewModelClass() : KClass<MovieViewModel> = MovieViewModel::class

    override val layoutId : Int
        get() = R.layout.fragment_main


    private var param1 : String? = null
    private var param2 : String? = null
    private var listener : OnFragmentInteractionListener? = null
    var adapter = MainAdapter()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(MOVIE_ID)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun setupViewModel(binding : FragmentMainBinding) {
        adapter.movieClick = this
        binding.list.adapter = adapter
    }

    override fun onAttach(context : Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onClick(movieId : Int) {
        findNavController().navigate(
                FragmentMainDirections.actionFragmentMainToFragmentSecond(movieId)
        )
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri : Uri)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentMain.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1 : String, param2 : String) =
                FragmentMain().apply {
                    arguments = Bundle().apply {
                        putString(MOVIE_ID, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
