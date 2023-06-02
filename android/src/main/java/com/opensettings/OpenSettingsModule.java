package com.opensettings;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = OpenSettingsModule.NAME)
public class OpenSettingsModule extends ReactContextBaseJavaModule {
  public static final String NAME = "OpenSettings";
  private ReactApplicationContext reactContext;
  public OpenSettingsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  @ReactMethod
  public void openSettings(String value) {
    switch (0) {
      default:
        if ("general".equals(value)) {
          Intent intent1 = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
          Uri uri1 = Uri.fromParts("package", reactContext.getPackageName(), null);
          intent1.setData(uri1);
          intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent1);
          break;
        }
        if ("location".equals(value)) {
          Intent intent2 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
          intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent2);
          break;
        }
        if ("network".equals(value)) {
          Intent intent3 = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
          intent3.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent3);
          break;
        }
        if ("security".equals(value)) {
          Intent intent5 = new Intent(Settings.ACTION_SECURITY_SETTINGS);
          intent5.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent5);
          break;
        }
        if ("deviceinfo".equals(value)) {
          Intent intent6 = new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS);
          intent6.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent6);
          break;
        }
        if ("backup".equals(value)) {
          Intent intent7 = new Intent(Settings.ACTION_PRIVACY_SETTINGS);
          intent7.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent7);
          break;
        }
        if ("sound".equals(value)) {
          Intent intent8 = new Intent(Settings.ACTION_SOUND_SETTINGS);
          intent8.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent8);
          break;
        }
        if ("home".equals(value)) {
          Intent intent9 = new Intent(Settings.ACTION_HOME_SETTINGS);
          intent9.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent9);
          break;
        }
        if ("date".equals(value)) {
          Intent intent10 = new Intent(Settings.ACTION_DATE_SETTINGS);
          intent10.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent10);
          break;
        }
        if ("applications".equals(value)) {
          Intent intent11 = new Intent(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
          intent11.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          reactContext.startActivity(intent11);
          break;
        }
    }
  }

  @ReactMethod
  public void locationSettings() {
    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
    if (intent.resolveActivity(reactContext.getPackageManager()) != null) {
      reactContext.startActivity(intent);
    }
  }
}
