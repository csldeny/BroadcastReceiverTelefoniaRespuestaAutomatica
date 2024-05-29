package com.example.broadcasttel.model

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.view.Gravity
import android.widget.Toast

class CallReceiver : BroadcastReceiver() {
    fun showToastMsg(context: Context, msg: String) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent!!.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_OFFHOOK) {
            showToastMsg(context!!, msg = "LA LLAMADA ESTA INICIANDO")
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_IDLE){
            showToastMsg(context!!, msg = "LA LLAMADA ESTA TERMINANDO")
        }else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE) == TelephonyManager.EXTRA_STATE_RINGING){
            showToastMsg(context!!, msg = "LLAMADA ENTRNTE")

        }else{
            showToastMsg(context!!, msg = "NADA")
        }
    }
}