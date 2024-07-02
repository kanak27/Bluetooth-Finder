package com.example.bluetooth_finder

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {

    private lateinit var listView : ListView
    private lateinit var statusTextView : TextView
    private lateinit var searchButton : Button
    private var bluetoothDevices = ArrayList<String>()
    private var addresses = ArrayList<String>()
    private lateinit var arrayAdapter: ArrayAdapter<*>

    private lateinit var bluetoothAdapter: BluetoothAdapter

    private val broadcastReceiver = object : BroadcastReceiver() {
        @SuppressLint("SetTextI18n")
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent?.action as String
            Log.i("Action", action)

            if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED == action){
                statusTextView.text = "Finished"
                searchButton.isEnabled = true
            } else if(BluetoothDevice.ACTION_FOUND == action){
                val device : BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                if (context?.let {
                        ActivityCompat.checkSelfPermission(
                            applicationContext,
                            Manifest.permission.BLUETOOTH_CONNECT
                        )
                    } != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }

                val name = device?.name
                val address = device?.address
                val rssi = intent.getShortExtra(BluetoothDevice.EXTRA_RSSI, Short.MIN_VALUE).toString()
                if (address != null) {
                    if (!addresses.contains(address)) {
                        addresses.add(address)
                        var deviceString = ""
                        deviceString = if (name == null || name == "") {
                            "$address - RSSI $rssi dBm"
                        } else {
                            "$name - RSSI $rssi dBm"
                        }
                        bluetoothDevices.add(deviceString)
                        arrayAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun search(view : View){
        statusTextView.text = "Searching..."
        searchButton.isEnabled = false
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.BLUETOOTH_SCAN
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(arrayOf(android.Manifest.permission.BLUETOOTH_SCAN), 1)
            return
        }
        addresses.clear()
        bluetoothDevices.clear()
        bluetoothAdapter.startDiscovery()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.deviceList)
        statusTextView = findViewById(R.id.statusTextView)
        searchButton = findViewById(R.id.searchButton)

        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bluetoothDevices)
        listView.adapter = arrayAdapter

        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()

        val intentFilter = IntentFilter()
        intentFilter.addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        intentFilter.addAction(BluetoothDevice.ACTION_FOUND)
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        intentFilter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        registerReceiver(broadcastReceiver, intentFilter)

    }
}