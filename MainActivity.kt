package com.example.webview

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            if(TextUtils.isEmpty(edt.text.toString()))
            {
                edt.error="Enter some error.."
            }
            else
            {
                var str=edt.text.toString()
                val intent=Intent(this@MainActivity,WebviewActivity::class.java)
                intent.putExtra("url_str",str)
                startActivity(intent)
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId)
        {
            R.id.red -> background.setBackgroundColor(Color.parseColor("#FF0000"))
            R.id.blue -> background.setBackgroundColor(Color.parseColor("#0000FF"))
            R.id.reset -> background.setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        return super.onOptionsItemSelected(item)
    }
}
