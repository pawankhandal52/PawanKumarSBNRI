package com.sbnri.pawankumarsbnri.model

import com.google.gson.annotations.SerializedName

data class License(

	@field:SerializedName("name")
	var name: String? = null,

	@field:SerializedName("spdx_id")
	var spdxId: String? = null,

	@field:SerializedName("key")
	var key: String? = null,

	@field:SerializedName("url")
	var url: String? = null,

	@field:SerializedName("node_id")
	var nodeId: String? = null
)