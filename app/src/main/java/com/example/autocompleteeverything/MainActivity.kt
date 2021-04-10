package com.example.autocompleteeverything

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.common.api.Status
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var placeLatitude: String
        var placeLongitude: String
        var placeName: String
        val textView1 = findViewById<TextView>(R.id.tv1)

        val apikey = "AIzaSyAHMbkMzKtcnBhdz4ItcoT36OhjBxkGJQo"

        if (!Places.isInitialized()) {
            Places.initialize(applicationContext, apikey)
        }

        //Initialize Autocomplete Fragments
        val autocompleteSupportFragment1 =
            supportFragmentManager.findFragmentById(R.id.autocomplete_fragment1) as AutocompleteSupportFragment?
        autocompleteSupportFragment1!!.setPlaceFields(
            listOf(
                Place.Field.ID,
                Place.Field.LAT_LNG,
                Place.Field.NAME
            )
        )
        autocompleteSupportFragment1.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onPlaceSelected(place: Place) {
                val latLng = place.latLng

                Toast.makeText(applicationContext,place.name,Toast.LENGTH_LONG).show()

            }

            override fun onError(status: Status) {}
        })

        // Append the retrieved info about the place



    }
}