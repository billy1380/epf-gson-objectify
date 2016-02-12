//  
//  ApplicationDeviceType.java
//  epf-gson-objectify
//
//  Created by William Shakour on February 12, 2016.
//  Copyright © 2016 WillShex Limited. All rights reserved.
//
package epf.datatype;

import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.AlsoLoad;
import com.googlecode.objectify.annotation.Cache;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.willshex.gson.shared.Jsonable;

@Cache
@Entity(name = "epf_application_device_type")
public class ApplicationDeviceType extends Jsonable {
	@Id public String name;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("application_id") @Index public Key<Application> applicationKey;
	@Ignore public Application application;
	@AlsoLoad("device_type_id") @Index public Key<DeviceType> deviceTypeKey;
	@Ignore public DeviceType deviceType;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonApplication = application == null ? JsonNull.INSTANCE
				: application.toJson();
		object.add("application", jsonApplication);
		JsonElement jsonDeviceType = deviceType == null ? JsonNull.INSTANCE
				: deviceType.toJson();
		object.add("deviceType", jsonDeviceType);
		return object;
	}

	@Override
	public void fromJson (JsonObject jsonObject) {
		super.fromJson(jsonObject);
		if (jsonObject.has("exportDate")) {
			JsonElement jsonExportDate = jsonObject.get("exportDate");
			if (jsonExportDate != null) {
				exportDate = new Date(jsonExportDate.getAsLong());
			}
		}
		if (jsonObject.has("application")) {
			JsonElement jsonApplication = jsonObject.get("application");
			if (jsonApplication != null) {
				application = new Application();
				application.fromJson(jsonApplication.getAsJsonObject());
			}
		}
		if (jsonObject.has("deviceType")) {
			JsonElement jsonDeviceType = jsonObject.get("deviceType");
			if (jsonDeviceType != null) {
				deviceType = new DeviceType();
				deviceType.fromJson(jsonDeviceType.getAsJsonObject());
			}
		}
	}
}