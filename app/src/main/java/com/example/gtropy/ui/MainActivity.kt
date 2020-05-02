package com.example.gtropy.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.gtropy.R
import com.example.gtropy.databinding.ActivityMainBinding
import com.example.gtropy.ui.model.VehicleList
import com.example.gtropy.utils.DATA_FILENAME
import com.example.gtropy.utils.RecyclerViewClickListener
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import java.util.*
import java.util.EnumSet.of

class MainActivity : AppCompatActivity(),RecyclerViewClickListener<VehicleList> {
    private lateinit var mBinding:ActivityMainBinding
    private var adapter = VehicleListAdapter(this);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mBinding.lifecycleOwner = this;
        mBinding.recyclerView.adapter = adapter
        applicationContext.assets.open(DATA_FILENAME).use { inputStream ->
            JsonReader(inputStream.reader()).use { jsonReader ->
                val vehicleType = object : TypeToken<List<VehicleList>>() {}.type
                val vehicleList: List<VehicleList> = Gson().fromJson(jsonReader, vehicleType)
                adapter.updateList(vehicleList)
            }
        }
    }

    override fun onRecyclerViewItemClick(_t: VehicleList) {
        val uri = String.format(
            Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)",
            _t.lati?.toDouble(), _t.long?.toDouble(), "")
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }


}
