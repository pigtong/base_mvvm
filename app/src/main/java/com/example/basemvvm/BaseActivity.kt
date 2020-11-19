package com.example.basemvvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.basemvvm.utils.LocaleManager

class BaseActivity : AppCompatActivity(){

    //In case language-manually change required
    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(newBase?:baseContext))
    }
}