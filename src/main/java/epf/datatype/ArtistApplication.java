//  
//  ArtistApplication.java
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
@Entity(name = "epf_artist_application")
public class ArtistApplication extends Jsonable {
	@Id public String name;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("artist_id") @Index public Key<Artist> artistKey;
	@Ignore public Artist artist;
	@AlsoLoad("application_id") @Index public Key<Application> applicationKey;
	@Ignore public Application application;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonArtist = artist == null ? JsonNull.INSTANCE
				: artist.toJson();
		object.add("artist", jsonArtist);
		JsonElement jsonApplication = application == null ? JsonNull.INSTANCE
				: application.toJson();
		object.add("application", jsonApplication);
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
		if (jsonObject.has("artist")) {
			JsonElement jsonArtist = jsonObject.get("artist");
			if (jsonArtist != null) {
				artist = new Artist();
				artist.fromJson(jsonArtist.getAsJsonObject());
			}
		}
		if (jsonObject.has("application")) {
			JsonElement jsonApplication = jsonObject.get("application");
			if (jsonApplication != null) {
				application = new Application();
				application.fromJson(jsonApplication.getAsJsonObject());
			}
		}
	}
}