//package com.swein.easyphotopicker.demo
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import com.swein.easyphotopicker.R
//import com.swein.easyphotopicker.SystemPhotoPickManager
//
//class EasyPhotoPickDemoFragment : Fragment() {
//
//    companion object {
//
//        @JvmStatic
//        fun newInstance() =
//            EasyPhotoPickDemoFragment().apply {
//                arguments = Bundle().apply {
//
//                }
//            }
//    }
//
//    private lateinit var systemPhotoPickManager: SystemPhotoPickManager
//
//    private lateinit var imageView: ImageView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//
//        }
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_easy_photo_pick_demo, container, false)
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        systemPhotoPickManager = SystemPhotoPickManager(requireActivity(), "com.swein.easyphotopicker.provider")
//
//        imageView = view.findViewById(R.id.imageView)
//
//        imageView.setOnClickListener {
//
//            systemPhotoPickManager.requestPermission {
//
//                it.selectPicture { uri ->
//
//                    imageView.setImageURI(uri)
//
//                }
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
////            it.takePictureWithUri { uri ->
////                SHGlide.setImage(imageView, uri = uri)
////            }
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
//
//}