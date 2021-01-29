package kz.edu.astanait.playground

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kz.edu.astanait.playground.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainActivityView{
    private val CODE = 900

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    private var uri : Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityContext = applicationContext

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]



        binding.btnChooseImage.setOnClickListener {
            chooseImage()
        }
        binding.btnUploadImage.setOnClickListener {
            uploadImage(uri!!)
        }
    }

    override fun uploadImage(uri: Uri) {
        viewModel.uploadImage(uri)
    }

    override fun downloadImages() : ArrayList<Uri> {
        return ArrayList()
    }

    private fun chooseImage(){
        val intent : Intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Выберите фотографию"),CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == CODE && resultCode == RESULT_OK && data != null && data.data != null){
            uri = data.data
        }
    }

    companion object{
        lateinit var activityContext : Context
    }
}