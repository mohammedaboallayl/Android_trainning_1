package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var loginbtn:Button
    private lateinit var signuppage:TextView
    private lateinit var mobilePhone:EditText
    private lateinit var password:EditText
    private lateinit var validation:Array<Actions>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        loginbtn.setOnClickListener {
            var check=true
            for (i in validation){
                if (i.CheckMatching()){
                    continue
                }else{
                    check=false
                    break
                }
            }
            if(check){
                startActivity(Intent(this,MainActivity3::class.java))
            }

        }
        signuppage.setOnClickListener {
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }
    private fun init(){
        loginbtn=findViewById(R.id.m1loginBtn)
        signuppage=findViewById(R.id.m1signup)
        mobilePhone=findViewById(R.id.m1phoneNumEd)
        password=findViewById(R.id.m1passEd)
        validation= arrayOf(
                Actions(mobilePhone, "\\d{11}","Phone Number must be eleven number"),
                Actions(password, "([a-zA-Z0-9]){8,}","password must be more than 8 and contains digits and letters"),
        )
    }
    public fun Actions.CheckMatching():Boolean{
        if(!this.IsMatch()){
            Toast.makeText(baseContext,this.EMessage, Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }
}