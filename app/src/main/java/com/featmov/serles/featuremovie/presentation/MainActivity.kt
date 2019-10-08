package com.featmov.serles.featuremovie.presentation

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.featmov.serles.featuremovie.R
import com.featmov.serles.featuremovie.presentation.main.fragment.FragmentMain
import com.featmov.serles.featuremovie.presentation.second.fragment.FragmentSecond

class MainActivity : AppCompatActivity(), FragmentMain.OnFragmentInteractionListener, FragmentSecond.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri : Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}