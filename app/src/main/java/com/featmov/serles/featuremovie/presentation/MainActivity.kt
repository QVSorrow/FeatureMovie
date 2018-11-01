package com.featmov.serles.featuremovie.presentation

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.featmov.serles.featuremovie.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), FragmentMain.OnFragmentInteractionListener, HasSupportFragmentInjector, FragmentSecond.OnFragmentInteractionListener {

    @Inject
    lateinit var fragmentInjector : DispatchingAndroidInjector<Fragment>

    override fun onFragmentInteraction(uri : Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun supportFragmentInjector() : AndroidInjector<Fragment> = fragmentInjector
}
