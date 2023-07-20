package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var signup:Button
    private lateinit var phonenumber:EditText
    private lateinit var email:EditText
    private lateinit var city:EditText
    private lateinit var password:EditText
    private lateinit var loginpage:TextView
    private lateinit var checkBox: CheckBox
    private lateinit var validation:Array<Actions>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        init()
        signup.setOnClickListener {
            var check=true
            for (i in validation){
                if (i.CheckMatching()){
                    continue
                }else{
                    check=false
                   break
                }
            }
            if(check && checkBox.isChecked){
                startActivity(Intent(baseContext,MainActivity3::class.java))
            }else if (!checkBox.isChecked){
             Toast.makeText(this,"Please you have to agree our policy",Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun init(){
        signup=findViewById(R.id.m2signupBtn)
        email=findViewById(R.id.m2emailET)
        password=findViewById(R.id.m2passEd)
        phonenumber=findViewById(R.id.m2phoneNumEd)
        city=findViewById(R.id.m2cityET)
        validation= arrayOf(
            Actions(phonenumber, "\\d{11}","Phone Number must be eleven number"),
            Actions(email, "([a-zA-Z]|[0-9]|\\.|\\-|\\_)+\\@([a-zA-Z]|[0-9])+\\.com","it is not valid email"),
            Actions(password, "([a-zA-Z0-9]){8,}","password must be more than 8 character and contains digits and letters only"),
            Actions(city, "[a-zA-Z]{2,}","unValid city"),
        )
        loginpage=findViewById(R.id.m2loginET)
        checkBox=findViewById(R.id.checkbox)
    }
    public fun Actions.CheckMatching():Boolean{
         if(!this.IsMatch()){
            Toast.makeText(baseContext,this.EMessage,Toast.LENGTH_LONG).show()
             return false
        }
        return true
    }
}