package com.ibsystem.temiassistant.presentation.screen.settings

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.robotemi.sdk.Robot
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel() {
    private val mRobot = Robot.getInstance()

    private val _isSpeakerOn: MutableStateFlow<Boolean> = MutableStateFlow(true)
    var isSpeakerOn = _isSpeakerOn.asStateFlow()

    private val _isDetectionOn: MutableStateFlow<Boolean> = MutableStateFlow(false)
    var isDetectionOn = _isDetectionOn.asStateFlow()

    private val _textPreference: MutableStateFlow<String> = MutableStateFlow("")
    var textPreference = _textPreference.asStateFlow()

    private val _intPreference: MutableStateFlow<Int> = MutableStateFlow(0)
    var intPreference = _intPreference.asStateFlow()

    private val _connectivityState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val connectivityState = _connectivityState.asStateFlow()




    fun toggleSwitch(switch: Int){
        when(switch) {
            SPEAKER_SWITCH -> _isSpeakerOn.value = _isSpeakerOn.value.not()
            DETECTION_SWITCH -> {
                _isDetectionOn.value = _isDetectionOn.value.not()
                mRobot.setDetectionModeOn(_isDetectionOn.value, 2.0f)
            }
            else -> Log.i("Settings", "ERROR TOGGLE NON EXIST")
        }
    }

    fun saveText(finalText: String) {
        _textPreference.value = finalText
        // place to store text
    }

    // just checking, if it is not empty - but you can check anything
    fun checkTextInput(text: String) = text.isNotEmpty()

    companion object {
        const val SPEAKER_SWITCH = 0
        const val DETECTION_SWITCH = 1

        private var instance: SettingsViewModel? = null

        fun getInstance(): SettingsViewModel {
            if (instance == null) {
                instance = SettingsViewModel()
            }
            return instance!!
        }
    }

}