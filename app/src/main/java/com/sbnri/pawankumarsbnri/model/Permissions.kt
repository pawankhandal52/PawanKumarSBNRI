package com.sbnri.pawankumarsbnri.model

import com.google.gson.annotations.SerializedName
import io.realm.RealmObject

data class Permissions(

	@field:SerializedName("pull")
	var pull: Boolean? = null,

	@field:SerializedName("admin")
	var admin: Boolean? = null,

	@field:SerializedName("push")
	var push: Boolean? = null
)