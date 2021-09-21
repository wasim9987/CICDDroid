package com.commerceup.retirementcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCenter.start(application, "7df3e765-f616-4e29-990b-27f7e7534cb9", Analytics::class.java, Crashes::class.java)

        calculateButton.setOnClickListener {
//            Crashes.generateTestCrash();
            val interestRate = interestEditText.text.toString().toFloat();
            val currentAge = ageEditText.text.toString().toInt()
            val retirementAge = retirementEditText.text.toString().toInt()
            if(interestRate <= 0){
                Analytics.trackEvent( "wrong_interest_rate");
            }
            if(retirementAge <= currentAge){
                Analytics.trackEvent("wrong_age")
            }
        }
    }
}