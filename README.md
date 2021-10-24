# Insta Downloader 
Simple Instagram Image Video Downloader Library for Android

[![JitPack](https://jitpack.io/v/kannikesh/Instagram_Image_Video_Downloader.svg)](https://jitpack.io/#kannikesh/Instagram_Image_Video_Downloader)

## Implementation

>Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```bash
    	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

>Step 2. Add the dependency

```bash

	dependencies {
	        implementation 'com.github.kannikesh:Instagram_Image_Video_Downloader:Tag'
	}

```

>Step 3. Add the following permissions in the Manifest file.

```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```

>Step 4. Don't forget to ask storage permissions. Add the following code in your MainActivity.

```java
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

## Usage
```java
ImageDownloader.downloadImage(Context, Post URL);
```
>OR

```java
VideoDownloader.downloadVideo(Context, Post URL);
```
If you want to make your directory then use:

```java
VideoDownloader.downloadVideo(Context, Reels/IGTV video url, your directory name); // it'll create new folder in gallery with provided directory name.
```

You are free to contribute here. This is first version. I'll add more awesome updates in near future.

### Made with ❤️ by Kannikesh
