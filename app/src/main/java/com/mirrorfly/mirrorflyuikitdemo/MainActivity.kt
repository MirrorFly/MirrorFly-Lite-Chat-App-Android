package com.mirrorfly.mirrorflyuikitdemo

import android.os.Bundle
import com.mirrorfly.uikitsdk.activities.DashBoardActivity

class MainActivity : DashBoardActivity() { // Add this line.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // If you’re going to inherit `DashBoardActivity`, don’t implement `setContentView()`
    }
}