package com.featmov.serles.featuremovie.presentation.second.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.featmov.serles.featuremovie.R
import com.featmov.serles.featuremovie.presentation.second.fragment.FragmentSecondArgs.fromBundle
import com.featmov.serles.featuremovie.presentation.second.viewmodel.MovieDetailViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val MOVIE_ID = "MOVIE_ID"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [FragmentSecond.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [FragmentSecond.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class FragmentSecond : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MovieDetailViewModel
    // TODO: Rename and change types of parameters
    private var param1 : Int? = null
    private var param2 : String? = null
    private var listener : OnFragmentInteractionListener? = null
    lateinit var movie_img: ImageView
    lateinit var movie_name: TextView
    lateinit var movie_genres: TextView
    lateinit var movie_overview: TextView
    var mobieId = 0

    override fun onCreate(savedInstanceState : Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        arguments?.let {
            mobieId = fromBundle(it).movieId
            param1 = it.getInt(MOVIE_ID)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        var view = inflater.inflate(R.layout.fragment_second, container, false)
        movie_img = view.findViewById(R.id.movie_img)
        movie_name = view.findViewById(R.id.movie_name)
        movie_genres = view.findViewById(R.id.movie_genres)
        movie_overview = view.findViewById(R.id.movie_overview)
        return view
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri : Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context : Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onViewCreated(view : View, savedInstanceState : Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.let { activity ->
            viewModel = ViewModelProviders.of(activity, viewModelFactory)
                    .get(MovieDetailViewModel::class.java)
            viewModel.movieLiveData.observe(this, Observer {
                movie_name.text = it?.title
                movie_genres.text = it?.genres?.get(0)?.name
                movie_overview.text = it?.overview
                Glide.with(activity)
                        .load(resources.getString(R.string.img_url) + it?.backdrop_path)
                        .apply(RequestOptions()
                                .placeholder(R.drawable.ic_launcher_background)
                                .fitCenter())
                        .into(movie_img)
            })
            viewModel.getMovie(mobieId)
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
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
         * @return A new instance of fragment FragmentSecond.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1 : String, param2 : String) =
                FragmentSecond().apply {
                    arguments = Bundle().apply {
                        putString(MOVIE_ID, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
