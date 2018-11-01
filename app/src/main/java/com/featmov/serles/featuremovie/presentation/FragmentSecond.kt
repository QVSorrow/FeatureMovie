package com.featmov.serles.featuremovie.presentation

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.featmov.serles.featuremovie.R
import dagger.android.support.AndroidSupportInjection


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val MOVIE_IMG_URL = "MOVIE_IMG_URL"
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
    // TODO: Rename and change types of parameters
    private var param1 : String? = null
    private var param2 : String? = null
    private var listener : OnFragmentInteractionListener? = null
    lateinit var big_img: ImageView

    override fun onCreate(savedInstanceState : Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(MOVIE_IMG_URL)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater : LayoutInflater, container : ViewGroup?,
                              savedInstanceState : Bundle?) : View? {
        var view = inflater.inflate(R.layout.fragment_second, container, false)
        big_img = view.findViewById(R.id.big_img)
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
            Glide.with(activity)
                    .load(param1)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.ic_launcher_background)
                            .fitCenter())
                    .into(big_img)
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
                        putString(MOVIE_IMG_URL, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}
