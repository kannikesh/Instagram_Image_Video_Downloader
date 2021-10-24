# Insta Downloader 
Simple Instagram Image Video Downloader Library for Android

>Step 1. Add the JitPack repository to your build file

```gradle
    	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

>Step 2. Add the dependency

```gradle

dependencies {
	        implementation 'com.github.kannikesh:Instagram_Image_Video_Downloader:Tag'
	}

```

>Step 3. Add the following permissions in the Manifest file.

```    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

>Step 4. Don't forget to ask storage permissions. Add the following code in your MainActivity.

```
if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        else { //you dont need to worry about these stuff below api level 23

        }

```

>Step 5. Usage

```InstagramImages.downloadImage(Context, Post URL) ```
