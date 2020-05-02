package com.example.gtropy.ui.model

import com.google.gson.annotations.SerializedName

data class VehicleList(

	@field:SerializedName("CompanyId")
	val companyId: String? = null,

	@field:SerializedName("Device")
	val device: String? = null,

	@field:SerializedName("DriverName")
	val driverName: String? = null,

	@field:SerializedName("VehicleId")
	val vehicleId: String? = null,

	@field:SerializedName("Imei")
	val imei: String? = null,

	@field:SerializedName("ExtraInfo")
	val extraInfo: String? = null,

	@field:SerializedName("Mobile")
	val mobile: String? = null,

	@field:SerializedName("Lati")
	val lati: Double? = null,

	@field:SerializedName("Date")
	val date: String? = null,

	@field:SerializedName("TrackNum")
	val trackNum: String? = null,

	@field:SerializedName("Vehicle")
	val vehicle: String? = null,

	@field:SerializedName("DriverMobile")
	val driverMobile: String? = null,

	@field:SerializedName("Moving")
	val moving: String? = null,

	@field:SerializedName("Long")
	val long: Double? = null,

	@field:SerializedName("NoDate")
	val noDate: String? = null,

	@field:SerializedName("Location")
	val location: String? = null
)
