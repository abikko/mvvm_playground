package kz.edu.astanait.playground

import android.net.Uri

interface MainActivityView {
    fun uploadImage(uri: Uri)
    fun downloadImages() : ArrayList<Uri>
}