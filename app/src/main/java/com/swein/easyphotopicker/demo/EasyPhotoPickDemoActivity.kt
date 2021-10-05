//package com.swein.easyphotopicker.demo
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.ImageView
//import com.swein.easyphotopicker.R
//import com.swein.easyphotopicker.SystemPhotoPickManager
//
//class EasyPhotoPickDemoActivity : AppCompatActivity() {
//
//    private val systemPhotoPickManager = SystemPhotoPickManager(this, "com.swein.easyphotopicker.provider")
//
//    private val imageView: ImageView by lazy {
//        findViewById(R.id.imageView)
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_easy_photo_pick_demo)
//
//        supportFragmentManager.beginTransaction().replace(R.id.container, EasyPhotoPickDemoFragment.newInstance(), "TAG").commitAllowingStateLoss()
//
//        imageView.setOnClickListener {
//
//            systemPhotoPickManager.requestPermission {
//
////                it.selectPicture { uri ->
////
////                    imageView.setImageURI(uri)
////
////                }
//
////                it.selectPathPicture { filePath ->
////                    ILog.debug("???", filePath)
////
////
////
//////                    FirebaseStorageManager.uploadImage(
//////                        uploadPath = FirebaseStorageManager.FILE_STORAGE_DOMAIN,
//////                        type = FirebaseStorageManager.StorageFileType.FILE,
//////                        filePath = FirebaseStorageManager.MEMBER_IMAGE_FOLDER,
//////                        fileName = "test.jpg",
//////                        onSuccess = { imageUrl ->
//////                            SHGlide.setImage(imageView, url = imageUrl)
//////                        },
//////                        onFailure = {
//////                            Toast.makeText(this@FirebaseStorageActivity, "error", Toast.LENGTH_SHORT).show()
//////                        }
//////                    )
////                }
//
////                it.takePictureWithFilePath(true) { filePath ->
////                    SHGlide.setImage(imageView, filePath = filePath)
////                }
//
//            it.takePictureWithUri { uri ->
//                imageView.setImageURI(uri)
//            }
//
////            it.takePictureWithBitmap { bitmap ->
////                SHGlide.setImage(imageView, bitmap = bitmap)
////            }
//
//            }
//
//        }
//    }
//
//    override fun onBackPressed() {
//
//        supportFragmentManager.findFragmentByTag("TAG")?.let {
//
//            supportFragmentManager.beginTransaction().remove(it).commitAllowingStateLoss()
//            return
//        }
//
//        finish()
//    }
//}