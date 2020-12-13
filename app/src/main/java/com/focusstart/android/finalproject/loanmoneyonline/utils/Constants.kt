package com.focusstart.android.finalproject.loanmoneyonline.utils

object Constants {
    const val APP_PREFERENCES = "my_settings"
    const val APP_PREFERENCES_TOKEN = "bearer_token"
    const val APP_PREFERENCES_FIRST_LAUNCH = "first_launch_app"
    const val APP_PREFERENCES_LANGUAGE = "language_app"

    const val TAG_DEBUG = "debug_loan"
    const val TAG_ERROR = "error_app"

    const val BUNDLE_KEY_AMOUNT = "key_amount"
    const val BUNDLE_KEY_DATE = "key_date"
    const val BUNDLE_KEY_FIRST_NAME = "key_first_name"
    const val BUNDLE_KEY_ID = "key_id"
    const val BUNDLE_KEY_LAST_NAME = "key_last_name"
    const val BUNDLE_KEY_PERCENT = "key_percent"
    const val BUNDLE_KEY_PERIOD = "key_period"
    const val BUNDLE_KEY_PHONE_NUMBER = "key_phone_number"
    const val BUNDLE_KEY_STATE = "key_state"
    const val BUNDLE_KEY_REGISTRATION_NAME = "key_registration_name"
    const val BUNDLE_KEY_REGISTRATION_PASSWORD = "key_registration_password"

    const val CODE_BAD_REQUEST = 400
    const val CODE_NOT_FOUND = 404

    const val BASE_URL = "http://focusapp-env.eba-xm2atk2z.eu-central-1.elasticbeanstalk.com/"

    const val STATE_LOAN_FOR_NOTIFICATION = "APPROVED"
    const val COUNT_OF_DAYS_BEFORE_LOAN_EXPIRATION = 5
    const val DEFAULT_ID_NOTIFICATION = 1
    const val DEFAULT_ID_CHANNEL = "default_id_channel"
    const val DEFAULT_NAME_CHANNEL = "default_name_channel"
    const val UNIQUE_NAME_WORK_NOTIFICATION = "work_notification"
    const val COUNT_MILLISECONDS_IN_DAY = 1000 * 60 * 60 * 24
    const val REPEAT_INTERVAL_IN_WORK_MANAGER = 2L
    const val FLEX_INTERVAL_IN_WORK_MANAGER = 1L

}