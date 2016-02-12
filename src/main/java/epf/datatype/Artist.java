//  
//  Artist.java
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
@Entity(name = "epf_artist")
public class Artist extends Jsonable {
	@Id public Long id;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("name") public String name;
	@AlsoLoad("is_actual_artist") public Boolean isActualArtist;
	@AlsoLoad("view_url") public String viewUrl;
	@AlsoLoad("artist_type_id") @Index public Key<ArtistType> artistTypeKey;
	@Ignore public ArtistType artistType;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonName = name == null ? JsonNull.INSTANCE
				: new JsonPrimitive(name);
		object.add("name", jsonName);
		JsonElement jsonIsActualArtist = isActualArtist == null
				? JsonNull.INSTANCE : new JsonPrimitive(isActualArtist);
		object.add("isActualArtist", jsonIsActualArtist);
		JsonElement jsonViewUrl = viewUrl == null ? JsonNull.INSTANCE
				: new JsonPrimitive(viewUrl);
		object.add("viewUrl", jsonViewUrl);
		JsonElement jsonArtistType = artistType == null ? JsonNull.INSTANCE
				: artistType.toJson();
		object.add("artistType", jsonArtistType);
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
		if (jsonObject.has("isActualArtist")) {
			JsonElement jsonIsActualArtist = jsonObject.get("isActualArtist");
			if (jsonIsActualArtist != null) {
				isActualArtist = Boolean
						.valueOf(jsonIsActualArtist.getAsBoolean());
			}
		}
		if (jsonObject.has("viewUrl")) {
			JsonElement jsonViewUrl = jsonObject.get("viewUrl");
			if (jsonViewUrl != null) {
				viewUrl = jsonViewUrl.getAsString();
			}
		}
		if (jsonObject.has("artistType")) {
			JsonElement jsonArtistType = jsonObject.get("artistType");
			if (jsonArtistType != null) {
				artistType = new ArtistType();
				artistType.fromJson(jsonArtistType.getAsJsonObject());
			}
		}
	}
}