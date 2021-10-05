# EasyPhotoPicker
Android easy photo picker (system camera, gallery) with ActivityResultLauncher

# step 1: Add it in your root build.gradle at the end of repositories:

```
allprojects {

  repositories {
  
    ...
    maven { url 'https://jitpack.io' }
    
  }
  
}
```

# step 2: Add the dependency

```
dependencies {

  implementation 'com.github.DJSeokHo:EasyPhotoPicker:1.1.1'
  
}
```

# step 3: Add the permission in AndroidManifest.xml
```
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
<uses-permission
    android:name="android.permission.WRITE_EXTERNAL_STORAGE"
    tools:ignore="ScopedStorage" />
```

# step 4: Add the provider in AndroidManifest.xml
```
<application
  '''
  >
  
  <provider
      android:name="androidx.core.content.FileProvider"
      android:authorities="${applicationId}.provider"
      android:exported="false"
      android:grantUriPermissions="true">
      <meta-data
          android:name="android.support.FILE_PROVIDER_PATHS"
          android:resource="@xml/file_paths" />
  </provider>
        
</application>
```

# step 5: Create file_paths.xml in xml folder in your res folder

res/xml/file_paths.xml
```
<paths xmlns:android="http://schemas.android.com/apk/res/android">
    <external-media-path name="media" android:path="@{string/app_name}/" path="/Pictures" />
    <files-path name="files" path="."/>
    <external-files-path name="media" path="/Pictures"/>
</paths>
```

# How to use:

in activity

```
class MainActivity : AppCompatActivity() {
    
    private val provider = "${your package name}.provider" // same as the authorities in your AndroidManifest.xml
    private val systemPhotoPickManager = SystemPhotoPickManager(this, provider)

    private val imageView: ImageView by lazy {
        findViewById(R.id.imageView)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView.setOnClickListener {

            systemPhotoPickManager.requestPermission {
                pickPhotoInUri(it)
            }

//            systemPhotoPickManager.requestPermission(
//                permissionDialogTitle = "permission",
//                permissionDialogMessage = "permissions are necessary",
//                permissionDialogPositiveButtonTitle = "setting"
//            ) {
//                pickPhotoInUri(it)
//            }

        }
    }

    private fun pickPhotoInUri(systemPhotoPickManager: SystemPhotoPickManager) {
        systemPhotoPickManager.selectPicture { uri ->
            imageView.setImageURI(uri)
        }
    }

    private fun pickPhotoInFilePath(systemPhotoPickManager: SystemPhotoPickManager) {
        systemPhotoPickManager.selectPathPicture { filePath ->
            imageView.setImageBitmap(BitmapFactory.decodeFile(filePath))
        }
    }

    private fun takePhotoInFilePath(systemPhotoPickManager: SystemPhotoPickManager) {
        systemPhotoPickManager.takePictureWithFilePath(true) { filePath ->
            imageView.setImageBitmap(BitmapFactory.decodeFile(filePath))
        }
    }

    private fun takePhotoInBitmap(systemPhotoPickManager: SystemPhotoPickManager) {
        systemPhotoPickManager.takePictureWithBitmap { bitmap ->
            imageView.setImageBitmap(bitmap)
        }
    }

    private fun takePhotoUri(systemPhotoPickManager: SystemPhotoPickManager) {
        systemPhotoPickManager.takePictureWithUri { uri ->
            imageView.setImageURI(uri)
        }
    }
}
```

in fragment

```
class YourFragment : Fragment() {

    private val provider = "${your package name}.provider" // same as the authorities in your AndroidManifest.xml
    private lateinit var systemPhotoPickManager = SystemPhotoPickManager
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    
        systemPhotoPickManager = SystemPhotoPickManager(this, provider)
       
    }
    
}
```
