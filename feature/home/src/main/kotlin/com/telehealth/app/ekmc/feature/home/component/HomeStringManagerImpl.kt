package com.telehealth.app.ekmc.feature.home.component

import android.content.Context
import androidx.annotation.StringRes
import com.telehealth.app.ekmc.core.common.R

class HomeStringManagerImpl(
    private val context: Context,
) : HomeStringManager {

    override fun getString(input: HomeMessageCode): String {
        @StringRes
        val id: Int = when (input) {
            HomeMessageCode.GetKmcListError -> R.string.get_data_error
            HomeMessageCode.ExportError -> R.string.export_error
            HomeMessageCode.ExportSuccess -> R.string.export_success
        }

        return context.getString(id)
    }
}