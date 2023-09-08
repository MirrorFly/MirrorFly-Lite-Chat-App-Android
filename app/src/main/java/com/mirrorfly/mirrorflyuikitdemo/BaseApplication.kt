package com.mirrorfly.mirrorflyuikitdemo

import android.app.Application
import com.mirrorfly.uikitsdk.MirrorFlyUIKit
import com.mirrorfly.uikitsdk.adapter.MirrorFlyUIKitAdapter

class BaseApplication:Application() {

    override fun onCreate() {
        super.onCreate()

        MirrorFlyUIKit.initFlySDK(applicationContext,object : MirrorFlyUIKitAdapter {

            override fun setAppName(): String? {
                return "MirrorFlyUIKit"
            }

            override fun setApplicationID(): String? {
                return "com.mirrorfly.mirrorflyuikitdemo"
            }

            //Below override methods are optional used for customization

            override fun isCallEnabled(): Boolean? {
                return false
            }

            override fun isGroupEnable(): Boolean? {
                return true
            }

            override fun isContactEnable(): Boolean? {
                return true
            }

            override fun isLogoutEnable(): Boolean? {
                return true
            }

            override fun isOtherProfileEnable(): Boolean? {
                return true
            }

            override fun isOwnProfileEnable(): Boolean? {
                return false
            }

            override fun setGoogleTranslationKey(): String? {
                return "Google Translation Key"
            }

            override fun onlyOnetoOneChat(): Boolean? {
                return false
            }

            override fun isSettingsOptionEnable(): Boolean? {
                return false
            }
        })

        MirrorFlyUIKit.defaultThemeMode = MirrorFlyUIKit.ThemeMode.Light
        MirrorFlyUIKit.loginActivity = LoginActivity::class.java
    }
}