//  
//  GenreApplication.java
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
@Entity(name = "epf_genre_application")
public class GenreApplication extends Jsonable {
	@Id public String name;
	@AlsoLoad("export_date") public Date exportDate;
	@AlsoLoad("genre_id") @Index public Key<Genre> genreKey;
	@Ignore public Genre genre;
	@AlsoLoad("application_id") @Index public Key<Application> applicationKey;
	@Ignore public Application application;
	@AlsoLoad("is_primary") public Boolean isPrimary;

	@Override
	public JsonObject toJson () {
		JsonObject object = super.toJson();
		JsonElement jsonExportDate = exportDate == null ? JsonNull.INSTANCE
				: new JsonPrimitive(exportDate.getTime());
		object.add("exportDate", jsonExportDate);
		JsonElement jsonGenre = genre == null ? JsonNull.INSTANCE
				: genre.toJson();
		object.add("genre", jsonGenre);
		JsonElement jsonApplication = application == null ? JsonNull.INSTANCE
				: application.toJson();
		object.add("application", jsonApplication);
		JsonElement jsonIsPrimary = isPrimary == null ? JsonNull.INSTANCE
				: new JsonPrimitive(isPrimary);
		object.add("isPrimary", jsonIsPrimary);
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
		if (jsonObject.has("genre")) {
			JsonElement jsonGenre = jsonObject.get("genre");
			if (jsonGenre != null) {
				genre = new Genre();
				genre.fromJson(jsonGenre.getAsJsonObject());
			}
		}
		if (jsonObject.has("application")) {
			JsonElement jsonApplication = jsonObject.get("application");
			if (jsonApplication != null) {
				application = new Application();
				application.fromJson(jsonApplication.getAsJsonObject());
			}
		}
		if (jsonObject.has("isPrimary")) {
			JsonElement jsonIsPrimary = jsonObject.get("isPrimary");
			if (jsonIsPrimary != null) {
				isPrimary = Boolean.valueOf(jsonIsPrimary.getAsBoolean());
			}
		}
	}
}