package com.sbnri.pawankumarsbnri.database

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.sbnri.pawankumarsbnri.model.License
import com.sbnri.pawankumarsbnri.model.Permissions



class PermissionConverter {

    @TypeConverter
    fun permissionToString(app: Permissions): String = Gson().toJson(app)

    @TypeConverter
    fun stringToPermission(string: String): Permissions = Gson().fromJson(string, Permissions::class.java)
}
class LicenceConverter {

    @TypeConverter
    fun licenceToString(app: License?): String = Gson().toJson(app)

    @TypeConverter
    fun stringToLicence(license: String?): License? {
        if(license!=null){
            return Gson().fromJson(license, License::class.java)
        }else{
            return null
        }

    }
}
