package kz.edu.astanait.playground

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.util.*
import kotlin.collections.ArrayList


class Image(val context: Context) : MainActivityView{
    private var storage : FirebaseStorage = FirebaseStorage.getInstance()
    private var storageRef: StorageReference = storage.reference

    override fun uploadImage(uri: Uri){
//        val progressDialog : ProgressDialog = ProgressDialog(context)
//        progressDialog.setTitle("Загрузка")
//        progressDialog.show()

        val ref: StorageReference = storageRef.child("images/" + UUID.randomUUID().toString())
        ref.putFile(uri)
            .addOnSuccessListener {
//                progressDialog.dismiss()
                Toast.makeText(context, "Uploaded", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener { e ->
//                progressDialog.dismiss()
                Toast.makeText(context, "Failed " + e.message, Toast.LENGTH_SHORT).show()
            }
            .addOnProgressListener { taskSnapshot ->
                val progress = 100.0 * taskSnapshot.bytesTransferred / taskSnapshot
                    .totalByteCount
//                progressDialog.setMessage("Uploaded " + progress.toInt() + "%")
            }
    }

    override fun downloadImages() : ArrayList<Uri>{
//        storageRef.storage.getReferenceFromUrl("gs://bucket")
        return ArrayList()
    }
}