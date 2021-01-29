package kz.edu.astanait.playground

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel(), MainActivityView {
    private var model : Image = Image(MainActivity.activityContext)
    var _images : MutableLiveData<ArrayList<Uri>> = MutableLiveData()

    init{
//        _images.value = model.downloadImages()
    }

    override fun uploadImage(uri: Uri) {
        model.uploadImage(uri)
    }

    override fun downloadImages() : ArrayList<Uri>{
        return ArrayList()
    }
}