package com.turin.poketinder.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.turin.poketinder.data.User
import com.turin.poketinder.databinding.ActivityLoginBinding
import com.turin.poketinder.util.SharedPreferenceUtil

class LoginActivity : BaseActivity<ActivityLoginBinding>(ActivityLoginBinding::inflate){

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil=SharedPreferenceUtil().also{
            it.setSharedPreference(this)
        }
    }

    fun validateInput(){
        if(binding.edtEmail.text.isEmpty() && binding.edtPassword.text.isEmpty()){
            //Agregar toast
        }
    }

    fun startLogin(view: View){
        //validateInput()
        val user: User? = sharedPreferenceUtil.getUser()

        if(user?.email.equals(binding.edtEmail.text.toString()) && user?.password.equals(binding.edtPassword.text.toString())){
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", user)
                startActivity(intent)
        }else{
            Toast.makeText(this,"Error Usuario",Toast.LENGTH_SHORT).show()
        }
    }
}