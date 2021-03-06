//  
//  ArtistType.java
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
@Entity(name = "epf_artist_type")
public class ArtistType extends Jsonable {
	@Id public Long id;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("name") public String name;
	@AlsoLoad("primary_media_type_id") @Index public Key<MediaType> primaryMediaTypeKey;
	@Ignore public MediaType primaryMediaType;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonName = name == null ? JsonNull.INSTANCE
				: new JsonPrimitive(name);
		object.add("name", jsonName);
		JsonElement jsonPrimaryMediaType = primaryMediaType == null
				? JsonNull.INSTANCE : primaryMediaType.toJson();
		object.add("primaryMediaType", jsonPrimaryMediaType);
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
		if (jsonObject.has("name")) {
			JsonElement jsonName = jsonObject.get("name");
			if (jsonName != null) {
				name = jsonName.getAsString();
			}
		}
		if (jsonObject.has("primaryMediaType")) {
			JsonElement jsonPrimaryMediaType = jsonObject
					.get("primaryMediaType");
			if (jsonPrimaryMediaType != null) {
				primaryMediaType = new MediaType();
				primaryMediaType
						.fromJson(jsonPrimaryMediaType.getAsJsonObject());
			}
		}
	}
}